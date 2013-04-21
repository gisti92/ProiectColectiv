/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import model.Cadru_Didactic;
import model.Echipamente;
import model.Sali;

/**
 *
 * @author S7eve
 */
public class RepositoryBD {

    private static RepositoryBD instance = null;
    private String propsFileName = "src/persistence/db.properties";
    private Properties props = null;
    private Connection myConnection;

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
            con = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.user"), props.getProperty("jdbc.pass"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Eroare incarcare driver " + e.getMessage());
        } catch (SQLException e) {
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
            } else {
                return 'R';
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (myConnection != null) {
                    myConnection.close();
                }
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }

    public List<Cadru_Didactic> getCadreDidactice() throws Exception {
        myConnection = getConnection();
        ResultSet rs = null;
        List<Cadru_Didactic> list = new LinkedList<Cadru_Didactic>();
        try {
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
            return list;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (myConnection != null) {
                    myConnection.close();
                }
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }

    public List<Sali> getSali() throws Exception {
        myConnection = getConnection();
        ResultSet rs = null;
        List<Sali> list = new LinkedList<Sali>();
        try {
            PreparedStatement statement = myConnection.prepareStatement("SELECT * FROM Sali");
            rs = statement.executeQuery();


            while (rs.next()) {
                int Id_Sala = rs.getInt(1);
                String denumire = rs.getString(2);
                int capacitate = rs.getInt(3);
                Sali sali = new Sali(Id_Sala, denumire, capacitate);
                list.add(sali);
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (myConnection != null) {
                    myConnection.close();
                }
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }

    public List<Echipamente> getEchipamente() throws Exception {
        myConnection = getConnection();
        ResultSet rs = null;
        List<Echipamente> list = new LinkedList<Echipamente>();
        try {
            PreparedStatement statement = myConnection.prepareStatement("SELECT * FROM Echipamente");
            rs = statement.executeQuery();


            while (rs.next()) {
                int Id_Echipament = rs.getInt(1);
                String denumire = rs.getString(2);
                Echipamente echipamente = new Echipamente(Id_Echipament, denumire);
                list.add(echipamente);
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (myConnection != null) {
                    myConnection.close();
                }
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }
}
