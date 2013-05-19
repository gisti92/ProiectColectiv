/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.director.CadruDidactic;
import model.director.Faza;
import model.director.Proiect;
import model.director.Proiect.ProjectType;
import model.director.ResursaFinanciara;
import model.director.ResursaLogistica;
import model.director.Task;
import model.director.TimeInterval;

/**
 *
 * @author Artiom.Casapu
 */
public class DirectorRepositoryDB extends RepositoryBD {

    private static DirectorRepositoryDB instance;
    
    public DirectorRepositoryDB() {
        super();
    }
    
    public static DirectorRepositoryDB getInstance() {
        if (instance == null) {
            instance = new DirectorRepositoryDB();
        } 
            
        return instance;
    }
    
    public List<Proiect> getProjects() throws SQLException {
       
        ArrayList<Proiect> result = new ArrayList();
       
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Projects");
        
        ResultSet res = stmt.executeQuery();
        
        while (res.next()) {
            Proiect p = new Proiect();
            
            p.setId(res.getInt("id"));
            p.setDenumire(res.getString("denumire"));
            p.setDescrire(res.getString("descriere"));
            
            TimeInterval interval = new TimeInterval();
            
            interval.setStart(res.getDate("timp_inceput"));
            interval.setEnd(res.getDate("timp_sfirsit"));
            
            p.setInterval(interval);
            
            int tip = res.getInt("tip");
          
            if (tip == 1) {
                p.setTip(ProjectType.EVENIMENT_ADMINISTRATIV);
            } 
            
            if (tip == 2) {
                p.setTip(ProjectType.PROIECT_STIINTIFIC);
            }
            
            result.add(p);
        }
       
        return result;
        
    }
    
    public void addProject(Proiect p) throws SQLException {
        
        String query = "INSERT INTO Projects VALUES (?,?,?,?,?)";    
        
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setInt(1, p.getTip().equals(ProjectType.EVENIMENT_ADMINISTRATIV) ? 1 : 2);
        stmt.setString(2, p.getDenumire());
        stmt.setString(3, p.getDescrire());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(p.getInterval().getStart());
        stmt.setDate(4, new java.sql.Date(cal.getTimeInMillis()));
        cal.setTime(p.getInterval().getEnd());
        stmt.setDate(5, new java.sql.Date(cal.getTimeInMillis()));
        
        stmt.executeUpdate();
        
    }
    
    public void deleteProject(Proiect p) {
        
    }
    
    public List<Faza> getPhases(int projectId) throws SQLException {
        
        String query = "SELECT * FROM Phases WHERE project_id = " + projectId;
        PreparedStatement stmt = getConnection().prepareStatement(query);
        ResultSet res = stmt.executeQuery();
        
        List<Faza> result = new ArrayList<Faza>();
        
        while (res.next()) {
            
            Faza f = new Faza();
            
            
            List<Task> tasks = getTasks(f.getId());
            f.getTaskuri().addAll(tasks);
        }
        
        return null;
    }
    
    public List<Task> getTasks(int fazaId) {
        return null;
    }
    
    public List<CadruDidactic> getEchipa(int taskId) {
        return null;
    }
    
    public List<ResursaFinanciara> getBuget(int taskId) {
        return null;
    }
    
    public List<ResursaLogistica> getLogistics(int taskId) {
        return null;
    }
    
    
}
