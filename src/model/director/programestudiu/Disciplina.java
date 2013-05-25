/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director.programestudiu;

/**
 *
 * @author Artiom.Casapu
 */
public class Disciplina {
    
    private int id;
    private String denumire;
    private int nrCredite;

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
     * @return the nrCredite
     */
    public int getNrCredite() {
        return nrCredite;
    }

    /**
     * @param nrCredite the nrCredite to set
     */
    public void setNrCredite(int nrCredite) {
        this.nrCredite = nrCredite;
    }
    
}
