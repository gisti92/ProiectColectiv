/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director;

/**
 *
 * @author Nicu
 */
public class CercStudentesc {
       private int id;
       private int an;
       private String denumire;
       private String mentor;
       private String descriere;
       private int id_program;

    public int getId_program() {
        return id_program;
    }

    public void setId_program(int id_program) {
        this.id_program = id_program;
    }
       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
       
       
    
}
