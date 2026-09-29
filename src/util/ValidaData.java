/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.ParseException;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

/**
 * Funcao para validar data
 * @author wilson.simoes
 */
public class ValidaData {
    /**
     * funcao validata
     */
    
    private static Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
    
    public static boolean isValidFormat(String datestr){
        /**
         * parametros
         */
        
        if (DATE_PATTERN.matcher(datestr).matches())
            return true;
        
        return false;
    }
    
    /**
     * parametros da funcao
     * @param dateStr
     * @return 
     */
    public static boolean isValidDate(String dateStr)
    {
        SimpleDateFormat simplesdateformat = new SimpleDateFormat("dd/MM/yyyy");
        simplesdateformat.setLenient(false);
        try
        {
         simplesdateformat.parse(dateStr);
         return true;
        }
        catch(ParseException ex)
        {
         return false;   
        }
    
    }
    
}