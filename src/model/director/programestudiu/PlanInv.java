/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director.programestudiu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Not Nicu
 */
public class PlanInv {
    
    private int id;
    private String denumire;
    private int semestru;
    private List<DisciplinePlan> disciplineInPlan = new ArrayList<DisciplinePlan>();

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the denumire
     */
    public String getDenumire() {
        return denumire;
    }

    /**
     * @param denumire the denumire to set
     */
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    /**
     * @return the semestru
     */
    public int getSemestru() {
        return semestru;
    }

    /**
     * @param semestru the semestru to set
     */
    public void setSemestru(int semestru) {
        this.semestru = semestru;
    }

    /**
     * @return the disciplineInPlan
     */
    public List<DisciplinePlan> getDisciplineInPlan() {
        return disciplineInPlan;
    }
    
    
    
}
