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
import model.users.AdministratorUser;
import model.CadruDidactic;
import model.users.CadruDidacticUser;
import model.users.DirectorUser;
import model.Echipament;
import model.publicul.filters.Filter;
import model.Formatie;
import model.Sala;
import model.users.User;
import model.publicul.OrarDisplay;
import persistence.BaseRepository;

/**
 *
 * @author S7eve
 */
//Test commit Andreea
public class Controller {

    private static Controller instance = new Controller();
    private BaseRepository rep = BaseRepository.getInstance();

    protected Controller() {
    }

    public static Controller getInstance() {
        return instance;
    }

    public boolean login(String username, char[] pass) throws Exception {
        User user = rep.getUserForLogin(username, pass);
        if (user instanceof AdministratorUser) {
            UiAdministrator.getInstance().reOpen(user);
            return true;
        } else if (user instanceof DirectorUser) {
            UiDirector.getInstance().reOpen(user);
            return true;
        } else if (user instanceof CadruDidacticUser) {
            UiCadruDidactic.getInstance().reOpen((CadruDidacticUser) user);
            return true;
        } else {
            return false;
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

    public List<Echipament> getEchipamente() throws Exception {
        return rep.getEchipamente();
    }

    public List<Formatie> getFormatii() throws Exception {
        return rep.getFormatii();
    }

    public List<OrarDisplay> getOrar(Filter filter) throws Exception {
        return rep.getOrarFiltered(filter);
    }
}
