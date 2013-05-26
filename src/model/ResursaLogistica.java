/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Artiom.Casapu
 */
public abstract class ResursaLogistica {
    private int id;
    private String denumire;
    
    protected ResursaLogistica(int id, String denumire){
        this.id=id;
        this.denumire=denumire;
    }
    
    protected ResursaLogistica(){
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
}
