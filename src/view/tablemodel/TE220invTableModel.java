package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Te220inv;

/**
 *
 * @author wilson.simoes
 */
public class TE220invTableModel extends AbstractTableModel{
    
     private ArrayList<Te220inv> listaDeposito;

    public TE220invTableModel(ArrayList<Te220inv> listaDeposito) {
        this.listaDeposito = listaDeposito;
    }

         
    

    @Override
    public int getRowCount() {
        if (listaDeposito == null)
            return 0;
        else
            return listaDeposito.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Te220inv bk = listaDeposito.get(rowIndex);
                 
         switch (columnIndex){
             case 0: return bk.getcodemp();
             case 1: return bk.getdatinv();
             case 2: return bk.getcoddep();
             case 4: return bk.getcoddep();
             
             default: return "Nehum";
        }
    }
    
    @Override
    public String getColumnName(int column) {
       switch (column){
            case 0: return "Deposito";
            case 1: return "Produto";
            case 2: return "Data";
            default: return "Nenhum";
        }      
    
        
    }
    
    
}
