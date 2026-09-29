package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Te220con;

/**
 *
 * @author wilson.simoes
 */
public class TE220conTableModel extends AbstractTableModel{
    
     private ArrayList<Te220con> listaDados;

    public TE220conTableModel(ArrayList<Te220con> listaDados) {
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
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Te220con bk = listaDados.get(rowIndex);
                 
         switch (columnIndex){
             
            case 0: return bk.getUSU_CODDEP();
            case 1: return bk.getUSU_CODPRO();
            case 2: return bk.getUSU_ETIQUETA();
            case 3: return bk.getUSU_QTDCON();
            case 4: return bk.getUSU_DATCON();
            case 5: return bk.getUSU_USUCON();
            case 6: return bk.getUSU_INDBIP();
            case 7: return bk.getUSU_OBSBIP();            
            default: return "Nehum";
        }
    }
    
    
     @Override
    public String getColumnName(int column) {
       switch (column){
            case 0: return "Deposito";
            case 1: return "PRODUTO";
            case 2: return "Etiqueta";
            case 3: return "Qtdade";
            case 4: return "Data Cont.";
            case 5: return "Usuario";
            case 6: return "Status";
            case 7: return "Observacao";
            default: return "Nehum";
        } 
    }
   
}
