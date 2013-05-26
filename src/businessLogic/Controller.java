/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import gui.UiAdministrator;
import gui.UiCadruDidactic;
import gui.UiDirector;
import gui.UiPublic;
import java.util.List;
import model.CadruDidactic;
import model.Echipament;
import model.publicul.filters.Filter;
import model.Formatie;
import model.Sala;
import model.publicul.OrarDisplay;
import persistence.RepositoryBD;

/**
 *
 * @author S7eve
 */
//Test commit Andreea
public class Controller {

    private static Controller instance = new Controller();
    private RepositoryBD rep = RepositoryBD.getInstance();
 
    protected Controller() {
    }

    public static Controller getInstance() {
        return instance;
    }

    public boolean login(String user, char[] pass) throws Exception {
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

    public List<CadruDidactic> getResurseUmane() throws Exception {
        return rep.getCadreDidactice();
    }

    public List<Sala> getSali() throws Exception {
        return rep.getSali();
    }
    
    public List<Echipament> getEchipamente() throws Exception{
        return rep.getEchipamente();
    }
   
    public List<Formatie> getFormatii() throws Exception {
        return rep.getFormatii();
    }

    public List<OrarDisplay> getOrar(Filter filter) throws Exception {
        return rep.getOrarFiltered(filter);
    }
    

}
