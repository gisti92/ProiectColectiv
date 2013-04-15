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
}
