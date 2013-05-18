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
import java.util.Properties;

/**
 *
 * @author S7eve
 */
public class RepositoryBD {

    private static RepositoryBD instance = null;
    private String propsFileName = "src/persistence/db.properties";
    private Properties props = null;
    private Connection myConnection;

    protected RepositoryBD() {
        props = getProperties();
        myConnection = getConnection();
    }

    public static RepositoryBD getInstance() {
    	if (instance==null){
    		instance= new RepositoryBD();
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

    protected Connection getConnection() {
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
}
