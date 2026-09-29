package form;

import classe.Render;
import classe.Tabela;
import java.awt.Color;
import java.awt.Font;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static main.Main.novadata;
import modelDominio.ProdutoCsv;
import modelDominio.ProdutoTxt;
import modelDominio.Te220csv;
import modelDominio.Te220txt;
import util.Configuracao;
import static util.Funcoes.formatarFloat;
import static util.Funcoes.formatarFloat0;
import static util.Funcoes.lpad;
import static util.Funcoes.parteData;
import static util.Funcoes.rpad;
import view.ChamarDeposito;
/**
 *
 * @author wilson
 */
public class FormExporta extends javax.swing.JPanel {
    private static final String DELIMITER = ";";
    private static final String LINE_SEPARATOR = "\n";
    private static final String DELIMITERT = ""; 
    int mvezes = 0;
    String cPadrao = "";
    //Configs config = new Configs();
    Tabela t = new Tabela();
    String datainv;
    String vDep;
    int vNum ;
    boolean vBlo;            
    int rown = -1;
    boolean todos;
    FormCarrega ho = new FormCarrega();     
     Configuracao arquivo = new Configuracao();
     
    public void atualizaTabela(){  
         datainv = arquivo.GetProp("datainv", "N");   
    }
    
    public FormExporta() {
        initComponents();
        setOpaque(false);
        
        Table.setDefaultRenderer(Object.class, new Render());
        Table.getColumnModel().getColumn(3).setCellRenderer(new Render());
        
        Table.getTableHeader().setFont(new Font("ARIAL",Font.BOLD,14));
        Table.getTableHeader().setOpaque(false);
        Table.getTableHeader().setBackground(new Color(32,136,203));
        Table.getTableHeader().setForeground(new Color(255,255,255));
        Table.setRowHeight(25); 
        
        t.visualizar(Table);
        vertexto();
        
    }
        
         
      public void gravaBlo(String vData,String vDeposito,int vContagem,boolean vBloqueio){          
         ChamarDeposito.ccont.Bloqueio(vData,vDeposito,vContagem,vBloqueio);
         vertexto();
      }
        
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        btnTodos = new javax.swing.JButton();

