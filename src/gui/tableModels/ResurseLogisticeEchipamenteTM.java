/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tableModels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Echipamente;

/**
 *
 * @author Deea
 */
public class ResurseLogisticeEchipamenteTM extends AbstractTableModel{
    private String[] header={"Id echipament","Denumire echipament"};
    private List<Echipamente> list=new ArrayList<Echipamente>();

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch (columnIndex){
            case 0: return list.get(rowIndex).getId_Echipament();
            case 1: return list.get(rowIndex).getDenumire();
            default : return null;       
        }
    }
    
    
    public String[] getHeader() {
        return header;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
        
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    
    public void addRow(Echipamente row){
        list.add(row);        
        fireTableDataChanged();
    }
    
    public void setList(List<Echipamente> list){
        this.list=list;
        fireTableDataChanged();
    }
    
}
