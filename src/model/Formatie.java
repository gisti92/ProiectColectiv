/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Deea
 */
public class Formatie {

    public int Id_Formatie;
    public String denumire;
    public int Id_Sectie;
    public int an;
    public int grupa;

    public Formatie(int Id_Formatie, String denumire, int Id_Sectie, int an, int grupa) {
        this.Id_Formatie = Id_Formatie;
        this.denumire = denumire;
        this.Id_Sectie = Id_Sectie;
        this.an = an;
        this.grupa = grupa;
    }

    public int getId_Formatie() {
        return Id_Formatie;
    }

    public void setId_Formatie(int Id_Formatie) {
        this.Id_Formatie = Id_Formatie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getId_Sectie() {
        return Id_Sectie;
    }

    public void setId_Sectie(int Id_Sectie) {
        this.Id_Sectie = Id_Sectie;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Formatii{" + "Id_Formatie=" + Id_Formatie + ", denumire=" + denumire + ", Id_Sectie=" + Id_Sectie + ", an=" + an + ", grupa=" + grupa + '}';
    }
}
