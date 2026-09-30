package classe;

import javax.swing.JTable;

public class Table {
    private boolean[] editTable = {false,false,true,false,false};
    
     public void visualizar(JTable table){
        table.setDefaultRenderer(Object.class,new RenderTable());
        
            Class[] types = new Class[]{
              java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
            };
            
     } 
}
