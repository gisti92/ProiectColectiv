/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.programestudiu.SectieModel;

/**
 *
 * @author Nicu
 */
public class SectiiTableModel extends AbstractTableModel {

    private String[] columns = {"Denumire", "Nr semestre"};
    private List<SectieModel> sectii;
    
    public SectiiTableModel(List<SectieModel> sectii) {
        this.sectii = sectii;
    }
    
    public SectieModel getSectie(int row) {
        return sectii.get(row);
    }
    
    @Override
    public int getRowCount() {
        return sectii.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: 
                return sectii.get(rowIndex).getDenumire();
            case 1:
                return sectii.get(rowIndex).getNrSemestre();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}
