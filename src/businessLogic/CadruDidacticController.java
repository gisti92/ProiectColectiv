/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import model.users.CadruDidacticUser;
import persistence.AdministratorRepository;
import persistence.CadruDidacticRepository;

/**
 *
 * @author S7eve
 */
public class CadruDidacticController {
       private static final CadruDidacticController INSTANCE = new CadruDidacticController();
    private CadruDidacticRepository rep = CadruDidacticRepository.getInstance();
    private CadruDidacticUser currentUser;

    private CadruDidacticController() {
    }

    public static CadruDidacticController getInstance() {
        return INSTANCE;
    }

    public void setCurrentUser(CadruDidacticUser currentUser) {
       this.currentUser=currentUser;
    }

}
