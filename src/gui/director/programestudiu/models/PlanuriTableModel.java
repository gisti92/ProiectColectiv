/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.programestudiu.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.director.programestudiu.PlanInv;

/**
 *
 * @author Nicu
 */
public class PlanuriTableModel extends AbstractTableModel {

    private String[] columns = {"Denumire", "Semestru"};
    
    private List<PlanInv> planuri;

    public List<PlanInv> getPlanuri() {
        return planuri;
    }

    public void setPlanuri(List<PlanInv> planuri) {
        this.planuri = planuri;
    }
    
     
    
    public PlanuriTableModel(List<PlanInv> planuri) {
        this.planuri = planuri;
    }
    
    @Override
    public int getRowCount() {
        return planuri.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return planuri.get(rowIndex).getDenumire();
            case 1:
                return planuri.get(rowIndex).getSemestru();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}
