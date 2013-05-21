/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.ResursaLogistica;
import model.director.Sala;

/**
 *
 * @author Artiom.Casapu
 */
public class SaliTableModel extends AbstractTableModel {
    
    private String[] columns = {"Id", "Denumire", "Capacitate" };
    private List<ResursaLogistica> logistics;
    
    public SaliTableModel(List<ResursaLogistica> logistics) {
        this.logistics = logistics;
    }
    
    
    @Override
    public int getRowCount() {
        return logistics.size();
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
                return logistics.get(rowIndex).getId();
            case 1:
                return ((Sala)logistics.get(rowIndex)).getDenumire();
            case 2:
                return ((Sala)logistics.get(rowIndex)).getCapacitate();
        }
        return null;
    }
    
}
