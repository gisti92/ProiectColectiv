/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.publicul;

/**
 *
 * @author Deea
 */
public class OrarDisplay {
    private int ziua; 
    private int ora_inceput; 
    private int ora_sfarsit; 
    private int frecventa; 
    
    private String Disciplina;
    private String tip;
    private String Cadru_Didactic; 
    private String Sala; 
    private String Sectie;

    
    private String Formatie;

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

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String Disciplina) {
        this.Disciplina = Disciplina;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCadru_Didactic() {
        return Cadru_Didactic;
    }

    public void setCadru_Didactic(String Cadru_Didactic) {
        this.Cadru_Didactic = Cadru_Didactic;
    }

    public String getSala() {
        return Sala;
    }

    public void setSala(String Sala) {
        this.Sala = Sala;
    }
    
    public String getSectie() {
        return Sectie;
    }

    public void setSectie(String Sectie) {
        this.Sectie = Sectie;
    }
    
    
    public String getFormatie() {
        return Formatie;
    }

    public void setFormatie(String Formatie) {
        this.Formatie = Formatie;
    }

    public OrarDisplay(int ziua, int ora_inceput, int ora_sfarsit, int frecventa, String Disciplina, String tip, String Cadru_Didactic, String Sala, String Sectie, String Formatie) {
        this.ziua = ziua;
        this.ora_inceput = ora_inceput;
        this.ora_sfarsit = ora_sfarsit;
        this.frecventa = frecventa;
        this.Disciplina = Disciplina;
        this.tip = tip;
        this.Cadru_Didactic = Cadru_Didactic;
        this.Sala = Sala;
        this.Sectie = Sectie;
        this.Formatie = Formatie;
    }

    @Override
    public String toString() {
        return "OrarDisplay{" + "ziua=" + ziua + ", ora_inceput=" + ora_inceput + ", ora_sfarsit=" + ora_sfarsit + ", frecventa=" + frecventa + ", Disciplina=" + Disciplina + ", tip=" + tip + ", Cadru_Didactic=" + Cadru_Didactic + ", Sala=" + Sala + ", Sectie=" + Sectie + ", Formatie=" + Formatie + '}';
    }
    
}
