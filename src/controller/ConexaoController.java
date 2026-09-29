package controller;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import modelDominio.Te220con;
import modelDominio.Te220cons;
import modelDominio.Te220csv;
import modelDominio.Te220inv;
import modelDominio.Te220invc;
import modelDominio.Te220ite;
import modelDominio.Te220sal;
import modelDominio.Te220txt;
import util.Operacoes;

/**
 *
 * @author wilson
 */
public class ConexaoController {
    
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private int idUnico;
   
    public ConexaoController(ObjectInputStream in, ObjectOutputStream out, int idUnico) {
        this.in = in;
        this.out = out;
        this.idUnico = idUnico;
    }
    
  
  
       //inserir novas rotinas     
     
       public ArrayList<Te220inv> ListaTe220inv(String mData){
            try
            {
              //out.writeObject("enchecombo");    
              Operacoes m = new Operacoes("enchecombo");
              m.setParam("data",mData);
              m.setParam("tipo","Preencher Combo");
              out.writeObject(m);             
              out.flush();
              ArrayList<Te220inv> Dadoslista = (ArrayList<Te220inv>) in.readObject();              
              return Dadoslista; 
                           
            }catch(Exception e){
                   System.out.println(e.getMessage());
                return null;
            }
         }    
       
       
        public ArrayList<Te220invc> ListaContagem(String mData){
            try
            {
                
                          
              Operacoes m = new Operacoes("depositoscontagem");
              m.setParam("data",mData);
              m.setParam("tipo","Controle de contagem");
              out.writeObject(m);             
              out.flush();
              
              
              ArrayList<Te220invc> Dadoslista = (ArrayList<Te220invc>) in.readObject();              
              return Dadoslista; 
                           
            }catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
         }    
       
       
       
       public ArrayList<Te220con> ListaTe220con(String mData){
            try
            {
              //out.writeObject("enchecombo");    
              Operacoes m = new Operacoes("leituraInventario");
              m.setParam("data",mData);
              m.setParam("tipo","Preencher Lista");
              out.writeObject(m);             
              out.flush();
              ArrayList<Te220con> Dadoslista = (ArrayList<Te220con>) in.readObject();              
              return Dadoslista; 
                           
            }catch(Exception e){
                e.printStackTrace(System.err);
                return null;
            }
         }    
       
       
       public ArrayList<Te220sal> ListaTe220sal(String mDeposito,String mData){
            try
            {
            
              Operacoes m = new Operacoes("verificaSaldo");
              m.setParam("data",mData);
              m.setParam("tipo",mDeposito);
              out.writeObject(m);             
              out.flush();
              ArrayList<Te220sal> Dadoslista = (ArrayList<Te220sal>) in.readObject();              
              return Dadoslista; 
                           
            }catch(Exception e){
                e.printStackTrace(System.err);
                return null;
            }
         }  
       
       public ArrayList<Te220txt> ListaTe220txt(String mData, String mDeposito){
            try
            {
              //out.writeObject("enchecombo");    
              Operacoes m = new Operacoes("exportartxt");
              m.setParam("data",mData);
              m.setParam("tipo",mDeposito);
              out.writeObject(m);             
              out.flush();
              ArrayList<Te220txt> listaDados = (ArrayList<Te220txt>) in.readObject();              
              return listaDados;
                           
            }catch(Exception e){
                e.printStackTrace(System.err);
                return null;
            }
         } 
       
       public ArrayList<Te220csv> ListaTe220csv(String mData, String mDeposito){
            try
            {
              //out.writeObject("enchecombo");    
              Operacoes m = new Operacoes("exportarcsv");
              m.setParam("data",mData);
              m.setParam("tipo",mDeposito);
              out.writeObject(m);             
              out.flush();
              ArrayList<Te220csv> listaDados = (ArrayList<Te220csv>) in.readObject();              
              return listaDados;
                           
            }catch(Exception e){
                e.printStackTrace(System.err);
                return null;
            }
         } 
       
       
      public void Bloqueio(String vData,String vDeposito,int vContagem,boolean vBloqueio){
            try
            {
              Operacoes m = new Operacoes("bloqueio");
              m.setParam("data",vData);
              m.setParam("deposito",vDeposito);
              m.setParam("cont",vContagem);
              m.setParam("bloq",vBloqueio);
              m.setParam("tipo","bloquear inventario");
              out.writeObject(m);             
              out.flush();
            }catch(Exception e){
                e.printStackTrace(System.err);
           }
         }     
        
      public void verBloqueio(String vData,String vDeposito){
            try
            {
              Operacoes m = new Operacoes("verbloqueio");
              m.setParam("data",vData);
              m.setParam("deposito",vDeposito);
              m.setParam("tipo","bloquear inventario");
              out.writeObject(m);             
              out.flush();
            }catch(Exception e){
                e.printStackTrace(System.err);
           }
         }     
        
       public void verInicio(String vData){
            try
            {
              Operacoes m = new Operacoes("verInicio");
              m.setParam("data",vData);
              m.setParam("tipo","Verificar inicio inventario");
              out.writeObject(m);             
              out.flush();
            }catch(Exception e){
                e.printStackTrace(System.err);
           }
         }     
      
      
       public ArrayList<Te220ite> ListaTe220ite(String mData, String mDeposito){
            try
            {            
              Operacoes m = new Operacoes("verificacontagem");
              m.setParam("data",mData);
              m.setParam("tipo",mDeposito);
              out.writeObject(m);             
              out.flush();
              ArrayList<Te220ite> Dadoslista = (ArrayList<Te220ite>) in.readObject();              
              return Dadoslista;                            
            }catch(Exception e){
                e.printStackTrace(System.err);
                return null;
            }
         }  
      
    /*   
    public ArrayList<Te220ite> ListaTe220ite(String mData, String mDeposito) {
    ArrayList<Te220ite> dadosLista = null;
    try (Socket socket = new Socket("localhost", 12345);
         ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
         ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

        Operacoes m = new Operacoes("verificacontagem");
        m.setParam("data", mData);
        m.setParam("tipo", mDeposito);

        out.writeObject(m);
        out.flush();

        dadosLista = (ArrayList<Te220ite>) in.readObject();

    } catch (Exception e) {
        e.printStackTrace(System.err);
    }
    return dadosLista;
} 
      */ 
      public String versaoAtual(){
            try
            {
              Operacoes m = new Operacoes("versaoatual");
              m.setParam("data",null);
              m.setParam("tipo","Verificar versao");
              out.writeObject(m);             
              out.flush();
              String versao = (String) in.readObject();
              return versao;
            }catch(Exception e){
                e.printStackTrace(System.err);
                return null;
           }
         }     
   
      
      public ArrayList<Te220cons> UltimaContagem(String vData, String vDeposito){
          try
            {
                       
              Operacoes m = new Operacoes("proximacontagem");
              m.setParam("data",vData);
              m.setParam("deposito",vDeposito);
              m.setParam("tipo","Verificar qual e proxima contagem");
              out.writeObject(m);             
              out.flush();
              ArrayList<Te220cons> DadosContagem = (ArrayList<Te220cons>) in.readObject();              
              return DadosContagem;  
            }catch(Exception e){
                e.printStackTrace(System.err);
                return null;
           }
         }     
       
      
       
       
}