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
import model.users.AdministratorUser;
import model.publicul.filters.AnFilter;
import model.publicul.filters.CDFilter;
import model.CadruDidactic;
import model.users.CadruDidacticUser;
import model.users.DirectorUser;
import model.Echipament;
import model.publicul.filters.Filter;
import model.Formatie;
import model.Sala;
import model.users.User;
import model.publicul.filters.FormatieFilter;
import model.publicul.OrarDisplay;

/**
 *
 * @author S7eve
 */
public class BaseRepository {

    private static BaseRepository instance;
    private String propsFileName = "src/persistence/db.properties";
    private Properties props = null;
    private Connection myConnection;

    protected BaseRepository() {
        props = getProperties();
        myConnection = getConnection();
    }

    public static BaseRepository getInstance() {
        if (instance == null) {
            instance = new BaseRepository();
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

    protected final Connection getConnection() {
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

    public User getUserForLogin(String user, char[] pass) throws Exception {
        ResultSet rs = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT permissiune FROM logins WHERE userid = ? AND pass = ?");
            statement.setString(1, user);
            statement.setString(2, String.valueOf(pass));
            rs = statement.executeQuery();

            if (rs.next()) {
                char permission = rs.getString(1).charAt(0);
                switch (permission) {
                    case 'A':
                        return new AdministratorUser();
                    case 'D':
                        return new DirectorUser();
                    case 'C':
                        statement = getConnection().prepareStatement("SELECT nume,c.Id_Cadru_Didactic FROM (Select * from Loginuri_Cadre_Didactice WHERE userid = ?) l inner join Cadre_Didactice c on l.ID_Cadru_Didactic = c.Id_Cadru_Didactic");
                        statement.setString(1, user);
                        rs = statement.executeQuery();
                        if (rs.next()) {
                            String nume = rs.getString(1);
                            int id = rs.getInt(2);
                            return new CadruDidacticUser(id, nume);
                        } else {
                            return null;
                        }
                    default:
                        return null;
                }
            } else {
                return null;
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

    public List<CadruDidactic> getCadreDidactice() throws Exception {
        myConnection = getConnection();
        ResultSet rs = null;
        List<CadruDidactic> list = new LinkedList<CadruDidactic>();
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
                CadruDidactic cadruDidactic = new CadruDidactic(id, pozitia, den_post, nume, functia, tit_vac);
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

    public List<Sala> getSali() throws Exception {
        myConnection = getConnection();
        ResultSet rs = null;
        List<Sala> list = new LinkedList<Sala>();
        try {
            PreparedStatement statement = myConnection.prepareStatement("SELECT * FROM Sali");
            rs = statement.executeQuery();


            while (rs.next()) {
                int Id_Sala = rs.getInt(1);
                String denumire = rs.getString(2);
                int capacitate = rs.getInt(3);
                Sala sali = new Sala(Id_Sala, denumire, capacitate);
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

    public List<Echipament> getEchipamente() throws Exception {
        myConnection = getConnection();
        ResultSet rs = null;
        List<Echipament> list = new LinkedList<Echipament>();
        try {
            PreparedStatement statement = myConnection.prepareStatement("SELECT * FROM Echipamente");
            rs = statement.executeQuery();


            while (rs.next()) {
                int Id_Echipament = rs.getInt(1);
                String denumire = rs.getString(2);
                Echipament echipament = new Echipament(Id_Echipament, denumire);
                list.add(echipament);
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

    public List<Formatie> getFormatii() throws Exception {
        myConnection = getConnection();
        ResultSet rs = null;
        List<Formatie> list = new LinkedList<Formatie>();
        try {
            PreparedStatement statement = myConnection.prepareStatement("SELECT * FROM Formatii");
            rs = statement.executeQuery();

            while (rs.next()) {
                int Id_Formatie = rs.getInt(1);
                String denumire = rs.getString(2);
                int Id_Sectie = rs.getInt(3);
                int an = rs.getInt(4);
                int grupa = rs.getInt(5);
                Formatie formatie = new Formatie(Id_Formatie, denumire, Id_Sectie, an, grupa);
                list.add(formatie);
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

    public List<OrarDisplay> getOrarFiltered(Filter filter) throws Exception {
        List<OrarDisplay> list = new ArrayList<OrarDisplay>();
        myConnection = getConnection();
        ResultSet rs = null;
        try {
            PreparedStatement statement;
            if (filter == null) {
                statement = myConnection.prepareStatement("SELECT ziua, ora_inceput, ora_sfarsit, frecventa , d.denumire as disciplina , tip as Tipul ,  c.nume as Cadru_Didactic , s.denumire as Sala , sec.denumire as Sectie, f.denumire as Formatie, f.an as An,f.denumire as Formatia FROM orar o inner join sali s on o.Id_Sala=s.Id_Sala inner join  Discipline d on o.Id_Disciplina= d.Id_Disciplina inner join Cadre_Didactice c on o.Id_Cadru_Didactic= c.Id_Cadru_Didactic inner join formatii f on o.Id_Formatie = f.Id_Formatie inner join Sectii sec on sec.Id_Sectie = f.Id_Sectie order by ziua");
            } else if (filter.getClass().equals(CDFilter.class)) {
                statement = myConnection.prepareStatement("SELECT ziua, ora_inceput, ora_sfarsit, frecventa , d.denumire as disciplina , tip as Tipul ,  c.nume as Cadru_Didactic , s.denumire as Sala , sec.denumire as Sectie, f.denumire as Formatie, f.an as An,f.denumire as Formatia FROM orar o inner join sali s on o.Id_Sala=s.Id_Sala inner join  Discipline d on o.Id_Disciplina= d.Id_Disciplina inner join (Select * from Cadre_Didactice where Id_Cadru_Didactic = ?) c on o.Id_Cadru_Didactic= c.Id_Cadru_Didactic inner join formatii f on o.Id_Formatie = f.Id_Formatie inner join Sectii sec on sec.Id_Sectie = f.Id_Sectie order by ziua");
                statement.setInt(1, (int) filter.getFilterTerm());
            } else if (filter.getClass().equals(FormatieFilter.class)) {
                statement = myConnection.prepareStatement("SELECT ziua, ora_inceput, ora_sfarsit, frecventa , d.denumire as disciplina , tip as Tipul ,  c.nume as Cadru_Didactic , s.denumire as Sala , sec.denumire as Sectie, f.denumire as Formatie, f.an as An,f.denumire as Formatia FROM orar o inner join sali s on o.Id_Sala=s.Id_Sala inner join  Discipline d on o.Id_Disciplina= d.Id_Disciplina inner join  Cadre_Didactice  c on o.Id_Cadru_Didactic= c.Id_Cadru_Didactic inner join (Select * from formatii where id_formatie = ?) f on o.Id_Formatie = f.Id_Formatie inner join Sectii sec on sec.Id_Sectie = f.Id_Sectie order by ziua");
                statement.setInt(1, (int) filter.getFilterTerm());
            } else if (filter.getClass().equals(AnFilter.class)) {
                statement = myConnection.prepareStatement("SELECT ziua, ora_inceput, ora_sfarsit, frecventa , d.denumire as disciplina , tip as Tipul ,  c.nume as Cadru_Didactic , s.denumire as Sala , sec.denumire as Sectie, f.denumire as Formatie, f.an as An,f.denumire as Formatia FROM orar o inner join sali s on o.Id_Sala=s.Id_Sala inner join  Discipline d on o.Id_Disciplina= d.Id_Disciplina inner join  Cadre_Didactice  c on o.Id_Cadru_Didactic= c.Id_Cadru_Didactic inner join (Select * from formatii where an = ?) f on o.Id_Formatie = f.Id_Formatie inner join Sectii sec on sec.Id_Sectie = f.Id_Sectie order by ziua");
                statement.setInt(1, (int) filter.getFilterTerm());
            } else {
                throw new Exception("Incompatible Filter type");
            }
            rs = statement.executeQuery();
            while (rs.next()) {
                int ziua = rs.getInt(1);
                int ora_inceput = rs.getInt(2);
                int ora_sfarsit = rs.getInt(3);
                int frecventa = rs.getInt(4);
                String disciplina = rs.getString(5);
                String tip = rs.getString(6);
                String cadru_didactic = rs.getString(7);
                String sala = rs.getString(8);
                String sectie = rs.getString(9);
                String formatie = rs.getString(10);
                OrarDisplay orar = new OrarDisplay(ziua, ora_inceput, ora_sfarsit, frecventa, disciplina, tip, cadru_didactic, sala, sectie, formatie);

                list.add(orar);
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (myConnection != null) {
                    myConnection.close();
                }
            } catch (SQLException e) {
                throw new Exception(e);
            }
        }
    }

    public List<String> getAvailableYears() throws Exception {
        List<String> list = new ArrayList<String>();
        myConnection = getConnection();
        ResultSet rs = null;
        try {
            PreparedStatement statement = myConnection.prepareStatement("Select distinct an from Formatii");
            rs = statement.executeQuery();
            while (rs.next()) {
                String an = String.valueOf(rs.getInt(1));
                list.add(an);
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (myConnection != null) {
                    myConnection.close();
                }
            } catch (SQLException e) {
                throw new Exception(e);
            }
        }

    }
}
