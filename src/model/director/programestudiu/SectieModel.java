/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director.programestudiu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Artiom.Casapu
 */
public class SectieModel {
    private int id;
    private String denumire;
    private int nrSemestre;

    private List<PlanInv> planuriDeInvatamint = new ArrayList<PlanInv>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNrSemestre() {
        return nrSemestre;
    }

    public void setNrSemestre(int nrSemestre) {
        this.nrSemestre = nrSemestre;
    }

    /**
     * @return the planuriDeInvatamint
     */
    public List<PlanInv> getPlanuriDeInvatamint() {
        return planuriDeInvatamint;
    }
    
    
    
    
}
