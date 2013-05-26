/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.List;
import persistence.PubliculRepository;

/**
 *
 * @author S7eve
 */
public class PubliculController extends Controller {

    private static PubliculController instance = null;
    private PubliculRepository rep = PubliculRepository.getInstance();

    private PubliculController() {
    }

    public static PubliculController getInstance() {
        if (instance == null) {
            instance = new PubliculController();
        }
        return instance;
    }

    public List<String> getAvailableYears() throws Exception {
        return rep.getAvailableYears();
    }
}
