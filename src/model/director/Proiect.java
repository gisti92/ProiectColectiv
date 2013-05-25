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
    
    public enum ProjectStatus {
        APROBAT,
        NEAPROBAT,
        RESPINS;
       
        @Override
        public String toString() {
            if (this.equals(ProjectStatus.APROBAT)){
                return "Aprobat";}
            if (this.equals(ProjectStatus.NEAPROBAT)) {
                return "Neaprobat";
            }if (this.equals(ProjectStatus.RESPINS)) {
                return "Respins";
            }
            return null;
        }
    }
    
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

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
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
    
    
    public TimeInterval getInterval() {
        return interval;
    }

    public void setInterval(TimeInterval interval) {
        this.interval = interval;
    }
    

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus stats) {
        this.status = stats;
    }
    
    private int id;
    private String denumire;
    private String descriere;
    private ProjectType tip;
    private TimeInterval interval;
    private ProjectStatus status;
    private List<Faza> faze;
    
    public Proiect() {
        faze = new ArrayList<Faza>();
    }
    
}
