package form;

import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import main.Main;
import util.Configuracao;
import static util.ValidaData.isValidDate;
import static util.ValidaData.isValidFormat;
import view.ChamarDeposito;


/**
 *
 * @author wilson
 */
public class FormData extends javax.swing.JPanel {
    Configuracao arquivo = new Configuracao();
    
    
    public FormData() {
        initComponents();
        ini();
        formatarCampo();
        setOpaque(false);       
    }
  


   public void ini(){
     //
   }
    
    public void formatarCampo(){
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.install(jdata);
        } catch (ParseException ex) {
            System.out.println("Ocorreu erro na mascara FormTe220inv linha 50");
        }
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jdata = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data de Inventario");

        jButton1.setText("Confirme");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdata, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String data = jdata.getText();
       
 
       boolean isValidPatten = isValidFormat(data);
       if (isValidPatten)
        {
            if (isValidDate(data))
                {         
                    arquivo.SaveProp("datainv", data,"N");
                    Main.novadata.setText(data);                  
                    Main.Instance.lbl.setText("Data ativa inventario: " +  data);
                    
                    ChamarDeposito.ccont.verInicio(data);
                  
                }else
                {
                   JOptionPane.showMessageDialog(null,data + " e uma data invalida ");
                }

         }else 
        {
            JOptionPane.showMessageDialog(null,"Formato da data invalida ");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField jdata;
    // End of variables declaration//GEN-END:variables
}
