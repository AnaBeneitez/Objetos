package listados;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;

public class MiTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean isCellEditable(int fila, int col) {
        return false;
    }
    
    public Class getColumnClass(int col) {
        switch (col) {
            case 0: return String.class;
            case 1: return Integer.class;
            default: return String.class;
        }
    }
}
