/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import exceptions.FieldValidationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.CadruDidactic;
import model.Orar;
import model.administrator.AlteActivitati;
import model.administrator.State;

/**
 *
 * @author S7eve
 */
public class AdministratorRepository extends BaseRepository {

    private static AdministratorRepository instance;

    private AdministratorRepository() {
    }

    public static AdministratorRepository getInstance() {
        if (instance == null) {
            instance = new AdministratorRepository();
        }
        return instance;
    }

    public boolean importOrar(String fileOrar) {
        try {
            BufferedReader readFromFile = new BufferedReader(new FileReader(fileOrar));
            String lineFromFile;
            while ((lineFromFile = readFromFile.readLine()) != null) {
                Orar orar = parseLineToOrar(lineFromFile);
                saveOrar(orar);
            }
            readFromFile.close();
        } catch (FieldValidationException e) {
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

    private Orar parseLineToOrar(String line) throws FieldValidationException, NumberFormatException,
            SQLException {
        String[] lineSplit = line.split("\\;|-");
        if (lineSplit.length != 9) {
            throw new FieldValidationException("Length does not equal number of fields in DB");
        }

        int ziua = Integer.parseInt(lineSplit[0]);
        Integer deLaOra = Integer.parseInt(lineSplit[1]);
        Integer panaLaOra = Integer.parseInt(lineSplit[2]);
        Integer frecventa = Integer.parseInt(lineSplit[3]);
        Integer codDisciplina = Integer.parseInt(lineSplit[4]);
        String tip = lineSplit[5];
        Integer codCadruDidactic = Integer.parseInt(lineSplit[6]);
        Integer codSala = Integer.parseInt(lineSplit[7]);
        Integer codFormatie = Integer.parseInt(lineSplit[8]);

        if (tip.length() != 1) {
            throw new FieldValidationException("Tip must contain only 1 character!");
        }
        Orar orar = new Orar(ziua, deLaOra, panaLaOra, frecventa, codDisciplina, tip, codCadruDidactic, codSala, codFormatie);
        return orar;
    }

    private void saveOrar(Orar orar)
            throws SQLException {
        Connection conn = getConnection();

        PreparedStatement p = conn.prepareStatement("Insert into orar values(?,?,?,?,?,?,?,?,?)");
        p.setInt(1, orar.getZiua());
        p.setInt(2, orar.getOra_inceput());
        p.setInt(3, orar.getOra_sfarsit());
        p.setInt(4, orar.getFrecventa());
        p.setInt(5, orar.getId_Disciplina());
        p.setString(6, orar.getTip());
        p.setInt(7, orar.getId_Cadru_Didactic());
        p.setInt(8, orar.getId_Sala());
        p.setInt(9, orar.getId_Formatie());
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
                    CadruDidactic cd = parseLineToCadruDidactic(lineSplit);
                    idCadruDidactic = saveCadruDidactic(cd);
                } else if (lineSplit.length == 9) {
                    State state = parseLineToState(idCadruDidactic, lineSplit);
                    saveState(state);
                } else if (lineSplit.length == 1) {
                    lineFromFile = readFromFile.readLine();
                    lineSplit = lineFromFile.split("\\,|;");
                    AlteActivitati alteActivitati = parseLineToAlteActivitati(idCadruDidactic, lineSplit);
                    saveAlteActivitati(alteActivitati);
                    idCadruDidactic = 0;
                } else {
                    throw new FieldValidationException("Invalid field numbers");
                }

            }
        } catch (FieldValidationException e) {
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

    private CadruDidactic parseLineToCadruDidactic(String[] lineSplit) {
        return new CadruDidactic(0, lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4]);
    }

    private AlteActivitati parseLineToAlteActivitati(int idCadruDidactic, String[] lineSplit)
            throws FieldValidationException, NumberFormatException {
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

        return new AlteActivitati(idCadruDidactic, pregAdmitere, comisiiAbsolvire, consultatii, examene,
                indrLucrDisert, indrLucrLic, indrProiect, lucrControl, seminariiCerc);
    }

    private void saveAlteActivitati(AlteActivitati alteActivitati) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement p = conn.prepareStatement("Insert into Alte_Activitati_CD values(?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, alteActivitati.getId_Cadru_Didactic());
        p.setInt(2, alteActivitati.getPregAdmitere());
        p.setInt(3, alteActivitati.getComisiiAbsolvire());
        p.setInt(4, alteActivitati.getConsultatii());
        p.setInt(5, alteActivitati.getExamene());
        p.setInt(6, alteActivitati.getIndrLucrDisert());
        p.setInt(7, alteActivitati.getIndrLucrLic());
        p.setInt(8, alteActivitati.getIndrProiect());
        p.setInt(9, alteActivitati.getLucrControl());
        p.setInt(10, alteActivitati.getSeminariiCerc());
        p.executeUpdate();
    }

    private State parseLineToState(int idCadruDidactic, String[] lineSplit) throws FieldValidationException,
            NumberFormatException {

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

        return new State(idCadruDidactic, idDisciplina, idSectia, an, oreC1, oreS1, oreL1, oreC2, oreS2, oreL2);
    }

    private void saveState(State state) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement p = conn.prepareStatement("Insert into State_de_Functii values(?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, state.getIdCadruDidactic());
        p.setInt(2, state.getIdDisciplina());
        p.setInt(3, state.getIdSectia());
        p.setInt(4, state.getAn());
        p.setInt(5, state.getOreC1());
        p.setInt(6, state.getOreS1());
        p.setInt(7, state.getOreL1());
        p.setInt(8, state.getOreC2());
        p.setInt(9, state.getOreS2());
        p.setInt(10, state.getOreL2());
        p.executeUpdate();
    }

    public void stergeCadruDidactic(int id_Cadru_Didactic) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement p;
        p = conn.prepareStatement("Delete from Cadre_Didactice where id_Cadru_Didactic = ?");
        p.setInt(1, id_Cadru_Didactic);
        p.executeUpdate();
    }

    public void modificaCadruDidactic(CadruDidactic cd) throws SQLException {
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
        p.setString(2, cd.getDenumirePost());
        p.setString(3, cd.getNume());
        p.setString(4, cd.getFunctia());
        p.setString(5, cd.getTitVac());
        p.setInt(6, cd.getId());
        p.executeUpdate();
    }

    public int saveCadruDidactic(CadruDidactic cd) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement p;
        p = conn.prepareStatement("INSERT INTO Cadre_Didactice  VALUES(?,?,?,?,?)");
        p.setString(1, cd.getPozitia());
        p.setString(2, cd.getDenumirePost());
        p.setString(3, cd.getNume());
        p.setString(4, cd.getFunctia());
        p.setString(5, cd.getTitVac());
        p.executeUpdate();

        p = conn.prepareStatement("Select Id_Cadru_Didactic from Cadre_Didactice where pozitia=? and den_post=? and nume=? and functia=? and tit_vac=?");
        p.setString(1, cd.getPozitia());
        p.setString(2, cd.getDenumirePost());
        p.setString(3, cd.getNume());
        p.setString(4, cd.getFunctia());
        p.setString(5, cd.getTitVac());
        ResultSet rs = p.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
}
