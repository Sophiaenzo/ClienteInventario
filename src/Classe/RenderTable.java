package classe;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int row, int column) {
        if (o instanceof JButton){
            JButton botton = (JButton)o;
            if(bln){
                botton.setForeground(table.getSelectionForeground());
                botton.setBackground(table.getSelectionBackground());
            }else{
                botton.setForeground(table.getForeground());
                botton.setBackground(UIManager.getColor("Button.background"));
            }
            
            
            return botton;        
        }
        
        if (o instanceof JCheckBox){
            JCheckBox ch = (JCheckBox)o;
            
            return ch;
        }
        return super.getTableCellRendererComponent(table, o, bln, bln1, row, column);
    }

    
    
}
