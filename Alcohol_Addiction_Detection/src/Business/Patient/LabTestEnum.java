/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

/**
 *
 * @author anubhavgupta
 */
public enum LabTestEnum {

    NORMAL("Normal"),
    HIGH("High");

    private String value;

    public String getValue() {
        return value;
    }
    
    private LabTestEnum(String value) {

        this.value = value;

    }

    @Override
    public String toString() {
        return getValue();
    }
    
    
    
    

}
