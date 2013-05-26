/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.administrator;

/**
 *
 * @author S7eve
 */
public class AlteActivitati {

    private int id_Cadru_Didactic;
    private int pregAdmitere;
    private int comisiiAbsolvire;
    private int consultatii;
    private int examene;
    private int indrLucrDisert;
    private int indrLucrLic;
    private int indrProiect;
    private int lucrControl;
    private int seminariiCerc;

    public AlteActivitati(int id_Cadru_Didactic, int pregAdmitere, int comisiiAbsolvire, int consultatii, int examene, int indrLucrDisert, int indrLucrLic, int indrProiect, int lucrControl, int seminariiCerc) {
        this.id_Cadru_Didactic=id_Cadru_Didactic;
        this.pregAdmitere = pregAdmitere;
        this.comisiiAbsolvire = comisiiAbsolvire;
        this.consultatii = consultatii;
        this.examene = examene;
        this.indrLucrDisert = indrLucrDisert;
        this.indrLucrLic = indrLucrLic;
        this.indrProiect = indrProiect;
        this.lucrControl = lucrControl;
        this.seminariiCerc = seminariiCerc;
    }

    public int getId_Cadru_Didactic() {
        return id_Cadru_Didactic;
    }

    public int getPregAdmitere() {
        return pregAdmitere;
    }

    public int getComisiiAbsolvire() {
        return comisiiAbsolvire;
    }

    public int getConsultatii() {
        return consultatii;
    }

    public int getExamene() {
        return examene;
    }

    public int getIndrLucrDisert() {
        return indrLucrDisert;
    }

    public int getIndrLucrLic() {
        return indrLucrLic;
    }

    public int getIndrProiect() {
        return indrProiect;
    }

    public int getLucrControl() {
        return lucrControl;
    }

    public int getSeminariiCerc() {
        return seminariiCerc;
    }
    
    
}
