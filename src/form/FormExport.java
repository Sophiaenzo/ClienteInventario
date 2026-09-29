package form;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelDominio.ProdutoCsv;
import modelDominio.ProdutoTxt;
import util.Configs;
import view.ChamarDeposito;
import modelDominio.Te220csv;
import modelDominio.Te220inv;
import modelDominio.Te220txt;
import static util.Funcoes.formatarFloat;
import static util.Funcoes.parteData;
import static util.Funcoes.rpad;
import static util.Funcoes.lpad;
import static util.Funcoes.formatarFloat0;
import util.PropertiesUtil;
/**
 *
 * @author wilson
 */
public class FormExport extends javax.swing.JPanel {
    private static final String DELIMITER = ";";
    private static final String LINE_SEPARATOR = "\n";
    private static final String DELIMITERT = "";  
    Configs config = new Configs();
    int mvezes = 0;
    String cPadrao = "";
    
    FormCarrega ho = new FormCarrega();    
     
    public FormExport() {
        initComponents();
        setOpaque(false);
        atualizaCombo();      
    }
 
    private void atualizaCombo(){     
        String datainv1 = PropertiesUtil.getProperty("datainv");
        ArrayList<Te220inv> listaDadosok = ChamarDeposito.ccont.ListaTe220inv(datainv1);
        jComboDep.removeAllItems();          
        for(Te220inv f: listaDadosok) {
            jComboDep.addItem(f);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel1 = new swing.RoundPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRaTXT = new javax.swing.JRadioButton();
        jRaCSV = new javax.swing.JRadioButton();
        jComboDep = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Exportar para");

        jButton1.setText("Confirme");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jRaTXT.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jRaTXT);
        jRaTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRaTXT.setForeground(new java.awt.Color(255, 255, 255));
        jRaTXT.setText("Arq - TEXTO");
        jRaTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRaTXTActionPerformed(evt);
            }
        });

        jRaCSV.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jRaCSV);
        jRaCSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRaCSV.setForeground(new java.awt.Color(255, 255, 255));
        jRaCSV.setText("Arq - EXCELL");

        jComboDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDepActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecione o deposito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRaCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboDep, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jRaTXT)
                .addGap(18, 18, 18)
                .addComponent(jRaCSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
   
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        Thread t = new Thread(){
          @Override
          public void run(){            
              if (jRaTXT.isSelected()== true)
                {
                       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                       String data = "12/03/2023";
                       System.out.println(data);
                       gerarArqTxt();
                }
                else if (jRaCSV.isSelected()==true)
                {       
                       String valor = (String)(jComboDep.getSelectedItem().toString());
                       System.out.println(valor);
                       gerarArqCsv();
                }            
                
          }            
        };
        t.start();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboDepActionPerformed

    private void jRaTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRaTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRaTXTActionPerformed

    
    
private void gerarArqCsv(){

  String deposito = (String)(jComboDep.getSelectedItem().toString()); 
  String datainv = PropertiesUtil.getProperty("datainv");   
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
  //String cCaminho = "C:\\\\afiles\\";
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
 
   
  File file = new File(cCaminho);
 // if(file.exists() && file.isFile()){
 //     file.delete();
// }
  
  try(PrintWriter writer = new PrintWriter(file)){
      //write header
      writer.write(writeHeader(headers));
      // write body
      writer.write(writeBodyCSV(products));
// get path of file 
     System.out.println(file.getAbsolutePath());
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

  String deposito = (String)(jComboDep.getSelectedItem().toString()); 
  String datainv = PropertiesUtil.getProperty("datainv");   
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
  //String cCaminho = "C:\\\\afiles\\";
  String cCaminho = "\\\\hermes\\Inventario\\arq_txt\\";
  String cDia = parteData(datainv,"D");
  String cMes = parteData(datainv,"M");
  String cAno = parteData(datainv,"A");
  String url = cCaminho + "I" + cDia + cMes + cAno + deposito +".txt";           
  cPadrao = "";
  if(deposito.equals("DEPGERAL") || deposito.equals("DEPKANBAN"))
    {
      cPadrao = "TESTE0";
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
 
   
  File file = new File(cCaminho);
  //if(file.exists() && file.isFile()){
  //    file.delete();
 // }
  
  try(PrintWriter writer = new PrintWriter(file)){
      // write body
      writer.write(writeBodyTxt(products));
// get path of file 
     System.out.println(file.getAbsolutePath());
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboDep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRaCSV;
    private javax.swing.JRadioButton jRaTXT;
    private swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
