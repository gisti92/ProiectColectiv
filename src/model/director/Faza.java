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
public class Faza {

    public Faza() {
        taskuri = new ArrayList<Task>();
    }
    
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public TimeInterval getInterval() {
        return interval;
    }

    public void setInterval(TimeInterval interval) {
        this.interval = interval;
    }
    
    private String denumire;
    private String descriere;
    
    private TimeInterval interval;
    
    private List<Task> taskuri;

    public List<Task> getTaskuri() {
        return taskuri;
    }
   
    
}
