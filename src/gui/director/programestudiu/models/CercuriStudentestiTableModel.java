/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu.models;

import gui.director.models.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.Faza;
import model.director.programestudiu.CercStudentesc;
import model.director.programestudiu.Disciplina;

/**
 *
 * @author Artiom.Casapu
 */
public class CercuriStudentestiTableModel extends AbstractTableModel {

    private String[] columns = {"Denumire"};
    private List<CercStudentesc> cercuri;
    
    public CercuriStudentestiTableModel(List<CercStudentesc> cercuri) {
        this.cercuri = cercuri;
    }
    
    @Override
    public int getRowCount() {
        return cercuri.size();
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
                return cercuri.get(rowIndex).getDenumire();

        }
        return null;
    }
    
}
