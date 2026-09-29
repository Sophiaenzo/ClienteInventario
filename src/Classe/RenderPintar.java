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
public class RenderPintar extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        
        table.setRowHeight(30);
        //setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        table.getTableHeader().setFont(table.getFont().deriveFont(30f));
        table.setFont(new Font("Serif", Font.BOLD, 20));
        Object object = table.getValueAt(row, 5);
        Double valor = Double.valueOf(object.toString());
      
        if(valor < 0 && column == 5 ) {
            setBackground(Color.RED);
        } else if(valor > 0 && column == 5 ) {
           setBackground(Color.GREEN); 
        } else {
            setBackground(Color.WHITE);
        }
     
        return label;
        
    }

  
}
