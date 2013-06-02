/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.programestudiu.DisciplinePlan;

/**
 *
 * @author Nicu
 */
public class DisciplineTableModel extends AbstractTableModel {

    private String[] columns = {"Disciplina", "C", "S", "L", "P", "Finalizare", "Nr credite"};
    private List<DisciplinePlan> discipline;
    
    public DisciplineTableModel(List<DisciplinePlan> discipline) {
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
                return discipline.get(rowIndex).getDisc();
            case 1:
                return discipline.get(rowIndex).getOreCurs();
            case 2:
                return discipline.get(rowIndex).getOreSem();
            case 3:
                return discipline.get(rowIndex).getOreLab();
            case 4:
                return discipline.get(rowIndex).getOrePr();
            case 5:
                return discipline.get(rowIndex).getFinalizare();
            case 6:
                return discipline.get(rowIndex).getNrCredite();
        }
        return null;
    }
    
}
