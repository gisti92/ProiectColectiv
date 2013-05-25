/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Deea
 */
public class Echipamente {
    public int Id_Echipament;
    public String denumire;

    public Echipamente(int Id_Echipament, String denumire) {
        this.Id_Echipament = Id_Echipament;
        this.denumire = denumire;
    }

    public int getId_Echipament() {
        return Id_Echipament;
    }

    public void setId_Echipament(int Id_Echipament) {
        this.Id_Echipament = Id_Echipament;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "Echipamente{" + "Id_Echipament=" + Id_Echipament + ", denumire=" + denumire + '}';
    }
    
    
}
