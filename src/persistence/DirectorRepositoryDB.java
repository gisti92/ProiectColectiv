/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

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
    
//    public List<
    
}
