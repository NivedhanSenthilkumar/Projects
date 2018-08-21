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
public enum CounselorAssessmentEnum {
    
    NO("No"),
    YES("Yes"),
    CFO("Can't Find Out");

    private String value;

    private CounselorAssessmentEnum(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
