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
import java.util.Properties;

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
    }
    catch (IOException e) {
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
    }
    catch (ClassNotFoundException e) {
      throw new RuntimeException("Eroare incarcare driver " + e.getMessage());
    }
    catch (SQLException e) {
      throw new RuntimeException("Eroare stabilire conexiune " + e.getMessage());
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
      }
      else {
        return 'R';
      }
    }
    catch (SQLException e) {
      throw new Exception(e.getMessage());
    }
    finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (myConnection != null) {
          myConnection.close();
        }
      }
      catch (SQLException e) {
        throw new Exception(e.getMessage());
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
    }
    // TODO throw messages to UI
    catch (FieldValidationException e) {
      System.out.println(e.getMessage());
      return false;
    }
    catch (NumberFormatException e) {
      System.out.println(e.getMessage());
      return false;
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
      return false;
    }
    catch (SQLException e) {
      System.out.println(e.getMessage());
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
    try {
      BufferedReader readFromFile = new BufferedReader(new FileReader(file));
      String lineFromFile;
      Integer idCadruDidactic = 0;
      while ((lineFromFile = readFromFile.readLine()) != null) {
        String[] lineSplit = lineFromFile.split("\\,|;");
        if (lineFromFile.length() == 5) {
          idCadruDidactic = parseAndAddLineToCadruDidacticeDB(lineSplit);
        }
        else {
          if (lineFromFile.length() == 9) {
            parseAndAddLineToStateDB(idCadruDidactic, lineSplit);
          }
          else {
            if (lineFromFile.length() == 1) {// TODO decide on a separator
              lineFromFile = readFromFile.readLine();
              parseAndAddAlteActivitatiCDToDB(idCadruDidactic, lineSplit);
              idCadruDidactic = 0;
            }
            else {
              readFromFile.close();
              throw new FieldValidationException("Invalid field numbers");
            }
          }
        }
      }
      readFromFile.close();
    }
    // TODO throw messages to UI
    catch (FieldValidationException e) {
      System.out.println(e.getMessage());
      return false;
    }
    catch (NumberFormatException e) {
      System.out.println(e.getMessage());
      return false;
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
      return false;
    }
    catch (SQLException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }

  private void parseAndAddAlteActivitatiCDToDB(Integer idCadruDidactic, String[] lineSplit)
      throws FieldValidationException, NumberFormatException, SQLException {
    if (idCadruDidactic == 0) {
      throw new FieldValidationException("Field idCadruDidactic incorrect");
    }

    Integer pregAdmitere = Integer.parseInt(lineSplit[1]);
    Integer comisiiAbsolvire = Integer.parseInt(lineSplit[2]);
    Integer consultatii = Integer.parseInt(lineSplit[3]);
    Integer examene = Integer.parseInt(lineSplit[4]);
    Integer indrLucrDisert = Integer.parseInt(lineSplit[5]);
    Integer indrLucrLic = Integer.parseInt(lineSplit[6]);
    Integer indrProiect = Integer.parseInt(lineSplit[7]);
    Integer lucrControl = Integer.parseInt(lineSplit[8]);
    Integer seminariiCerc = Integer.parseInt(lineSplit[9]);

    addDataToAlteActivitatiCDToDB(idCadruDidactic, pregAdmitere, comisiiAbsolvire, consultatii, examene,
        indrLucrDisert, indrLucrLic, indrProiect, lucrControl, seminariiCerc);
  }

  private void addDataToAlteActivitatiCDToDB(Integer... toAddToDb) throws SQLException {
    Connection conn = getConnection();

    PreparedStatement p = conn.prepareStatement("Insert into Alte_Activitati_CD values(?,?,?,?,?,?,?,?,?,?)");
    p.setInt(1, toAddToDb[0]);
    p.setInt(2, toAddToDb[1]);
    p.setInt(3, toAddToDb[2]);
    p.setInt(4, toAddToDb[3]);
    p.setInt(5, toAddToDb[4]);
    p.setInt(6, toAddToDb[5]);
    p.setInt(7, toAddToDb[6]);
    p.setInt(8, toAddToDb[7]);
    p.setInt(9, toAddToDb[8]);
    p.setInt(10, toAddToDb[9]);
    p.executeUpdate();
  }

  private Integer parseAndAddLineToCadruDidacticeDB(String[] lineSplit) throws SQLException {
    Connection conn = getConnection();

    PreparedStatement p = conn.prepareStatement("Insert into Cadre_Didactice values(?,?,?,?,?)");
    p.setString(1, lineSplit[0]);
    p.setString(2, lineSplit[1]);
    p.setString(3, lineSplit[2]);
    p.setString(4, lineSplit[3]);
    p.setString(5, lineSplit[4]);
    p.executeUpdate();

    p = conn.prepareStatement("Select Id_CadruDidactic from Cadre_Didactice where nume=" + lineSplit[2]
        + " and pozitia=" + lineSplit[0] + " and den_post=" + lineSplit[1] + " and functia=" + lineSplit[3]
        + " and tit_vac=" + lineSplit[4]);

    return p.executeQuery().getInt(1);
  }

  private void parseAndAddLineToStateDB(Integer idCadruDidactic, String[] lineSplit) throws FieldValidationException,
      NumberFormatException, SQLException {

    if (idCadruDidactic == 0) {
      throw new FieldValidationException("Field idCadruDidactic incorrect");
    }

    Integer idDisciplina = Integer.parseInt(lineSplit[1]);
    Integer idSectia = Integer.parseInt(lineSplit[2]);
    Integer an = Integer.parseInt(lineSplit[3]);
    Integer oreC1 = Integer.parseInt(lineSplit[4]);
    Integer oreS1 = Integer.parseInt(lineSplit[5]);
    Integer oreL1 = Integer.parseInt(lineSplit[6]);
    Integer oreC2 = Integer.parseInt(lineSplit[7]);
    Integer oreS2 = Integer.parseInt(lineSplit[8]);
    Integer oreL2 = Integer.parseInt(lineSplit[9]);

    addDataToStateDB(idCadruDidactic, idDisciplina, idSectia, an, oreC1, oreS1, oreL1, oreC2, oreS2, oreL2);
  }

  private void addDataToStateDB(Integer... toAddToDb) throws SQLException {
    Connection conn = getConnection();

    PreparedStatement p = conn.prepareStatement("Insert into State_de_Functii values(?,?,?,?,?,?,?,?,?,?)");
    p.setInt(1, toAddToDb[0]);
    p.setInt(2, toAddToDb[1]);
    p.setInt(3, toAddToDb[2]);
    p.setInt(4, toAddToDb[3]);
    p.setInt(5, toAddToDb[4]);
    p.setInt(6, toAddToDb[5]);
    p.setInt(7, toAddToDb[6]);
    p.setInt(8, toAddToDb[7]);
    p.setInt(9, toAddToDb[8]);
    p.setInt(10, toAddToDb[9]);
    p.executeUpdate();
  }
}
