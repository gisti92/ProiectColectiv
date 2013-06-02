/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.SQLException;
import java.util.List;
import model.CadruDidactic;
import model.director.ResursaFinanciara;
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

    public List<ResursaFinanciara> getResurseFinanciare() throws Exception {
       return rep.getResurseFinanciare();
    }

    public void addResursaFinaciara(ResursaFinanciara rf) throws Exception {
       rep.addResursaFinanciara(rf);
    }

    public int getSumaResurseFinanciare() throws Exception {
        return rep.getSumaResurseFinanciare();
    }

    public void stergeResursaFinancara(int id) throws Exception {
        rep.stergeResursaFinancara(id);
    }

    public void modificaResursaFinanciara(int id, String descriere, int suma, ResursaFinanciara.TipCheltuiala tipCheltuiala) throws Exception {
        ResursaFinanciara rf= new ResursaFinanciara();
        rf.setId(id);
        rf.setDescriere(descriere);
        rf.setSuma(suma);
        rf.setTip(tipCheltuiala);
        rep.smodificaResursaFinanciara(rf);
    }
}
