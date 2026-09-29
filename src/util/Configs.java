package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author wilson
 */
public class Configs {  
    static File file;
    public static Properties prop = new Properties();    
    public void SaveProp(String title, String value){
        try
        {                       
            prop.setProperty(title, value);
//            prop.store(new FileOutputStream("/config.properties"), null);
prop.store(new FileOutputStream("main.config"), null);
        }catch(IOException e)                          
        {
        }
    }
   
   
    public String GetProp(String title)    {
        String value = "";
        try
        {           
           prop.load(new FileInputStream("/config.properties"));
           value = prop.getProperty(title);
          
        }catch(IOException e)
        {
            
        }
        return value;
    }
   
    
    
    
    
    
   public void saveProperties(Properties p) throws IOException
    {   
        try (FileOutputStream fr = new FileOutputStream(file)) {        
            p.store(fr, "Properties");
            fr.close();
        }      
    }

    public void loadProperties(Properties p)throws IOException
    {
        FileInputStream fi=new FileInputStream(file);
        p.load(fi);
        fi.close();
    }
     
    
    
    
    
    
    
    
    
    
}
