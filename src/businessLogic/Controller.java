/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import gui.UiAdministrator;
import gui.UiCadruDidactic;
import gui.UiDirector;
import gui.UiPublic;
import gui.tableModels.ResurseUmaneTM;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import model.Cadru_Didactic;
import persistence.RepositoryBD;

/**
 *
 * @author S7eve
 */
//Test commit Andreea
public class Controller {

    private static Controller instance = null ;
    private RepositoryBD rep = RepositoryBD.getInstance();
    private ResurseUmaneTM resurseUmaneTM = new ResurseUmaneTM ();
    
    private Controller() {        
    }

    public static Controller getInstance() {
    	if (instance==null){
    		instance= new Controller();
    	}
        return instance;
    }

    public boolean authentication(String user, char[] pass) throws Exception {
        char act;
        act = rep.getPermission(user, pass);
        switch (act) {
            case 'A': {
                UiAdministrator.getInstance().reOpen(user);
                return true;
            }
            case 'D': {
                UiDirector.getInstance().reOpen(user);
                return true;
            }
            case 'C': {
                UiCadruDidactic.getInstance().reOpen(user);
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public boolean loginAsPublic() {
        UiPublic.getInstance().reOpen("Publicul");
        return true;
    }

    public AbstractTableModel getAndRefreshResurseUmaneTM() throws Exception {
        List<Cadru_Didactic> list=null;
        try {
            list = rep.getCadreDidactice();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Eroare la afisare informatii Resurse Umane! Contactati administratorul de sistem");
        }
        resurseUmaneTM.setList(list);
        return resurseUmaneTM;
    }
    
    
}
