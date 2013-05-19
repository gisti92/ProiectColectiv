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
import model.director.Echipament;
import model.director.Faza;
import model.director.Proiect;
import model.director.Proiect.ProjectType;
import model.director.ResursaFinanciara;
import model.director.ResursaLogistica;
import model.director.Sala;
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
            p.setDescriere(res.getString("descriere"));
            
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
            
            p.getFaze().addAll(getPhases(p.getId()));
            
            result.add(p);
        }
       
        return result;
        
    }
    
    public void addProject(Proiect p) throws SQLException {
        
        String query = "INSERT INTO Projects VALUES (?,?,?,?,?)";    
        
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setInt(1, p.getTip().equals(ProjectType.EVENIMENT_ADMINISTRATIV) ? 1 : 2);
        stmt.setString(2, p.getDenumire());
        stmt.setString(3, p.getDescriere());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(p.getInterval().getStart());
        stmt.setDate(4, new java.sql.Date(cal.getTimeInMillis()));
        cal.setTime(p.getInterval().getEnd());
        stmt.setDate(5, new java.sql.Date(cal.getTimeInMillis()));
        
        stmt.executeUpdate();
        
    }
    
    public List<Faza> getPhases(int projectId) throws SQLException {
        
        String query = "SELECT * FROM Phases WHERE project_id = " + projectId;
        PreparedStatement stmt = getConnection().prepareStatement(query);
        ResultSet res = stmt.executeQuery();
        
        List<Faza> result = new ArrayList<Faza>();
        
        while (res.next()) {
            
            Faza f = new Faza();
            
            f.setId(res.getInt("id"));
            
            int tip = res.getInt("tip");
            if (tip == 1) {
                f.setTip(Faza.PhaseType.ADMINISTRATIVE_ACTIVITY);
            }
            if (tip == 2) {
                f.setTip(Faza.PhaseType.PHASE);
            }
            
            f.setDenumire(res.getString("denumire"));
            f.setDescriere(res.getString("descriere"));
            
            TimeInterval interval = new TimeInterval();
            
            interval.setStart(res.getDate("timp_inceput"));
            interval.setEnd(res.getDate("timp_sfirsit"));
            
            f.setInterval(interval);
            
            List<Task> tasks = getTasks(f.getId());
            f.getTaskuri().addAll(tasks);
            
            result.add(f);
        }
        
        return result;
    }
    
    public List<Task> getTasks(int fazaId) throws SQLException {
        
        String query = "SELECT * FROM Tasks WHERE phase_id = " + fazaId;
        PreparedStatement stmt = getConnection().prepareStatement(query);
        ResultSet res = stmt.executeQuery();
        
        List<Task> result = new ArrayList<Task>();
        
        while (res.next()) {
            
            Task t = new Task();
            
            t.setId(res.getInt("id"));
            t.setDenumire(res.getString("denumire"));
            t.setDescriere(res.getString("descriere"));
            
            TimeInterval interval = new TimeInterval();
            
            interval.setStart(res.getDate("timp_inceput"));
            interval.setEnd(res.getDate("timp_sfirsit"));
            
            t.setInterval(interval);
            
            t.getEchipa().addAll(getEchipa(t.getId()));
            t.getResurseFinanciare().addAll(getBuget(t.getId()));
            t.getResurseLogistice().addAll(getLogistics(t.getId()));
            
            result.add(t);
                    
        }
        
        return result;
    }
    
    public List<CadruDidactic> getEchipa(int taskId) throws SQLException {
        
        String query = "SELECT * FROM Tasks ";
        query += "INNER JOIN TaskTeam ON Tasks.id = TaskTeam.task_id ";
        query += "INNER JOIN Cadre_Didactice ON Cadre_Didactice.Id_Cadru_Didactic = TaskTeam.cadru_didactic_id ";
        query += "WHERE Tasks.id = " + taskId;
        
        PreparedStatement stmt = getConnection().prepareStatement(query);
        ResultSet res = stmt.executeQuery();
        
        List<CadruDidactic> result = new ArrayList<CadruDidactic>();
        
        while (res.next()) {
            
            CadruDidactic cd = new CadruDidactic();
            cd.setId(res.getInt("Id_Cadru_Didactic"));
            cd.setDenumirePost(res.getString("den_post"));
            cd.setNume(res.getString("nume"));
            cd.setPositia(res.getString("pozitia"));
            cd.setTitVac(res.getString("tit_vac"));
            cd.setFunctia(res.getString("functia"));
    
            result.add(cd);
        }
        
        return result;
    }
    
    public List<ResursaFinanciara> getBuget(int taskId) throws SQLException {
        
        String query = "SELECT * FROM TaskBudget WHERE taskId =  " + taskId;
        
        PreparedStatement stmt = getConnection().prepareStatement(query);
        ResultSet res = stmt.executeQuery();
        
        List<ResursaFinanciara> result = new ArrayList<ResursaFinanciara>();
        
        while (res.next()) {
            
            ResursaFinanciara fin = new ResursaFinanciara();
            
            fin.setId(res.getInt("id"));
            fin.setSuma(res.getInt("suma"));
            fin.setDescriere(res.getString("descriere"));
            
            int tip = res.getInt("budget_type");
            
            if (tip == 1) {
                fin.setTip(ResursaFinanciara.TipCheltuiala.CHELTUIELA_CU_MOBILITATE);
            }
            
            if (tip == 2) {
                fin.setTip(ResursaFinanciara.TipCheltuiala.CHELTUIALA_CU_MANOPERA);
            }
            
            if (tip == 3) {
                fin.setTip(ResursaFinanciara.TipCheltuiala.CHELTUIALA_DE_LOGISTICA);
            }
            
            result.add(fin);
            
        }
        
        return result;
    }
    
    public List<ResursaLogistica> getLogistics(int taskId) throws SQLException {
        
        String query = "SELECT * FROM TaskLogisticRoom ";
        query += "INNER JOIN Sali ON TaskLogisticRoom.room_id = Sali.Id_Sala ";
        query += "WHERE task_id = " + taskId;
        
        PreparedStatement stmt = getConnection().prepareStatement(query);
        ResultSet res = stmt.executeQuery();
        
        List<ResursaLogistica> result = new ArrayList<ResursaLogistica>();
        
        while (res.next()) {
            
            Sala s = new Sala();
            
            s.setId(res.getInt("Id_Sala"));
            s.setCapacitate(res.getInt("capacitate"));
            s.setDenumire(res.getString("denumire"));
            
            result.add(s);
            
        }
        
        res.close();
        
        query = "SELECT * FROM TaskLogisticEquipment ";
        query += "INNER JOIN Echipamente ON TaskLogisticEquipment.equipment_id = Echipamente.Id_Echipament ";
        query += "WHERE TaskLogisticEquipment.task_id = " + taskId;
        
        stmt = getConnection().prepareStatement(query);
        res = stmt.executeQuery();
        
        while (res.next()) {
            Echipament e = new Echipament();
            
            e.setDenumire(res.getString("denumire"));
            e.setId(res.getInt("Id_Echipament"));
            
            result.add(e);
        }
        
        res.close();
        
        
        return result;
    }
    
    
}
