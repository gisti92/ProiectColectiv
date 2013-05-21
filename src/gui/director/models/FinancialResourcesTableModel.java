/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.director.models;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.table.AbstractTableModel;
import model.director.ResursaFinanciara;

/**
 *
 * @author Artiom.Casapu
 */
public class FinancialResourcesTableModel extends AbstractTableModel {

    private String[] columns = {"Descriere", "Tip", "Suma"};
    private List<ResursaFinanciara> financials;
    
    public FinancialResourcesTableModel(List<ResursaFinanciara> financials) {
        this.financials = financials;
    }
    
    public ResursaFinanciara getResursaFinanciara(int index) {
        return financials.get(index);
    }
    
    @Override
    public int getRowCount() {
        return financials.size();
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
                return financials.get(rowIndex).getDescriere();
            case 1:
                return financials.get(rowIndex).getTip();
            case 2:
                return financials.get(rowIndex).getSuma();
        }
        return null;
    }
    
}
