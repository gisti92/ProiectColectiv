/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import gui.UiAdministrator;
import gui.UiCadruDidactic;
import gui.UiDirector;
import gui.UiPublic;
import gui.tableModels.CalendarulActivitatiTM;
import gui.tableModels.ResurseLogisticeEchipamenteTM;
import gui.tableModels.ResurseLogisticeSaliTM;
import gui.tableModels.ResurseUmaneTM;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.CDFilter;
import model.Cadru_Didactic;
import model.Echipamente;
import model.Filter;
import model.OrarDisplay;
import model.Sali;
import persistence.RepositoryBD;

/**
 *
 * @author S7eve
 */
//Test commit Andreea
public class Controller {

    private static Controller instance = null;
    private RepositoryBD rep = RepositoryBD.getInstance();
    private ResurseUmaneTM resurseUmaneTM = new ResurseUmaneTM();
    private ResurseLogisticeSaliTM resurseLogisticeSaliTM = new ResurseLogisticeSaliTM();
    private ResurseLogisticeEchipamenteTM resurseLogisticeEchipamenteTM = new ResurseLogisticeEchipamenteTM();
    private CalendarulActivitatiTM calendarulActivitatiTM = new CalendarulActivitatiTM();

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
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

    public boolean importOrar(String file) {
        return rep.importOrar(file);
    }

    public boolean importStateDeFunctii(String file) {
        return rep.importStateDeFunctii(file);
    }

    public void refreshResurseUmaneTM() {
        List<Cadru_Didactic> list = null;
        try {
            list = rep.getCadreDidactice();
        } catch (Exception ex) {
            System.out.println("Eroare la afisarea informatiilor despre Resursele Umane!" + ex.getMessage());
            //TODO notifi ui, throw exception
        }
        resurseUmaneTM.setList(list);
    }

    public AbstractTableModel getResurseUmaneTM() {

        return resurseUmaneTM;
    }

    public AbstractTableModel getAndRefreshResurseLogisticeSaliTM() throws Exception {
        List<Sali> list = null;
        try {
            list = rep.getSali();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Eroare la afisarea informatiilor despre salile departamentului! Contactati administratorul de sistem");
        }
        resurseLogisticeSaliTM.setList(list);
        return resurseLogisticeSaliTM;
    }

    public AbstractTableModel getAndRefreshResurseLogisticeEchipamenteTM() throws Exception {
        List<Echipamente> list = null;
        try {
            list = rep.getEchipamente();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Eroare la afisarea informatiilor despre echipamentele departamentului! Contactati administratorul de sistem");
        }
        resurseLogisticeEchipamenteTM.setList(list);
        return resurseLogisticeEchipamenteTM;
    }

    public void refreshCalendarActivitati(Filter filter) throws Exception {
        List<OrarDisplay> list = rep.getOrarFiltered(filter);
        calendarulActivitatiTM.setList(list);
    }

    public AbstractTableModel getCalendarActivitatiTM() {
        return calendarulActivitatiTM;
    }

    public void stergeCadruDidactic(int id_Cadru_Didactic) {
        try {
            rep.stergeCadruDidactic(id_Cadru_Didactic);
        } catch (SQLException ex) {
            System.out.println("Eroare la stergere: " + ex.getMessage());
            //TODO handle exception
        }
    }

    public void modificaCadruDidactic(int Id_Cadru_Didactic, String pozitia, String den_post, String nume, String functia, String tit_vac) {
        try {
            Cadru_Didactic cd = new Cadru_Didactic(Id_Cadru_Didactic, pozitia, den_post, nume, functia, tit_vac);
            rep.modificaCadruDidactic(cd);
        } catch (SQLException ex) {
            System.out.println("Eroare la modificare: " + ex.getMessage());
            //TODO handle exception
        }
    }

    public void adaugaCadruDidactic(int Id_Cadru_Didactic, String pozitia, String den_post, String nume, String functia, String tit_vac) {
        try {
            Cadru_Didactic cd = new Cadru_Didactic(Id_Cadru_Didactic, pozitia, den_post, nume, functia, tit_vac);
            rep.adaugaCadruDidactic(cd);
        } catch (SQLException ex) {
            System.out.println("Eroare la adaugare: " + ex.getMessage());
            //TODO handle exception
        }
    }
}
