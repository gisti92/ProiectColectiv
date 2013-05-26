/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author S7eve
 */
public class PubliculRepository extends RepositoryBD{
    private static  PubliculRepository instance;
    
    private PubliculRepository(){
    }
    
    public static PubliculRepository getInstance(){
        if (instance == null){
            instance = new PubliculRepository();
        }
        return instance;
    }
}
