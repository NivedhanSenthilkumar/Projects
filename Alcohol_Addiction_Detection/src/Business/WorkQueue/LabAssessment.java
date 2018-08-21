/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Patient.LabTestEnum;
import java.util.Date;

/**
 *
 * @author anubhavgupta
 */
public class LabAssessment {

    private LabTestEnum GGT;

    private LabTestEnum CDT;

    private LabTestEnum MCV;

    private LabTestEnum AST;

    private Date createdDate;

    public LabAssessment() {

        this.createdDate = new Date();
    }

    public LabTestEnum getGGT() {
        return GGT;
    }

    public void setGGT(LabTestEnum GGT) {
        this.GGT = GGT;
    }

    public LabTestEnum getCDT() {
        return CDT;
    }

    public void setCDT(LabTestEnum CDT) {
        this.CDT = CDT;
    }

    public LabTestEnum getMCV() {
        return MCV;
    }

    public void setMCV(LabTestEnum MCV) {
        this.MCV = MCV;
    }

    public LabTestEnum getAST() {
        return AST;
    }

    public void setAST(LabTestEnum AST) {
        this.AST = AST;
    }

}
