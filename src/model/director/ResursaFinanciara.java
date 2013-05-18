/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director;

/**
 *
 * @author Artiom.Casapu
 */
public class ResursaFinanciara {

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public TipCheltuiala getTip() {
        return tip;
    }

    public void setTip(TipCheltuiala tip) {
        this.tip = tip;
    }
    
    private int suma;
    private String descriere;
    private TipCheltuiala tip;
    
    public enum TipCheltuiala {
        CHELTUIELA_CU_MOBILITATE,
        CHELTUIALA_CU_MANOPERA,
        CHELTUIALA_DE_LOGISTICA
    }

}
