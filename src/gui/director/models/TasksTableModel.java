/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.Faza;
import model.director.Task;

/**
 *
 * @author Artiom.Casapu
 */
public class TasksTableModel extends AbstractTableModel {

    private String[] columns = {"Denumire", "Descriere", "Timp inceput", "Timp sfirsit"};
    private List<Task> tasks;
    
    public TasksTableModel(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    public Task getTask(int index) {
        return tasks.get(index);
    }
    
    @Override
    public int getRowCount() {
        return tasks.size();
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
                return tasks.get(rowIndex).getDenumire();
            case 1:
                return tasks.get(rowIndex).getDescriere();
            case 2:
                return tasks.get(rowIndex).getInterval().getStart();
            case 3:
                return tasks.get(rowIndex).getInterval().getEnd();
        }
        return null;
    }
    
}
