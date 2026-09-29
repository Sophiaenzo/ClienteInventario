package tableModel;

import view.tablemodel.*;						 
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;											
import modelDominio.Te220ite;

/**
 *
 * @author wilson.simoes
 */
public class TE220iteTableModel extends AbstractTableModel{
        
    private ArrayList<Te220ite> listaDados;

    public TE220iteTableModel(ArrayList<Te220ite> listaDados) {
        this.listaDados = listaDados;
    }
    

    @Override
    public int getRowCount() {
        if (listaDados == null)
            return 0;
        else
            return listaDados.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Te220ite bk = listaDados.get(rowIndex);
                 
         switch (columnIndex){             
            case 0: return bk.getDatinv();
            case 1: return bk.getCoddep();
            case 2: return bk.getCodpro();
            case 3: return bk.getQtdest();
            case 4: return bk.getQtdsoma();
            case 5: return bk.getQtdsaldo();           
            default: return "Nehum";
        }
    }
       
    
    @Override
    public String getColumnName(int column) {
       switch (column){
            case 0: return "Data Inven";
            case 1: return "Deposito";
            case 2: return "Produto";
            case 3: return "Qtde Estoque";
            case 4: return "Qtde Bipada";
            case 5: return "Saldo";
            default: return "Nehum";
        } 
    }

    
    public int getColumnIndex(String columnName) {
    for (int i = 0; i < getColumnCount(); i++) {
        if (getColumnName(i).equalsIgnoreCase(columnName)) {
            return i;
        }
    }
    return -1;
}

  
    
}
