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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    private int id;
    private int suma;
    private String descriere;
    private TipCheltuiala tip;

    public enum TipCheltuiala {

        CHELTUIELA_CU_MOBILITATE("Cheltuiala cu mobilitate"),
        CHELTUIALA_CU_MANOPERA("Cheltuiala cu manopera"),
        CHELTUIALA_DE_LOGISTICA("Cheltuiala de logistica");
        private String uiValue;

        private TipCheltuiala(String uiValue) {
            this.uiValue = uiValue;
        }

        @Override
        public String toString() {
            switch (this) {
                case CHELTUIELA_CU_MOBILITATE:
                    return "Cheltuiala cu mobilitate";
                case CHELTUIALA_CU_MANOPERA:
                    return "Cheltuiala cu manopera";
                case CHELTUIALA_DE_LOGISTICA:
                    return "Cheltuiala de logistica";
                default:
                    return "";

            }
        }
    }
}
