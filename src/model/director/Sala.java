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

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    
    private int capacitate;
    private String descriere;
    
}
