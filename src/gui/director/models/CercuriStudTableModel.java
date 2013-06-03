/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.CercStudentesc;

/**
 *
 * @author Nicu
 */
public class CercuriStudTableModel extends AbstractTableModel{
    
    private String[] columns = {"Denumire", "An", "Mentor", "Descriere"};
    private List<CercStudentesc> cercuriStud = new ArrayList<>();

    public CercuriStudTableModel(List<CercStudentesc> cercuriStud) {
        this.cercuriStud = cercuriStud;
    }
    
    

    @Override
    public int getRowCount() {
        return cercuriStud.size();
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
                return cercuriStud.get(rowIndex).getDenumire();
            case 1:
                return Integer.toString(cercuriStud.get(rowIndex).getAn());
            case 2:
                return cercuriStud.get(rowIndex).getMentor();
            case 3:
                return cercuriStud.get(rowIndex).getDescriere();
        }
        return null;
    }
    
}
