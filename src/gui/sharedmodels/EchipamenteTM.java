/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sharedmodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Echipament;

/**
 *
 * @author Deea
 */
public class EchipamenteTM extends AbstractTableModel{
    private String[] header={"Id echipament","Denumire echipament"};
    private List<Echipament> list=new ArrayList<Echipament>();

    public EchipamenteTM( List<Echipament> list) {
        this.list= list;
        fireTableDataChanged();
    }

    public EchipamenteTM() {
    } 
    
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
            case 0: return list.get(rowIndex).getId();
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
    
    public void addRow(Echipament row){
        list.add(row);        
        fireTableDataChanged();
    }
    
    public void setList(List<Echipament> list){
        this.list=list;
        fireTableDataChanged();
    }
    
}
