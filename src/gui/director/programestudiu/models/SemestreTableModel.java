/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu.models;

import gui.director.models.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.Faza;
import model.director.programestudiu.Disciplina;
import model.director.programestudiu.Semestru;

/**
 *
 * @author Artiom.Casapu
 */
public class SemestreTableModel extends AbstractTableModel {

    private String[] columns = {"Denumire"};
    private List<Semestru> semestre;
    
    public SemestreTableModel(List<Semestru> semestre) {
        this.semestre = semestre;
    }
    
    @Override
    public int getRowCount() {
        return semestre.size();
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
                return semestre.get(rowIndex).getDenumire();

        }
        return null;
    }
    
}
