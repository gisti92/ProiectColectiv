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
public class Semestru {
    
    private int id;
    private String denumire;
    private List<Disciplina> discipline;

    public Semestru() {
        discipline = new ArrayList<Disciplina>();
    }
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
     * @return the discipline
     */
    public List<Disciplina> getDiscipline() {
        return discipline;
    }
    
}
