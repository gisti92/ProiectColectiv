/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Deea
 */
public class Cadru_Didactic {
    private int Id_Cadru_Didactic;
    private String pozitia ;
    private String den_post ;
    private String nume;
    private String  functia;
    private String tit_vac; 

    public Cadru_Didactic(int Id_Cadru_Didactic, String pozitia, String den_post, String nume, String functia, String tit_vac) {
        this.Id_Cadru_Didactic = Id_Cadru_Didactic;
        this.pozitia = pozitia;
        this.den_post = den_post;
        this.nume = nume;
        this.functia = functia;
        this.tit_vac = tit_vac;
    }

    public int getId_Cadru_Didactic() {
        return Id_Cadru_Didactic;
    }

    public void setId_Cadru_Didactic(int Id_Cadru_Didactic) {
        this.Id_Cadru_Didactic = Id_Cadru_Didactic;
    }

    public String getPozitia() {
        return pozitia;
    }

    public void setPozitia(String pozitia) {
        this.pozitia = pozitia;
    }

    public String getDen_post() {
        return den_post;
    }

    public void setDen_post(String den_post) {
        this.den_post = den_post;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getFunctia() {
        return functia;
    }

    public void setFunctia(String functia) {
        this.functia = functia;
    }

    public String getTit_vac() {
        return tit_vac;
    }

    public void setTit_vac(String tit_vac) {
        this.tit_vac = tit_vac;
    }

    @Override
    public String toString() {
        return "Cadru_Didactic{" + "Id_Cadru_Didactic=" + Id_Cadru_Didactic + ", pozitia=" + pozitia + ", den_post=" + den_post + ", nume=" + nume + ", functia=" + functia + ", tit_vac=" + tit_vac + '}';
    }
    
    
   
}
