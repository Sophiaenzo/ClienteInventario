package classe;

import java.util.ArrayList;
import util.Configuracao;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.Main;
import modelDominio.Te220con;
import view.ChamarDeposito;

/**
 *
 * @author wilson.simoes
 */
public class TabelaLista {
    
    Configuracao arquivo = new Configuracao();
    String datainv = arquivo.GetProp("datainv", "N");   
    
    boolean Todos;
    private boolean[] editable = {false,true,true,false,false};
       
    public void visualizar(JTable tabla){
        
//        tabla.setDefaultRenderer(Object.class, new Render());
        
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Deposito", "Produto", "Etiqueta", "Qtdade", "Data","Usuario","Status","Observacao"}, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class
            };
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column > 0 && column < 4){
                    return true;
                }else{
                    return false;
                }
            }

            @Override
            public void setValueAt(Object aValue, int row, int column) {  
                    String vdepo = this.getValueAt(row, 0).toString();
                    if(column == 1){                          
                        super.setValueAt(aValue, row, column);
                    } else {
                        super.setValueAt(aValue, row, column);
                    }
                    
            }                       
            
        
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        
        
        datainv = Main.novadata.getText();  
        ArrayList<Te220con> list =  ChamarDeposito.ccont.ListaTe220con(datainv);
              
        if(list.size() > 0){
        for(int i=0; i< list.size(); i++){
            Object fila[] = new Object[8];
            fila[0] = list.get(i).getUSU_CODDEP();
            fila[1] = list.get(i).getUSU_CODPRO();
            fila[2] = list.get(i).getUSU_ETIQUETA();
            fila[3] = list.get(i).getUSU_QTDCON();
            fila[4] = list.get(i).getUSU_DATCON();
            fila[5] = list.get(i).getUSU_USUCON();
            fila[6] = list.get(i).getUSU_INDBIP();
            fila[7] = list.get(i).getUSU_OBSBIP();
            dt.addRow(fila);            
        }
        tabla.setModel(dt);
        }
        
        
        tabla.getColumnModel().getColumn(0).setMinWidth(200);
        tabla.getColumnModel().getColumn(0).setMaxWidth(200);
        tabla.getColumnModel().getColumn(0).setWidth(200);
        
        tabla.getColumnModel().getColumn(1).setMinWidth(200);
        tabla.getColumnModel().getColumn(1).setMaxWidth(200);
        tabla.getColumnModel().getColumn(1).setWidth(200);
               
        tabla.getColumnModel().getColumn(2).setMinWidth(200);
        tabla.getColumnModel().getColumn(2).setMaxWidth(200);
        tabla.getColumnModel().getColumn(2).setWidth(200);
              
        tabla.getColumnModel().getColumn(3).setMinWidth(110);
        tabla.getColumnModel().getColumn(3).setMaxWidth(110);
        tabla.getColumnModel().getColumn(3).setWidth(110);
               
        tabla.getColumnModel().getColumn(4).setMinWidth(110);
        tabla.getColumnModel().getColumn(4).setMaxWidth(110);
        tabla.getColumnModel().getColumn(4).setWidth(110);
               
        tabla.getColumnModel().getColumn(5).setMinWidth(90);
        tabla.getColumnModel().getColumn(5).setMaxWidth(90);
        tabla.getColumnModel().getColumn(5).setWidth(90);
       
        tabla.getColumnModel().getColumn(6).setMinWidth(50);
        tabla.getColumnModel().getColumn(6).setMaxWidth(50);
        tabla.getColumnModel().getColumn(6).setWidth(50);
        
    }
    
    
    

}

