/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.models;

import java.util.List;
import javax.swing.AbstractListModel;
import model.CadruDidactic;

/**
 *
 * @author Artiom.Casapu
 */
public class CadriDidacticiListModel extends AbstractListModel{

    private List<CadruDidactic> list;
    
    public CadriDidacticiListModel(List<CadruDidactic> list) {
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index).getNume();
    }
    
}
