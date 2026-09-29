/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author wilson.simoes
 */
public class Configuracao {
     public static Properties prop = new Properties();
     final String secretKey = "ssshhhhhhhhhhh!!!!";
     
     public void SaveProp(String title, String value,String encry) {
        try
        {
            String cvalue = value;
            if(encry.equals("S")){
                cvalue =   Encryption.encrypt(value, secretKey) ;
            }            
            
            prop.setProperty(title, cvalue);
            prop.store(new FileOutputStream("config.properties"),null);
     
        }catch(IOException e){
            System.out.println("erro " + e.getMessage());
        }        
    }
	
    
    public static String GetProp(String title,String encry)
    {
        String value = "";
        String cvalor = "";
        try
        {
           prop.load(new FileInputStream("config.properties"));
           cvalor = prop.getProperty(title);
           
          if(encry.equals("S")){
                //cvalor =   Encryption.decrypt(cvalor, secretKey) ;
            } 
         value = cvalor;  
           
        }catch(IOException e)
        {
            
        }
        return value;
    }  
    
}
