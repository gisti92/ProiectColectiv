/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Deea
 */
public class Sali {
    public int Id_Sala;
    public String denumire; 
    public int capacitate;

    public Sali(int Id_Sala, String denumire, int capacitate) {
        this.Id_Sala = Id_Sala;
        this.denumire = denumire;
        this.capacitate = capacitate;
    }

    public int getId_Sala() {
        return Id_Sala;
    }

    public void setId_Sala(int Id_Sala) {
        this.Id_Sala = Id_Sala;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    @Override
    public String toString() {
        return "Sali{" + "Id_Sala=" + Id_Sala + ", denumire=" + denumire + ", capacitate=" + capacitate + '}';
    }
    
    
}
