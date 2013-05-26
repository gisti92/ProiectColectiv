/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.users;

/**
 *
 * @author S7eve
 */
public abstract class User {

    private String name;

    public User(String name) {
        this.name = name;
    }
    
    public User(){
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
