/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.Proiect;

/**
 *
 * @author User
 */
public class ProjectsTableModel extends AbstractTableModel {

    private String[] columns = {"Denumire", "Descriere"};
    private List<Proiect> proiect;
    
    public ProjectsTableModel(List<Proiect> proiect) {
        this.proiect = proiect;
    }
    
    @Override
    public int getRowCount() {
        return proiect.size();
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
                return proiect.get(rowIndex).getDenumire();
            case 1:
                return proiect.get(rowIndex).getDescrire();
        }
        return null;
    }
    
}
