/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Patient.Assessment;
import Business.Patient.Patient;
import Business.Patient.PatientRequestStatus;
import static Business.Patient.PatientRequestStatus.Assessment;
import Business.Patient.ZonesEnum;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author anubhavgupta
 */
public class PatientEvaluationWorkRequest extends WorkRequest {

//    private int score;

    private PatientRequestStatus patientRequestStatus;

    private Patient patient;

    private Date createdDate;

    private Date lastModifiedDate;

//   // private UserAccount nurse;
//
//   // private UserAccount doctor;
//
//    private UserAccount counsellor;
//
//    private UserAccount labAssistant;
//
//    private ZonesEnum zone;

    private Assessment assessment;

//    private LabAssessment labAssessment;

    public PatientEvaluationWorkRequest() {

        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

//    public UserAccount getNurse() {
//        return nurse;
//    }
//
//    public void setNurse(UserAccount nurse) {
//        this.nurse = nurse;
//    }
//
//    public UserAccount getDoctor() {
//
//        return doctor;
//    }
//
//    public void setDoctor(UserAccount doctor) {
//        this.doctor = doctor;
//    }
//
//    public UserAccount getCounsellor() {
//        return counsellor;
//    }
//
//    public void setCounsellor(UserAccount counsellor) {
//        this.counsellor = counsellor;
//    }
//
//    public ZonesEnum getZone() {
//        return zone;
//    }
//
//    public void setZone(ZonesEnum zone) {
//        this.zone = zone;
//    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientRequestStatus getPatientRequestStatus() {
        return patientRequestStatus;
    }

    public void setPatientRequestStatus(PatientRequestStatus patientRequestStatus) {
        this.patientRequestStatus = patientRequestStatus;
    }

//    public LabAssessment getLabAssessment() {
//        return labAssessment;
//    }
//
//    public void setLabAssessment(LabAssessment labAssessment) {
//        this.labAssessment = labAssessment;
//    }

//    public UserAccount getLabAssistant() {
//        return labAssistant;
//    }
//
//    public void setLabAssistant(UserAccount labAssistant) {
//        this.labAssistant = labAssistant;
//    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    @Override
    public String toString() {
        return patient.getPatientname();
    }
}
