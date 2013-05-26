/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Deea
 */
public class Orar {
    private int ziua; 
    private int ora_inceput; 
    private int ora_sfarsit; 
    private int frecventa; 
    
    private int Id_Disciplina;
    private String tip;
    private int Id_Cadru_Didactic; 
    private int Id_Sala; 
    private int Id_Formatie;

    public Orar(int ziua, int ora_inceput, int ora_sfarsit, int frecventa, int Id_Disciplina,String tip, int Id_Cadru_Didactic, int Id_Sala, int Id_Formatie) {
        this.ziua = ziua;
        this.ora_inceput = ora_inceput;
        this.ora_sfarsit = ora_sfarsit;
        this.frecventa = frecventa;
        this.Id_Disciplina = Id_Disciplina;
        this.tip = tip;
        this.Id_Cadru_Didactic = Id_Cadru_Didactic;
        this.Id_Sala = Id_Sala;
        this.Id_Formatie = Id_Formatie;
    }

    public int getZiua() {
        return ziua;
    }

    public void setZiua(int ziua) {
        this.ziua = ziua;
    }

    public int getOra_inceput() {
        return ora_inceput;
    }

    public void setOra_inceput(int ora_inceput) {
        this.ora_inceput = ora_inceput;
    }

    public int getOra_sfarsit() {
        return ora_sfarsit;
    }

    public void setOra_sfarsit(int ora_sfarsit) {
        this.ora_sfarsit = ora_sfarsit;
    }

    public int getFrecventa() {
        return frecventa;
    }

    public void setFrecventa(int frecventa) {
        this.frecventa = frecventa;
    }

    public int getId_Disciplina() {
        return Id_Disciplina;
    }

    public void setId_Disciplina(int Id_Disciplina) {
        this.Id_Disciplina = Id_Disciplina;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
    public int getId_Cadru_Didactic() {
        return Id_Cadru_Didactic;
    }

    public void setId_Cadru_Didactic(int Id_Cadru_Didactic) {
        this.Id_Cadru_Didactic = Id_Cadru_Didactic;
    }

    public int getId_Sala() {
        return Id_Sala;
    }

    public void setId_Sala(int Id_Sala) {
        this.Id_Sala = Id_Sala;
    }

    public int getId_Formatie() {
        return Id_Formatie;
    }

    public void setId_Formatie(int Id_Formatie) {
        this.Id_Formatie = Id_Formatie;
    }

    @Override
    public String toString() {
        return "Orar{" + "ziua=" + ziua + ", ora_inceput=" + ora_inceput + ", ora_sfarsit=" + ora_sfarsit + ", frecventa=" + frecventa + ", Id_Disciplina=" + Id_Disciplina + ", tip=" + tip + ", Id_Cadru_Didactic=" + Id_Cadru_Didactic + ", Id_Sala=" + Id_Sala + ", Id_Formatie=" + Id_Formatie + '}';
    }  
    
}
