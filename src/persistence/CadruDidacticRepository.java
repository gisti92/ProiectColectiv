/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author S7eve
 */
public class CadruDidacticRepository extends BaseRepository{
    private static CadruDidacticRepository instance;

    private CadruDidacticRepository() {
    }

    public static CadruDidacticRepository getInstance() {
        if (instance == null) {
            instance = new CadruDidacticRepository();
        }
        return instance;
    }
    
}
