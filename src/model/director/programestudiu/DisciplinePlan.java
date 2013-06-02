/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director.programestudiu;

/**
 *
 * @author Nicu
 */
public class DisciplinePlan {
    
    private String disciplina;
    private int oreCurs;
    private int oreSem;
    private int oreLab;
    private int orePr;
    private String finalizare;
    private int nrCredite;

    /**
     * @return the disc
     */
    public String getDisc() {
        return disciplina;
    }

    /**
     * @param disc the disc to set
     */
    public void setDisc(String disc) {
        this.disciplina = disc;
    }

    /**
     * @return the oreCurs
     */
    public int getOreCurs() {
        return oreCurs;
    }

    /**
     * @param oreCurs the oreCurs to set
     */
    public void setOreCurs(int oreCurs) {
        this.oreCurs = oreCurs;
    }

    /**
     * @return the oreSem
     */
    public int getOreSem() {
        return oreSem;
    }

    /**
     * @param oreSem the oreSem to set
     */
    public void setOreSem(int oreSem) {
        this.oreSem = oreSem;
    }

    /**
     * @return the oreLab
     */
    public int getOreLab() {
        return oreLab;
    }

    /**
     * @param oreLab the oreLab to set
     */
    public void setOreLab(int oreLab) {
        this.oreLab = oreLab;
    }

    /**
     * @return the orePr
     */
    public int getOrePr() {
        return orePr;
    }

    /**
     * @param orePr the orePr to set
     */
    public void setOrePr(int orePr) {
        this.orePr = orePr;
    }

    /**
     * @return the finalizare
     */
    public String getFinalizare() {
        return finalizare;
    }

    /**
     * @param finalizare the finalizare to set
     */
    public void setFinalizare(String finalizare) {
        this.finalizare = finalizare;
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
