/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.ArrayList;
import java.util.List;
import model.director.Proiect;

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
    
    public List<Proiect> getProjects() {
       
        ArrayList<Proiect> result = new ArrayList();
        
        Proiect p = new Proiect();
        p.setDenumire("Denumire1");
        p.setDescrire("Descriere1");
        
        result.add(p);
        
        p = new Proiect();
        p.setDenumire("Denumire2");
        p.setDescrire("Dercriere2");
        
        result.add(p);
        
        p = new Proiect();
        
        p.setDenumire("Descriere3");
        p.setDescrire("Descriere3");
        
        result.add(p);
       
        return result;
        
    }
    
    public void addProject() {
        
    }
    
}
