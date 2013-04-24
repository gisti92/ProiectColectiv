/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cadru_Didactic;

import validation.FieldValidationException;

/**
 *
 * @author S7eve
 */
public class RepositoryBD {

    private static RepositoryBD instance = null;
    private String propsFileName = "src/persistence/db.properties";
    private Properties props = null;
    private Connection myConnection; // TODO remove this

    private RepositoryBD() {
        props = getProperties();
        myConnection = getConnection();
    }

    public static RepositoryBD getInstance() {
        if (instance == null) {
            instance = new RepositoryBD();
        }
        return instance;
    }

    private Properties getProperties() {
        props = new Properties(System.getProperties());
        try {
            props.load(new FileReader(propsFileName));
        } catch (IOException e) {
            throw new RuntimeException("Eroare la incarcarea proprietatiilor din fisierul \"" + propsFileName + "\": " + e);
        }
        return props;
    }

    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(props.getProperty("jdbc.driver"));
            con = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.user"),
                    props.getProperty("jdbc.pass"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Eroare incarcare driver " + e.toString());
        } catch (SQLException e) {
            throw new RuntimeException("Eroare stabilire conexiune " + e.toString());
        }
        return con;
    }

    public char getPermission(String user, char[] pass) throws Exception {
        myConnection = getConnection();
        ResultSet rs = null;
        try {
            PreparedStatement statement = myConnection.prepareStatement("SELECT permissiune FROM logins WHERE userid = ? AND pass = ?");
            statement.setString(1, user);
            statement.setString(2, String.valueOf(pass));
            rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getString("permissiune").charAt(0);
            } else {
                return 'R';
            }
        } catch (SQLException e) {
            throw new Exception(e.toString());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (myConnection != null) {
                    myConnection.close();
                }
            } catch (SQLException e) {
                throw new Exception(e.toString());
            }
        }
    }

    public boolean importOrar(String fileOrar) {
        try {
            BufferedReader readFromFile = new BufferedReader(new FileReader(fileOrar));
            String lineFromFile;
            while ((lineFromFile = readFromFile.readLine()) != null) {
                String[] lineSplit = lineFromFile.split("\\;|-");
                parseAndAddLineToOrarDB(lineSplit);
            }
            readFromFile.close();
        } // TODO throw messages to UI
        catch (FieldValidationException e) {
            System.out.println(e.toString());
            return false;
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            return false;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    private void parseAndAddLineToOrarDB(String[] lineSplit) throws FieldValidationException, NumberFormatException,
            SQLException {
        if (lineSplit.length != 9) {
            throw new FieldValidationException("Length does not equal number of fields in DB");
        }

        String ziua = lineSplit[0];
        Integer deLaOra = Integer.parseInt(lineSplit[1]);
        Integer panaLaOra = Integer.parseInt(lineSplit[2]);
        Integer frecventa = Integer.parseInt(lineSplit[3]);
        Integer codDisciplina = Integer.parseInt(lineSplit[4]);
        String tip = lineSplit[5];
        Integer codCadruDidactic = Integer.parseInt(lineSplit[6]);
        Integer codSala = Integer.parseInt(lineSplit[7]);
        Integer codFormatie = Integer.parseInt(lineSplit[8]);
        // TODO add tip to database !!!!!!!!!!!

        if (tip.length() != 1) {
            throw new FieldValidationException("Tip must contain only 1 character!");
        }

        addDataToOrarDB(ziua, deLaOra, panaLaOra, frecventa, codDisciplina, tip, codCadruDidactic, codSala, codFormatie);
    }

    private void addDataToOrarDB(String ziua, Integer deLaOra, Integer panaLaOra, Integer frecventa,
            Integer codDisciplina, String tip, Integer codCadruDidactic, Integer codSala, Integer codFormatie)
            throws SQLException {
        Connection conn = getConnection();

        PreparedStatement p = conn.prepareStatement("Insert into orar values(?,?,?,?,?,?,?,?,?)");
        p.setString(1, ziua);
        p.setInt(2, deLaOra);
        p.setInt(3, panaLaOra);
        p.setInt(4, frecventa);
        p.setInt(5, codDisciplina);
        p.setString(6, tip);
        p.setInt(7, codCadruDidactic);
        p.setInt(8, codSala);
        p.setInt(9, codFormatie);
        p.executeUpdate();
    }

    public boolean importStateDeFunctii(String file) {
        BufferedReader readFromFile = null;
        try {
            readFromFile = new BufferedReader(new FileReader(file));
            String lineFromFile;
            Integer idCadruDidactic = 0;
            while ((lineFromFile = readFromFile.readLine()) != null) {
                String[] lineSplit = lineFromFile.split("\\,|;");
                if (lineSplit.length == 5) {
                    Cadru_Didactic cd = parseLineToCadruDidactic(lineSplit);
                    idCadruDidactic = adaugaCadruDidactic(cd);
                } else if (lineSplit.length == 9) {
                    parseAndAddLineToStateDB(idCadruDidactic, lineSplit);
                } else if (lineSplit.length == 1) {// TODO decide on a separator
                    lineFromFile = readFromFile.readLine();
                    lineSplit = lineFromFile.split("\\,|;");
                    parseAndAddAlteActivitatiCDToDB(idCadruDidactic, lineSplit);
                    idCadruDidactic = 0;
                } else {
                    throw new FieldValidationException("Invalid field numbers");
                }

            }
        } // TODO throw messages to UI
        catch (FieldValidationException e) {
            System.out.println(e.toString());
            return false;
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            return false;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            if (readFromFile != null) {
                try {
                    readFromFile.close();
                } catch (IOException e) {
                    System.out.println(e.toString());
                    return false;
                }
            }
        }
        return true;
    }

    private void parseAndAddAlteActivitatiCDToDB(Integer idCadruDidactic, String[] lineSplit)
            throws FieldValidationException, NumberFormatException, SQLException {
        if (idCadruDidactic == 0) {
            throw new FieldValidationException("Field idCadruDidactic incorrect");
        }

        Integer pregAdmitere = Integer.parseInt(lineSplit[0]);
        Integer comisiiAbsolvire = Integer.parseInt(lineSplit[1]);
        Integer consultatii = Integer.parseInt(lineSplit[2]);
        Integer examene = Integer.parseInt(lineSplit[3]);
        Integer indrLucrDisert = Integer.parseInt(lineSplit[4]);
        Integer indrLucrLic = Integer.parseInt(lineSplit[5]);
        Integer indrProiect = Integer.parseInt(lineSplit[6]);
        Integer lucrControl = Integer.parseInt(lineSplit[7]);
        Integer seminariiCerc = Integer.parseInt(lineSplit[8]);

        addDataToAlteActivitatiCDToDB(idCadruDidactic, pregAdmitere, comisiiAbsolvire, consultatii, examene,
                indrLucrDisert, indrLucrLic, indrProiect, lucrControl, seminariiCerc);
    }

    private void addDataToAlteActivitatiCDToDB(int idCadruDidactic, int pregAdmitere, int comisiiAbsolvire, int consultatii, int examene,
            int indrLucrDisert, int indrLucrLic, int indrProiect, int lucrControl, int seminariiCerc) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement p = conn.prepareStatement("Insert into Alte_Activitati_CD values(?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, idCadruDidactic);
        p.setInt(2, pregAdmitere);
        p.setInt(3, comisiiAbsolvire);
        p.setInt(4, consultatii);
        p.setInt(5, examene);
        p.setInt(6, indrLucrDisert);
        p.setInt(7, indrLucrLic);
        p.setInt(8, indrProiect);
        p.setInt(9, lucrControl);
        p.setInt(10, seminariiCerc);
        p.executeUpdate();
    }

    private Cadru_Didactic parseLineToCadruDidactic(String[] lineSplit) {
        return new Cadru_Didactic(0, lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4]);
    }

    private void parseAndAddLineToStateDB(Integer idCadruDidactic, String[] lineSplit) throws FieldValidationException,
            NumberFormatException, SQLException {

        if (idCadruDidactic == 0) {
            throw new FieldValidationException("Field idCadruDidactic incorrect");
        }

        Integer idDisciplina = Integer.parseInt(lineSplit[0]);
        Integer idSectia = Integer.parseInt(lineSplit[1]);
        Integer an = Integer.parseInt(lineSplit[2]);
        Integer oreC1 = Integer.parseInt(lineSplit[3]);
        Integer oreS1 = Integer.parseInt(lineSplit[4]);
        Integer oreL1 = Integer.parseInt(lineSplit[5]);
        Integer oreC2 = Integer.parseInt(lineSplit[6]);
        Integer oreS2 = Integer.parseInt(lineSplit[7]);
        Integer oreL2 = Integer.parseInt(lineSplit[8]);

        addDataToStateDB(idCadruDidactic, idDisciplina, idSectia, an, oreC1, oreS1, oreL1, oreC2, oreS2, oreL2);
    }

    private void addDataToStateDB(int idCadruDidactic, int idDisciplina, int idSectia, int an, int oreC1, int oreS1,
            int oreL1, int oreC2, int oreS2, int oreL2) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement p = conn.prepareStatement("Insert into State_de_Functii values(?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, idCadruDidactic);
        p.setInt(2, idDisciplina);
        p.setInt(3, idSectia);
        p.setInt(4, an);
        p.setInt(5, oreC1);
        p.setInt(6, oreS1);
        p.setInt(7, oreL1);
        p.setInt(8, oreC2);
        p.setInt(9, oreS2);
        p.setInt(10, oreL2);
        p.executeUpdate();
    }

    public void stergeCadruDidactic(int id_Cadru_Didactic) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement p;
        p = conn.prepareStatement("Delete from Cadre_Didactice where id_Cadru_Didactic = ?");
        p.setInt(1, id_Cadru_Didactic);
        p.executeUpdate();
    }

    public void modificaCadruDidactic(Cadru_Didactic cd) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement p;
        p = conn.prepareStatement("UPDATE Cadre_Didactice  SET "
                + "pozitia = ?, "
                + "den_post = ?, "
                + "nume = ?, "
                + "functia= ?, "
                + "tit_vac = ? "
                + "WHERE Id_Cadru_Didactic= ?");
        p.setString(1, cd.getPozitia());
        p.setString(2, cd.getDen_post());
        p.setString(3, cd.getNume());
        p.setString(4, cd.getFunctia());
        p.setString(5, cd.getTit_vac());
        p.setInt(6, cd.getId_Cadru_Didactic());
        p.executeUpdate();
    }

    public int adaugaCadruDidactic(Cadru_Didactic cd) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement p;
        p = conn.prepareStatement("INSERT INTO Cadre_Didactice  VALUES(?,?,?,?,?)");
        p.setString(1, cd.getPozitia());
        p.setString(2, cd.getDen_post());
        p.setString(3, cd.getNume());
        p.setString(4, cd.getFunctia());
        p.setString(5, cd.getTit_vac());
        p.executeUpdate();

        p = conn.prepareStatement("Select Id_Cadru_Didactic from Cadre_Didactice where pozitia=? and den_post=? and nume=? and functia=? and tit_vac=?");
        p.setString(1, cd.getPozitia());
        p.setString(2, cd.getDen_post());
        p.setString(3, cd.getNume());
        p.setString(4, cd.getFunctia());
        p.setString(5, cd.getTit_vac());
        ResultSet rs = p.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public List<Cadru_Didactic> getCadreDidactice() throws SQLException {
        myConnection = getConnection();
        ResultSet rs;
        List<Cadru_Didactic> list = new LinkedList<Cadru_Didactic>();

        PreparedStatement statement = myConnection.prepareStatement("SELECT * FROM Cadre_Didactice");
        rs = statement.executeQuery();


        while (rs.next()) {
            int id = rs.getInt(1);
            String pozitia = rs.getString(2);
            String den_post = rs.getString(3);
            String nume = rs.getString(4);
            String functia = rs.getString(5);
            String tit_vac = rs.getString(6);
            Cadru_Didactic cadruDidactic = new Cadru_Didactic(id, pozitia, den_post, nume, functia, tit_vac);
            list.add(cadruDidactic);
        }

        rs.close();
        myConnection.close();

        return list;


    }
}
