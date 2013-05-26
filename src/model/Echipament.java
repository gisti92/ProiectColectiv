/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Artiom.Casapu
 */
public class Echipament extends ResursaLogistica {
    public Echipament (int id, String denumire){
        super(id,denumire);
    }
    
    public Echipament(){
    }
    
    @Override
    public String toString() {
        return getDenumire();
    }
    
}
