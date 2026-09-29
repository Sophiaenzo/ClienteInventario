/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.Main;
import modelDominio.Te220cons;
import modelDominio.Te220invc;
import util.Configuracao;
import util.PropertiesUtil;
import view.ChamarDeposito;

/**
 *
 * @author wilson
 */
public class Tabela {
    //Configs config = new Configs();
    //String datainv = PropertiesUtil.getProperty("datainv");
    
    Configuracao arquivo = new Configuracao();
    String datainv = arquivo.GetProp("datainv", "N");   
    
    boolean Todos;
    private boolean[] editable = {false,true,true,false,false};
       
    public void visualizar(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Deposito", "Contagem", "Bloqueado", "Exportar", "Exportar"}, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class,
                java.lang.Integer.class,
                java.lang.Boolean.class,
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
                            if(isNumeric(aValue,vdepo))
                                 super.setValueAt(aValue, row, column);
                            else return;
                    } else {
                        super.setValueAt(aValue, row, column);
                    }
                    
            }                       
            
        
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        
        
        JButton btn_TXT = new JButton("TXT");
        JButton btn_CSV = new JButton("CSV");
        btn_TXT.setName("TXT");
        btn_CSV.setName("CSV");
       
        datainv = Main.novadata.getText();   
        ArrayList<Te220invc> list =  ChamarDeposito.ccont.ListaContagem(datainv);
              
        if(list.size() > 0){
        for(int i=0; i< list.size(); i++){
            Object fila[] = new Object[6];
            fila[0] = list.get(i).getUsu_coddep();
            fila[1] = list.get(i).getUsu_ultcon();
            String var = list.get(i).getUsu_blomov();
            if(var.equals("1"))
            { 
                fila[2] = true;
            }
            else 
            {
                fila[2] = false;
            }            
            fila[3] = btn_TXT;        
            fila[4] = btn_CSV;        
            dt.addRow(fila);            
        }
        tabla.setModel(dt);
        }
    }
    
     private boolean isNumeric(Object obj,String vDeposito){
         int proximo=0;
         if(obj==null) return false;
           String datainv = PropertiesUtil.getProperty("datainv");
                
            ArrayList<Te220cons> listaConta =  ChamarDeposito.ccont.UltimaContagem(datainv, vDeposito);
            int mvezes = listaConta.size();
            for(int i=0; i<mvezes; i++)  {
                proximo = listaConta.get(i).getUSU_NUMCON();   
            }

            
           
         try{	
             Integer.parseInt(String.valueOf(obj));
             int digitado = Integer.parseInt(String.valueOf(obj));
            
             
             if (digitado == proximo || digitado == (proximo + 1)) {
                return true;
             }else {
                 JOptionPane.showMessageDialog(null, "Proxima contagem deve ser " + (proximo + 1));  
                 return false;
             }
             
             
         }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Valor invalido esse campo e numerico");  
            return false;
         }
     }
    

}
