/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.users;

/**
 *
 * @author S7eve
 */
public class CadruDidacticUser extends User{
    private int id;
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public CadruDidacticUser(){
          super();
    }
    public CadruDidacticUser(int id , String name){
        super(name);
        this.id=id;
    }
}