        Table.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Deposito", "Contagem", "Bloqueado", "Exportar", "Exporate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        Table.setShowGrid(true);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        Table.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TablePropertyChange(evt);
            }
        });
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
        }

        btnTodos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnTodos.setText("Bloquear todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnTodos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        rown = Table.rowAtPoint(evt.getPoint()); 
        int coluna = Table.getColumnModel().getColumnIndexAtX(evt.getX());
        int linha  = evt.getY()/Table.getRowHeight();
      
      if(linha < Table.getRowCount() && linha >= 0 && coluna < Table.getColumnCount() && coluna >=0){
          Object value = Table.getValueAt(linha, coluna);
         
          vDep = (String)Table.getValueAt(linha,0);
          vNum = Integer.parseInt(Table.getValueAt(linha,1).toString());
          vBlo = (boolean)Table.getValueAt(linha,2);
                  
          if(value instanceof JButton){
              ((JButton)value).doClick();
              JButton boton = (JButton) value;
              
             if(boton.getName().equals("TXT")){
                //EVENTOS
                gerarArqTxt();
                }
              if(boton.getName().equals("CSV")){
                gerarArqCsv();
                } 
          }
         
          if(value instanceof Boolean){
            if (vBlo){
                datainv = arquivo.GetProp("datainv", "N");   
                datainv = novadata.getText();
                vDep = (String)Table.getValueAt(linha,0);
                vNum = Integer.parseInt(Table.getValueAt(linha,1).toString());
                vBlo = (boolean)Table.getValueAt(linha,2);
                gravaBlo(datainv,vDep,vNum,vBlo);
             
            }else{
              
                //datainv = PropertiesUtil.getProperty("datainv"); 
                datainv = arquivo.GetProp("datainv", "N");   
                datainv = novadata.getText();
                vDep = (String)Table.getValueAt(linha,0);
                vNum = Integer.parseInt(Table.getValueAt(linha,1).toString());
                vBlo = (boolean)Table.getValueAt(linha,2);
                gravaBlo(datainv,vDep,vNum,vBlo);
               
            }             
          }
         
          
      }      
    }//GEN-LAST:event_TableMouseClicked

   
    
    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
       String texto = btnTodos.getText();
        if(texto.equals("Bloquear todos")){
            for (int i=0;i < Table.getRowCount();i++){
                Table.setValueAt(true, i,2);
                 //datainv = PropertiesUtil.getProperty("datainv"); 
                 datainv = arquivo.GetProp("datainv", "N");   
                 datainv = novadata.getText();
                 vDep = (String)Table.getValueAt(i,0);
                 vNum = Integer.parseInt(Table.getValueAt(i,1).toString());
                 vBlo = true;
                 gravaBlo(datainv,vDep,vNum,vBlo);
            }
        }else{
           for(int i = 0;i < Table.getRowCount();i++){
             Table.setValueAt(false, i,2);
              //datainv = PropertiesUtil.getProperty("datainv"); 
              datainv = arquivo.GetProp("datainv", "N");   
              datainv = novadata.getText();
              vDep = (String)Table.getValueAt(i,0);
              vNum = Integer.parseInt(Table.getValueAt(i,1).toString());
              vBlo = false;
              gravaBlo(datainv,vDep,vNum,vBlo);
            }
        }     
    }//GEN-LAST:event_btnTodosActionPerformed

    private void TablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TablePropertyChange
    
    }//GEN-LAST:event_TablePropertyChange

   
    private void vertexto(){
       todos = true;
       for (int i=0;i<Table.getRowCount();i++){
         vBlo = (boolean)Table.getValueAt(i,2);
         if(vBlo){    
            //todos=false;  
         }else{
             todos=false; 
         }
       }
       
            
       if(todos){
            btnTodos.setText("Desbloquear todos");
       
        }else{
           btnTodos.setText("Bloquear todos");
       
        }   
    }
     
    
  
    
      
