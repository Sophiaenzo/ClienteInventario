package form;

import Classe.RenderPinta2;
import Classe.TabelaLista;
import java.awt.Font;
import java.util.ArrayList;
import view.*;
import modelDominio.Te220con;
import view.tablemodel.TE220conTableModel;
import util.Configuracao;
/**
 *
 * @author wilson
 */
public class FormLista extends javax.swing.JPanel {
    private TE220conTableModel Te220conModel;
    String datainv;
    Configuracao arquivo = new Configuracao();
    
//    TabelaLista t = new TabelaLista(); //teste
    
    
     
    public void atualizaTabela(){  
      
        datainv = arquivo.GetProp("datainv", "N");  
      
        ArrayList<Te220con> listaDadosok =  ChamarDeposito.ccont.ListaTe220con(datainv);
        Te220conModel = new TE220conTableModel(listaDadosok);
//        Table.setDefaultRenderer(Object.class, new RenderPinta2());
        Table.setModel(Te220conModel);
      
               
        Table.setRowHeight(30);
        Table.getTableHeader().setFont(Table.getFont().deriveFont(18f));
        Table.setFont(new Font("Serif", Font.BOLD, 18));
               
        Table.getColumnModel().getColumn(0).setMinWidth(200);
        Table.getColumnModel().getColumn(0).setMaxWidth(200);
        Table.getColumnModel().getColumn(0).setWidth(200);
        
        Table.getColumnModel().getColumn(1).setMinWidth(200);
        Table.getColumnModel().getColumn(1).setMaxWidth(200);
        Table.getColumnModel().getColumn(1).setWidth(200);
               
        Table.getColumnModel().getColumn(2).setMinWidth(200);
        Table.getColumnModel().getColumn(2).setMaxWidth(200);
        Table.getColumnModel().getColumn(2).setWidth(200);
              
        Table.getColumnModel().getColumn(3).setMinWidth(110);
        Table.getColumnModel().getColumn(3).setMaxWidth(110);
        Table.getColumnModel().getColumn(3).setWidth(110);
               
        Table.getColumnModel().getColumn(4).setMinWidth(110);
        Table.getColumnModel().getColumn(4).setMaxWidth(110);
        Table.getColumnModel().getColumn(4).setWidth(110);
               
        Table.getColumnModel().getColumn(5).setMinWidth(90);
        Table.getColumnModel().getColumn(5).setMaxWidth(90);
        Table.getColumnModel().getColumn(5).setWidth(90);
       
        Table.getColumnModel().getColumn(6).setMinWidth(50);
        Table.getColumnModel().getColumn(6).setMaxWidth(50);
        Table.getColumnModel().getColumn(6).setWidth(50);
       
//       
//            Table.setRowHeight(30);
//            Table.getTableHeader().setFont(Table.getFont().deriveFont(18f));
//            Table.setFont(new Font("Serif", Font.BOLD, 18));
//            t.visualizar(Table); //teste
        
    }
    
    
    public FormLista() {
        initComponents();
        setOpaque(false);
        atualizaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Deposito", "Produto", "Etiqueta", "Qtdade", "Data", "Usuario", "Status", "Observacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setShowGrid(true);
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(0).setPreferredWidth(50);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(1).setPreferredWidth(50);
            Table.getColumnModel().getColumn(2).setResizable(false);
            Table.getColumnModel().getColumn(2).setPreferredWidth(80);
            Table.getColumnModel().getColumn(3).setResizable(false);
            Table.getColumnModel().getColumn(3).setPreferredWidth(50);
            Table.getColumnModel().getColumn(4).setResizable(false);
            Table.getColumnModel().getColumn(4).setPreferredWidth(60);
            Table.getColumnModel().getColumn(5).setResizable(false);
            Table.getColumnModel().getColumn(5).setPreferredWidth(50);
            Table.getColumnModel().getColumn(6).setResizable(false);
            Table.getColumnModel().getColumn(6).setPreferredWidth(50);
            Table.getColumnModel().getColumn(7).setResizable(false);
            Table.getColumnModel().getColumn(7).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
   
}
