/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Artiom.Casapu
 */
public class Sala extends ResursaLogistica {
    private int capacitate;

    public Sala(int Id_Sala, String denumire, int capacitate) {
        super(Id_Sala,denumire);
        this.capacitate=capacitate;
    }

    public Sala(){
    }
    
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
}