private void gerarArqCsv(){

  String deposito = vDep; 
  datainv = arquivo.GetProp("datainv", "N");   
  datainv = novadata.getText();
  
  ArrayList<Te220csv> listaLeitura =  ChamarDeposito.ccont.ListaTe220csv(datainv,deposito);  
  mvezes = listaLeitura.size();
  ho.setVisible(true);
  
  int min = 0;
  int max = mvezes;
  FormCarrega.LBL_BARRA.setMaximum(min);
  FormCarrega.LBL_BARRA.setMaximum(max);
  FormCarrega.LBL_BARRA.setStringPainted(true);
  FormCarrega.LBL_BARRA.setValue(mvezes);


  SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy"); 
  String cCaminho = "\\\\hermes\\Inventario\\arq_txt\\";
  String cDia = parteData(datainv,"D");
  String cMes = parteData(datainv,"M");
  String cAno = parteData(datainv,"A");
  String url = cCaminho + "I" + cDia + cMes + cAno + deposito +".csv";           

  List<String> headers = new ArrayList<>();
  headers.add("CODEMP");
  headers.add("DATINV");
  headers.add("CODDEP");
  headers.add("CODPRO");
  headers.add("QTDCON");
  headers.add("DATCON");

  List<ProdutoCsv> products = new ArrayList<>();
  for(int i=0; i<mvezes; i++)  {
       FormCarrega.LBL_PORCENTAGEM.setText(Integer.toString(i)+" / " + Integer.toString(mvezes)+ " Registros");
       FormCarrega.LBL_BARRA.setValue(i);
       
       String colu101 = lpad(String.valueOf(listaLeitura.get(i).getUSU_CODEMP()),"0",4);
       String colu102 = formatador.format(listaLeitura.get(i).getUSU_DATINV());
       String colu103 = rpad(listaLeitura.get(i).getUSU_CODDEP()," ",10); 
       String colu104 = rpad(listaLeitura.get(i).getUSU_CODPRO()," ",14);
       String colu105 = formatarFloat0(listaLeitura.get(i).getUSU_QTDCON());
       String colu106 = formatador.format(listaLeitura.get(i).getUSU_DATCON());
       ProdutoCsv proc1 = new ProdutoCsv(colu101,colu102,colu103,colu104,colu105,colu106);
       products.add(proc1);
  }
 
   
  File file = new File(url);
   
  try(PrintWriter writer = new PrintWriter(file)){
      //write header
      writer.write(writeHeader(headers));
      // write body
      writer.write(writeBodyCSV(products));
// get path of file 
   
     JOptionPane.showMessageDialog(null, "Arquivo gerado", "Geracao de arquivo texto", HEIGHT);
     ho.setVisible(false);   
     
  }catch(Exception e){
      JOptionPane.showMessageDialog(null,  e.getMessage(), "Geracao de arquivo texto", JOptionPane.ERROR_MESSAGE);
      ho.setVisible(false); 
  };
}

   
  private static String writeHeader(List<String> headers){
      StringBuilder result = new StringBuilder();
      headers.stream().forEach(item-> result.append(item).append(DELIMITER));
      result.append(LINE_SEPARATOR);
      return result.toString();      
  }  
    
  private static String writeBodyCSV(List<ProdutoCsv> products){
      StringBuilder result = new StringBuilder();
      products.stream().forEach(item-> result.append(item.getUSU_CODEMP()).append(DELIMITER)
                                             .append(item.getUSU_DATINV()).append(DELIMITER)
                                             .append(item.getUSU_CODDEP()).append(DELIMITER)
                                             .append(item.getUSU_CODPRO()).append(DELIMITER)
                                             .append(item.getUSU_QTDCON()).append(DELIMITER)
                                             .append(item.getUSU_DATCON()).append(LINE_SEPARATOR));
      return result.toString();
      
  } 
  
 
  
  
  
