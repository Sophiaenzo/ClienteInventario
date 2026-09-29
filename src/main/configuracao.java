package main;

import java.util.ResourceBundle;

/**
 *
 * @author wilson.simoes
 */
public class configuracao {
    private static final ResourceBundle config_system = ResourceBundle.getBundle("main.config");
    
    
    
    public static String getData(String data){
       if(config_system.containsKey(data)){
           return config_system.getString(data);
       } 
       return "01/01/2022";
    }
}
