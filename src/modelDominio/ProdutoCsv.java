/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author wilson.simoes
 */
public class ProdutoCsv {
    private static final long serialVersionUID = 123456789L;
    private String USU_CODEMP;
    private String USU_DATINV;
    private String USU_CODDEP;
    private String USU_CODPRO;
    private String USU_QTDCON;
    private String USU_DATCON;

    public ProdutoCsv(String USU_CODEMP, String USU_DATINV, String USU_CODDEP, String USU_CODPRO, String USU_QTDCON, String USU_DATCON) {
        this.USU_CODEMP = USU_CODEMP;
        this.USU_DATINV = USU_DATINV;
        this.USU_CODDEP = USU_CODDEP;
        this.USU_CODPRO = USU_CODPRO;
        this.USU_QTDCON = USU_QTDCON;
        this.USU_DATCON = USU_DATCON;
    }

    public String getUSU_CODEMP() {
        return USU_CODEMP;
    }

    public void setUSU_CODEMP(String USU_CODEMP) {
        this.USU_CODEMP = USU_CODEMP;
    }

    public String getUSU_DATINV() {
        return USU_DATINV;
    }

    public void setUSU_DATINV(String USU_DATINV) {
        this.USU_DATINV = USU_DATINV;
    }

    public String getUSU_CODDEP() {
        return USU_CODDEP;
    }

    public void setUSU_CODDEP(String USU_CODDEP) {
        this.USU_CODDEP = USU_CODDEP;
    }

    public String getUSU_CODPRO() {
        return USU_CODPRO;
    }

    public void setUSU_CODPRO(String USU_CODPRO) {
        this.USU_CODPRO = USU_CODPRO;
    }

    public String getUSU_QTDCON() {
        return USU_QTDCON;
    }

    public void setUSU_QTDCON(String USU_QTDCON) {
        this.USU_QTDCON = USU_QTDCON;
    }

    public String getUSU_DATCON() {
        return USU_DATCON;
    }

    public void setUSU_DATCON(String USU_DATCON) {
        this.USU_DATCON = USU_DATCON;
    }
    
    
    

}
