/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Artiom.Casapu
 */
public class Proiect {
    
    public enum ProjectType {
        EVENIMENT_ADMINISTRATIV,
        PROIECT_STIINTIFIC;

        @Override
        public String toString() {
            if (this.equals(ProjectType.EVENIMENT_ADMINISTRATIV))
                return "Eveniment Administrativ";
            if (this.equals(ProjectType.PROIECT_STIINTIFIC)) {
                return "Proiect Stiintific";
            }
            return null;
        }
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDescrire() {
        return descrire;
    }

    public void setDescrire(String descrire) {
        this.descrire = descrire;
    }

    public ProjectType getTip() {
        return tip;
    }

    public void setTip(ProjectType tip) {
        this.tip = tip;
    }

    public List<Faza> getFaze() {
        return faze;
    }
    
    private String denumire;
    private String descrire;
    private ProjectType tip;
    
    private List<Faza> faze;
    
    public Proiect() {
        faze = new ArrayList<Faza>();
    }
    
}
