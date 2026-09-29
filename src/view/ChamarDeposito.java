package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import main.Main;

/**
 *
 * @author wilson.simoes
 */
public class ChamarDeposito {
    
public static ConexaoController ccont;
    
    public static void main(String [] args){
      Socket socket ;
      ObjectInputStream in = null;
      ObjectOutputStream out = null; 
      
     try {
            // 1 abrir conexao
            socket = new Socket("192.168.0.170",12347);
            
            // 2 - definir stream de saida de dados do cliente
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            
            //out.writeObject(System.getProperty("user.name"));
            //System.getProperty("user.name")
            //criar conexao controller
            ccont = new ConexaoController(in, out, 0);
            
            Main formp = new Main();       
            formp.setVisible(true);
            
        } catch(Exception e) {
            e.printStackTrace(System.err);
            
        }    
    }    
}
