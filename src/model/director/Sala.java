/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director;

/**
 *
 * @author Artiom.Casapu
 */
public class Sala extends ResursaLogistica {

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }
    
    @Override
    public String toString() {
        return getDenumire() + " (capacitate - " + getCapacitate() + ")"; 
    }
    
    private int capacitate;
    
}
