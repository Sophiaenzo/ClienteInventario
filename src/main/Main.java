package main;

import event.EventMenu;
import form.Form;
import form.FormData;
import form.FormEsto;
import form.FormExporta;
import form.FormGrafico;
import form.FormLista;
import java.awt.Component;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Configuracao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 *
 * @author wilson
 */
public class Main extends javax.swing.JFrame {      
    public static int tela = 0;
    public static Main Instance;
    public JLabel lbl;
    public JLabel label = new JLabel();
    Configuracao arquivo = new Configuracao();
   
    String datainv1 = arquivo.GetProp("datainv", "N");   
   
        public static void mostraconfig() throws IOException{    
           novadata.setText(Configuracao.GetProp("datainv", "N"));          
        }
        
        
    
    public Main() throws IOException {
        
              
        initComponents();
        Instance = this;
        lbl = lbatual;
        novadata.setVisible(false);
        txttitulo.setVisible(false);
        label = new ClockLabel(); 
       
       
        mostraconfig();
        
       lbatual.setText("Data de Inventario: " + datainv1);
        EventMenu event = new EventMenu() {
            @Override
                     
            public void selected(int index) {
                if (index == 0) {  
                     //chama tela para informar data de inventario 
                     txttitulo.setVisible(false);
                     showForm(new FormData());                
                } else if (index == 1) {
                     txttitulo.setVisible(false);
                     showForm(new FormExporta());
                } else if (index == 2) {
                    txttitulo.setText("Tela atualizada a cada 3 segundo:");
                    txttitulo.setVisible(true);
                    showForm(new FormEsto());
                } else if (index == 3) {
                    txttitulo.setVisible(false);
                    showForm(new FormGrafico());
                } else if (index == 4) {
                    txttitulo.setVisible(false);
                    showForm(new FormLista());
                } else if (index == 5) {
                        // chama opcao para fechar o sistema
                      System.exit(0);
                } else {
                    // chama tela padrao ainda nao definida
                    showForm(new Form(index));
                }
            }
        };
        
           
        ini();
        menu2.initMenu(event);
     
    }

    
    public void ini(){          
    }
    
    
   public void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
       
      }
   
   public class ClockLabel extends JLabel {

    public ClockLabel() {
        Timer t = new Timer(1000, e -> setText(getDateTime()));
        t.setInitialDelay(0);
        t.start();
    }

    private String getDateTime() {
        String rr;
        rr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString();
        jLabelHorario.setText(rr);
        return null; //LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
   
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        novadata = new javax.swing.JTextField();
        roundPanel1 = new swing.RoundPanel();
        header1 = new component.Header();
        lbatual = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        txttitulo = new javax.swing.JLabel();
        menu2 = new component.Menu();
        body = new javax.swing.JPanel();

        novadata.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(21, 21, 21));

        lbatual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbatual.setForeground(new java.awt.Color(255, 255, 255));
        lbatual.setText("Data Inventario:");

        jLabelHorario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelHorario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHorario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHorario.setText("jLabel1");
        jLabelHorario.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txttitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttitulo.setForeground(new java.awt.Color(255, 255, 255));
        txttitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txttitulo.setText("jLabel1");

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbatual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbatual)
                    .addComponent(jLabelHorario)
                    .addComponent(txttitulo))
                .addContainerGap())
        );

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//         Date dataSistema = new Date();
//         SimpleDateFormat aformato = new SimpleDateFormat("dd/MM/yyyy");
//         jldata.setText(aformato.format(dataSistema));
//        
//        Timer timer = new Timer(1000, new hora());
//        timer.start();    
//        
    }//GEN-LAST:event_formWindowOpened

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private component.Header header1;
    private static javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel lbatual;
    private component.Menu menu2;
    public static javax.swing.JTextField novadata;
    private swing.RoundPanel roundPanel1;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables



}