private void gerarArqTxt(){   

  String deposito = vDep;
  //datainv = PropertiesUtil.getProperty("datainv");
  datainv = arquivo.GetProp("datainv", "N");   
  
  datainv = novadata.getText();
  ArrayList<Te220txt> listaLeitura = ChamarDeposito.ccont.ListaTe220txt(datainv,deposito);   
  mvezes = listaLeitura.size();
  ho.setVisible(true);
  
  int min = 0;
  int max = mvezes;
  FormCarrega.LBL_BARRA.setMaximum(min);
  FormCarrega.LBL_BARRA.setMaximum(max);
  FormCarrega.LBL_BARRA.setStringPainted(true);
  FormCarrega.LBL_BARRA.setValue(mvezes);


  SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
  String cCaminho = "\\\\hermes\\Inventario\\arq_txt\\";
  String cDia = parteData(datainv,"D");
  String cMes = parteData(datainv,"M");
  String cAno = parteData(datainv,"A");
  String url = cCaminho + "I" + cDia + cMes + cAno + deposito +".txt";           
  cPadrao = "";
  if(deposito.equals("DEPGERAL") || deposito.equals("DEPKANBAN"))
    {
      cPadrao = "      ";
    } else {
      cPadrao = "PADRAO";
    }   
       
  String campobranco = " "; 
  String campobranc1 = "0";
  List<ProdutoTxt> products = new ArrayList<>();
  for(int i=0; i<mvezes; i++)  {
       FormCarrega.LBL_PORCENTAGEM.setText(Integer.toString(i)+" / " + Integer.toString(mvezes)+ " Registros");
       FormCarrega.LBL_BARRA.setValue(i);
       
       String colu101 = "1";
       String colu102 = lpad(String.valueOf(listaLeitura.get(i).getUSU_CODEMP()),"0",4);
       String colu103 = formatador.format(listaLeitura.get(i).getUSU_DATINV());
       String colu104 = rpad(listaLeitura.get(i).getUSU_CODDEP()," ",10);       
       String colu105 = rpad(listaLeitura.get(i).getUSU_CODPRO()," ",14);       
       String colu106 = rpad(cPadrao," ",7); 
       String colu107 = lpad(String.valueOf(listaLeitura.get(i).getUSU_NUMCON()),"0",2);                      
       String colu108 = formatarFloat(listaLeitura.get(i).getUSU_QTDCON());
       String colu109 = lpad(campobranco," ",50);
       String colu110 = lpad(campobranco," ",10);
       String colu111 = lpad(campobranco," ",10);
       String colu112 = lpad(campobranco," ",10);
       String colu113 = lpad(campobranco," ",10);       
       ProdutoTxt proc1 = new ProdutoTxt(colu101,colu102,colu103,colu104,colu105,colu106,colu107,colu108,colu109,colu110,colu111,colu112,colu113);
       products.add(proc1);
      
       
       
       String colu201 = "2";
       String colu202 = colu102;
       String colu203 = colu103;
       String colu204 = colu104;
       String colu205 = colu105;
       String colu206 = colu106;
       String colu207 = colu107;
       String colu208 = lpad(String.valueOf(listaLeitura.get(i).getUSU_USUCON()),"0",7);
       String colu209 = lpad(campobranc1,"0",50);
       String colu210 = lpad(campobranc1,"0",50);
       String colu211 = formatador.format(listaLeitura.get(i).getUSU_DATCON());
       String colu212 = colu108;
       String colu213 = "00.000.000.000,00";
       
       ProdutoTxt proc2 = new ProdutoTxt(colu201,colu202,colu203,colu204,colu205,colu206,colu207,colu208,colu209,colu210,colu211,colu212,colu213);
       products.add(proc2);
  }
 
   
  File file = new File(url);
 
  try(PrintWriter writer = new PrintWriter(file)){
      // write body
      writer.write(writeBodyTxt(products));
// get path of file 
   
     JOptionPane.showMessageDialog(null, "Arquivo gerado", "Geracao de arquivo texto", HEIGHT);
     ho.setVisible(false);  
     
  }catch(Exception e){
      JOptionPane.showMessageDialog(null,  e.getMessage(), "Geracao de arquivo texto", JOptionPane.ERROR_MESSAGE);
      ho.setVisible(false); 
  };
}
  
  
  
private static String writeBodyTxt(List<ProdutoTxt> products){
      StringBuilder result = new StringBuilder();
      products.stream().forEach(item-> result.append(item.getUSU_ORDEM()).append(DELIMITERT)
                                             .append(item.getUSU_CODEMP()).append(DELIMITERT)
                                             .append(item.getUSU_DATINV()).append(DELIMITERT)
                                             .append(item.getUSU_CODDEP()).append(DELIMITERT)
                                             .append(item.getUSU_CODPRO()).append(DELIMITERT)
                                             .append(item.getUSU_CODDER()).append(DELIMITERT)
                                             .append(item.getUSU_NUMCON()).append(DELIMITERT)
                                             .append(item.getUSU_QTDCON()).append(DELIMITERT)
                                             .append(item.getUSU_USUCON()).append(DELIMITERT)
                                             .append(item.getUSU_DATCON()).append(DELIMITERT)
                                             .append(item.getUSU_ETIQUETA()).append(DELIMITERT)
                                             .append(item.getUSU_INDBIP()).append(DELIMITERT)
                                             .append(item.getUSU_OBSBIP()).append(LINE_SEPARATOR));
      return result.toString();
      
  } 
  
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private static javax.swing.JButton btnTodos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
   
}
