/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu.models;

import gui.director.models.*;
import model.director.programestudiu.ProgramDeStudiuModel;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.Faza;
import model.director.programestudiu.Disciplina;

/**
 *
 * @author Artiom.Casapu
 */
public class ProgrameDeStudiuTableModel extends AbstractTableModel {

    private String[] columns = {"Denumire"};
    private List<ProgramDeStudiuModel> programe;
    
    public ProgrameDeStudiuTableModel(List<ProgramDeStudiuModel> programe) {
        this.programe = programe;
    }
    
    @Override
    public int getRowCount() {
        return programe.size();
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
                return programe.get(rowIndex).getDenumire();
        }
        return null;
    }
    
}
