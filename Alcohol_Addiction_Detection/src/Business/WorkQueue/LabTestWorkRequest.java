/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author mehta
 */

import Business.Patient.Patient;
import Business.Patient.PatientRequestStatus;
import Business.Patient.ZonesEnum;
import Business.UserAccount.UserAccount;
import java.util.Date;

public class LabTestWorkRequest extends WorkRequest {
    
    private Patient patient;
    
    private UserAccount doctor;
    
    private UserAccount labAssistant;
    
    private PatientRequestStatus patientRequestStatus;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public UserAccount getDoctor() {
        return doctor;
    }

    public void setDoctor(UserAccount doctor) {
        this.doctor = doctor;
    }

    public UserAccount getLabAssistant() {
        return labAssistant;
    }

    public void setLabAssistant(UserAccount labAssistant) {
        this.labAssistant = labAssistant;
    }

    public PatientRequestStatus getPatientRequestStatus() {
        return patientRequestStatus;
    }

    public void setPatientRequestStatus(PatientRequestStatus patientRequestStatus) {
        this.patientRequestStatus = patientRequestStatus;
    }

     
    @Override
    public String toString(){
        return patient.getPatientname();
    }
}
