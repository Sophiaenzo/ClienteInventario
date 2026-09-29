package form;

import chart.ModelChart;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import modelDominio.Te220inv;
import modelDominio.Te220sal;
import util.Configs;
import util.Configuracao;
import view.ChamarDeposito;
import view.tablemodel.TE220invTableModel;

/**
 *
 * @author wilson
 */
public class FormGrafico extends javax.swing.JPanel {
    Configs config = new Configs();
    private TE220invTableModel Te220invModel;
    private String grafico = "S";
    Configuracao arquivo = new Configuracao();
    
    public FormGrafico() {
        initComponents();
        setOpaque(false);
  
        jCDeposito.setVisible(false);
        init();
    }

    private void atualizaCombo(){    
        String datainv1 = arquivo.GetProp("datainv", "N");   
        
        ArrayList<Te220inv> listaDadosok = ChamarDeposito.ccont.ListaTe220inv(datainv1);
        jCDeposito.removeAllItems();          
        for(Te220inv f: listaDadosok) {
            jCDeposito.addItem(f);
        }
    }
    
    
    private void init() {
        atualizaGrafico();
    }
    
    private void montaGrafico(){
        if (grafico == "S")
            { 
               grafico = "N";
               chart.addLegend("Bipados", new Color(12, 84, 175), new Color(0, 108, 247));
               chart.addLegend("Certos",  new Color(5, 125, 0), new Color(95, 209, 69));
               chart.addLegend("Errados", new Color(186, 37, 37), new Color(241, 100, 120));
            }
        for(int i=0;i<jCDeposito.getModel().getSize();i++)
            {             
                                           
             
                String datainv1 = arquivo.GetProp("datainv", "N");   
                
                String nome = jCDeposito.getModel().getElementAt(i).toString();
                String depo01 = null;
                Float valor01 = 0f;
                Float valor02 = 0f;
                Float valor03 = 0f;  
                             
                
//                System.out.println(nome +" - "+ datainv1);
                
                
                ArrayList<Te220sal> listaDadosok =  ChamarDeposito.ccont.ListaTe220sal(nome, datainv1);
                
                for(Te220sal f: listaDadosok){ 
                    depo01  = f.getDeposito();
                    valor01 = f.getEsto();
                    valor02 = f.getCerto();
                    valor03 = f.getErrado();
                }  
                           
                chart.addData(new ModelChart(nome  , new double[]{valor01,valor02,valor03})); 
            }
            chart.start();
    }        
    
    private void atualizaGrafico(){
        
        atualizaCombo();
        montaGrafico(); 
        
        
       Timer timer = new Timer();
               
        final long segundos = (1000 * 5); //tempo 5 segundos
        
        TimerTask tarefa = new TimerTask(){
            @Override
            public void run(){
                chart.clear();
                montaGrafico();
            }
        };
        timer.scheduleAtFixedRate(tarefa, 0, segundos);
        
    }

            
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing.RoundPanel();
        chart = new chart.Chart();
        jCDeposito = new javax.swing.JComboBox();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        jCDeposito.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCDeposito.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jCDepositoComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jCDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCDepositoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jCDepositoComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jCDepositoComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chart.Chart chart;
    private javax.swing.JComboBox jCDeposito;
    private swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
