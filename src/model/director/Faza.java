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
    
    public enum PhaseType {
        ADMINISTRATIVE_ACTIVITY,
        PHASE;

        @Override
        public String toString() {
            if (this.equals(PhaseType.ADMINISTRATIVE_ACTIVITY)) {
                return "Activitate administrativa";
            }
            if (this.equals(PhaseType.PHASE)) {
                return "Faza";
            }
            return super.toString();
        }
        
    }

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
    
    public PhaseType getTip() {
        return tip;
    }

    public void setTip(PhaseType tip) {
        this.tip = tip;
    }
    
    private String denumire;
    private String descriere;
    private TimeInterval interval;
    private List<Task> taskuri;
    private PhaseType tip;

    public List<Task> getTaskuri() {
        return taskuri;
    }
   
    
}
