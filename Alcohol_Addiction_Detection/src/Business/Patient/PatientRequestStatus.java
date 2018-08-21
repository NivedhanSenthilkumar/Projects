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
public enum PatientRequestStatus {

    Assessment("Assessment Done"),
    RequestLabTest("Request for Lab Test"),
    LabTestDone("Lab Report Generated"),
    Recommended_Rehab("Counseling"),
    Discharged("Discharged"),
    Completed("Completed");

    private String value;

    public String getValue() {
        return value;
    }

    private PatientRequestStatus(String value) {

        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
    
    

}
