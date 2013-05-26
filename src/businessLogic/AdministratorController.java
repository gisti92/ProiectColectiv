/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.SQLException;
import model.CadruDidactic;
import persistence.AdministratorRepository;

/**
 *
 * @author S7eve
 */
public class AdministratorController extends Controller{

    private static final AdministratorController INSTANCE = new AdministratorController();
    private AdministratorRepository rep = AdministratorRepository.getInstance();

    private AdministratorController() {
    }

    public static AdministratorController getInstance() {
        return INSTANCE;
    }

    public boolean importOrar(String file) {
        return rep.importOrar(file);
    }

    public boolean importStateDeFunctii(String file) {
        return rep.importStateDeFunctii(file);
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
            CadruDidactic cd = new CadruDidactic(Id_Cadru_Didactic, pozitia, den_post, nume, functia, tit_vac);
            rep.modificaCadruDidactic(cd);
        } catch (SQLException ex) {
            System.out.println("Eroare la modificare: " + ex.getMessage());
            //TODO handle exception
        }
    }

    public void adaugaCadruDidactic(int Id_Cadru_Didactic, String pozitia, String den_post, String nume, String functia, String tit_vac) {
        try {
            CadruDidactic cd = new CadruDidactic(Id_Cadru_Didactic, pozitia, den_post, nume, functia, tit_vac);
            rep.saveCadruDidactic(cd);
        } catch (SQLException ex) {
            System.out.println("Eroare la adaugare: " + ex.getMessage());
            //TODO handle exception
        }
    }
}
