/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director;

/**
 *
 * @author Artiom.Casapu
 */
public class CadruDidactic {
    
    private int id;
    private String positia;
    private String denumirePost;
    private String nume;
    private String functia;
    private String titVac;

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
     * @return the positia
     */
    public String getPositia() {
        setPositia(positia);
        return positia;
    }

    /**
     * @param positia the positia to set
     */
    public void setPositia(String positia) {
        this.positia = positia;
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
