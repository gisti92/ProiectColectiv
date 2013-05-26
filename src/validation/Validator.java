/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.Date;

/**
 *
 * @author S7eve
 */
public class Validator {
    public static boolean areDatesValid(Date dela, Date panala){
        if ((dela ==null || panala == null) && (dela !=panala)){
            return true;
        }
        
        if (dela.compareTo(panala) == -1){
            return true;
        }
    
        return false;
    }
}
