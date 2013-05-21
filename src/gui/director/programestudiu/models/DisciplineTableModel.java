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

/**
 *
 * @author Artiom.Casapu
 */
public class DisciplineTableModel extends AbstractTableModel {

    private String[] columns = {"Denumire", "Nr credite"};
    private List<Disciplina> discipline;
    
    public DisciplineTableModel(List<Disciplina> discipline) {
        this.discipline = discipline;
    }
    
    @Override
    public int getRowCount() {
        return discipline.size();
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
                return discipline.get(rowIndex).getDenumire();
            case 1:
                return discipline.get(rowIndex).getNrCredite();

        }
        return null;
    }
    
}
