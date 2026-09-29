package raven.cell;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author wilson.simoes
 */
public class TableActionCellRender extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable,Object o, boolean isSeleted, boolean bln1, int row, int column){
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        
        PanelAction action=new PanelAction();
        if(isSeleted == false && row % 2 == 0) {
            action.setBackground(Color.GREEN);
        }else{
            action.setBackground(Color.BLUE);
        }
        action.setBackground(com.getBackground());
        return action;
    }
    
}
