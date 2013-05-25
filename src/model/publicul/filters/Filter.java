/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.publicul.filters;

/**
 *
 * @author Deea
 */
public abstract class Filter <T>{
    private T filterTerm;

    public T getFilterTerm() {
        return filterTerm;
    }

    public void setFilterTerm(T filterTerm) {
        this.filterTerm = filterTerm;
    }

    public Filter(T filterTerm) {
        this.filterTerm = filterTerm;
    }
    
}
