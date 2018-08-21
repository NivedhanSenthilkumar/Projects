/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author mehta
 */
public class Test {
    
    private Date createdDate;

    private UserAccount lab;

    private UserAccount doctor;
    
    private String ggt;
    
    private String ast;
    
    private String mcv;
    
    public Test(UserAccount doc) {
        this.createdDate = new Date();
        this.doctor = doc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserAccount getLab() {
        return lab;
    }

    public void setLab(UserAccount lab) {
        this.lab = lab;
    }

    public UserAccount getDoctor() {
        return doctor;
    }

    public void setDoctor(UserAccount doctor) {
        this.doctor = doctor;
    }

    public String getGgt() {
        return ggt;
    }

    public void setGgt(String ggt) {
        this.ggt = ggt;
    }

    public String getAst() {
        return ast;
    }

    public void setAst(String ast) {
        this.ast = ast;
    }

    public String getMcv() {
        return mcv;
    }

    public void setMcv(String mcv) {
        this.mcv = mcv;
    }
    
    
}
