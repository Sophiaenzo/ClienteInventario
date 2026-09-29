package tableModel;

/**
 *
 * @author wilson.simoes
 */

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Te220invc;
import raven.cell.TableActionCellRender;

/**
 *
 * @author wilson.simoes
 */
public class TE220invcTableModel extends AbstractTableModel{
    
     private ArrayList<Te220invc> listaD;

    public TE220invcTableModel(ArrayList<Te220invc> listaDados) {
        this.listaD = listaDados;
    }
    

    @Override
    public int getRowCount() {
        if (listaD == null)
            return 0;
        else
            return listaD.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Te220invc bk = listaD.get(rowIndex);
                 
         switch (columnIndex){             
            case 0: return bk.getUsu_coddep();
            case 1: return bk.getUsu_ultcon();
            case 2: return bk.getUsu_blomov();            
            case 3: return "";
            default: return "Nehum";
        }
    }
    
    
     @Override
    public String getColumnName(int column) {
       switch (column){
            case 0: return "Deposito";
            case 1: return "Contagem";
            case 2: return "Status";
            case 3: return "Exportar";
            default: return "Nenhum";
        } 
    }
   
}
