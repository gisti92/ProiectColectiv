/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.Faza;

/**
 *
 * @author Artiom.Casapu
 */
public class PhasesTableModel extends AbstractTableModel {

    private String[] columns = {"Denumire", "Descriere", "Timp inceput", "Timp sfirsit"};
    private List<Faza> faze;
    
    public PhasesTableModel(List<Faza> faze) {
        this.faze = faze;
    }
    
    @Override
    public int getRowCount() {
        return faze.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return faze.get(rowIndex).getDenumire();
            case 1:
                return faze.get(rowIndex).getDescriere();
            case 2:
                return faze.get(rowIndex).getInterval().getStart();
            case 3:
                return faze.get(rowIndex).getInterval().getEnd();
        }
        return null;
    }
    
}
