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
public class Task {
    
    private int id;
    private List<CadruDidactic> echipa;
    private List<ResursaLogistica> resurseLogistice;
    private List<ResursaFinanciara> resurseFinanciare;
    private String denumire;
    private String descriere;
    private TimeInterval interval;

    public TimeInterval getInterval() {
        return interval;
    }

    public void setInterval(TimeInterval interval) {
        this.interval = interval;
    }
    
    
    public Task() {
        echipa = new ArrayList<CadruDidactic>();
        resurseLogistice = new ArrayList<ResursaLogistica>();
        resurseFinanciare = new ArrayList<ResursaFinanciara>();
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
     * @return the echipa
     */
    public List<CadruDidactic> getEchipa() {
        return echipa;
    }

    /**
     * @return the resurseLogistice
     */
    public List<ResursaLogistica> getResurseLogistice() {
        return resurseLogistice;
    }

    /**
     * @return the resurseFinanciare
     */
    public List<ResursaFinanciara> getResurseFinanciare() {
        return resurseFinanciare;
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
     * @return the descriere
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     * @param descriere the descriere to set
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    
}
