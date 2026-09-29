package Classe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author wilson.simoes
 */
public class RenderPinta2 extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        
        table.setRowHeight(30);
        //setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        table.getTableHeader().setFont(table.getFont().deriveFont(30f));
        table.setFont(new Font("Serif", Font.BOLD, 20));
        Object object = table.getValueAt(row, 7);
        String valor = String.valueOf(object.toString());
//      
//        if(!valor.equals("Lancamento efetuado com sucesso")  && column == 7 ) {
//            setBackground(Color.red);
//        } else {
//            setBackground(Color.RED);
//        }
     
        return label;
        
    }

  
}
