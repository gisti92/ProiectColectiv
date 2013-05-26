/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Artiom.Casapu
 */
public class CadruDidactic {
    
    private int id;
    private String pozitia;
    private String denumirePost;
    private String nume;
    private String functia;
    private String titVac;

    public CadruDidactic(int id, String pozitia, String denumirePost, String nume, String functia, String titVac) {
        this.id = id;
        this.pozitia = pozitia;
        this.denumirePost = denumirePost;
        this.nume = nume;
        this.functia = functia;
        this.titVac = titVac;
    }

    public CadruDidactic() {
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
     * @return the pozitia
     */
    public String getPozitia() {
        return pozitia;
    }

    /**
     * @param positia the pozitia to set
     */
    public void setPozitia(String pozitia) {
        this.pozitia = pozitia;
    }

    /**
     * @return the denumirePost
     */
    public String getDenumirePost() {
        return denumirePost;
    }

    /**
     * @param denumirePost the denumirePost to set
     */
    public void setDenumirePost(String denumirePost) {
        this.denumirePost = denumirePost;
    }

    /**
     * @return the nume
     */
    public String getNume() {
        return nume;
    }

    /**
     * @param nume the nume to set
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * @return the functia
     */
    public String getFunctia() {
        return functia;
    }

    /**
     * @param functia the functia to set
     */
    public void setFunctia(String functia) {
        this.functia = functia;
    }

    /**
     * @return the titVac
     */
    public String getTitVac() {
        return titVac;
    }

    /**
     * @param titVac the titVac to set
     */
    public void setTitVac(String titVac) {
        this.titVac = titVac;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof CadruDidactic) && ((CadruDidactic)obj).getNume().equals(this.getNume());
    }
    
}
