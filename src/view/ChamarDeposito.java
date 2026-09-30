package view;

import controller.ConexaoController;

import java.io.IOException;
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
    Socket socket = null;
    ObjectInputStream in = null;
    ObjectOutputStream out = null; 
    
    try {
        // 1 - abrir conexao
        socket = new Socket("192.168.0.119", 12347);
        
        // 2 - definir stream de saida e entrada de dados do cliente
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        
        // criar conexao controller
        ccont = new ConexaoController(in, out, 0);
        
        Main formp = new Main();       
        formp.setVisible(true);
        
    } catch(Exception e) {
        e.printStackTrace(System.err);
        
        // Fecha as conexões se houver erro ao inicializar
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (socket != null && !socket.isClosed()) socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    }
}
