package view.tablemodel;

/**
 *
 * @author wilson.simoes
 */

import tableModel.*;
import view.tablemodel.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Te220invc;

/**
 *
 * @author wilson.simoes
 */
public class TE220invcTableModel extends AbstractTableModel{
    
     private ArrayList<Te220invc> listaDados;

    public TE220invcTableModel(ArrayList<Te220invc> listaDados) {
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
        
        Te220invc bk = listaDados.get(rowIndex);
                 
         switch (columnIndex){             
            case 0: return bk.getUsu_datinv();
            case 1: return bk.getUsu_coddep();
            case 2: return bk.getUsu_ultcon();
            case 3: return bk.getUsu_blomov();            
            default: return "Nehum";
        }
    }
    
    
     @Override
    public String getColumnName(int column) {
       switch (column){
            case 0: return "Data";
            case 1: return "Deposito";
            case 2: return "Contagem";
            case 3: return "Status";
            case 4: return "Exportar";
            default: return "Nehum";
        } 
    }
   
}
