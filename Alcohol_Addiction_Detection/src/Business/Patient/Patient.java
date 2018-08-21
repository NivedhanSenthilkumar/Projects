/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Patient {

    private int id;
    private String patientname;
    private int age;
    private String city;
    private String state;
    private String address;
    private String gender;
    private String martialstatus;
    private int registrationno;
    private Date registerationdate;
    public int count = 0;

    private List<Assessment> assessments;

    public Patient() {
        count++;
        id = count;
        this.assessments = new ArrayList<>();
        this.registerationdate = new Date();
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMartialstatus() {
        return martialstatus;
    }

    public void setMartialstatus(String martialstatus) {
        this.martialstatus = martialstatus;
    }

    public int getRegistrationno() {
        return registrationno;
    }

    public void setRegistrationno(int registrationno) {
        this.registrationno = registrationno;
    }

    public Date getRegisterationdate() {
        return registerationdate;
    }

    public void setRegisterationdate(Date registerationdate) {
        this.registerationdate = registerationdate;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public void setDoctorInAssessment(UserAccount doctor) {
        getAssessments().get(assessments.size() - 1).setDoctor(doctor);
    }

    public void setLabAssistantInAssessment(UserAccount labAssistant) {
        getAssessments().get(assessments.size() - 1).setLabAssistant(labAssistant);
    }

    public void setCouncellor(UserAccount counsellor) {
        getAssessments().get(assessments.size() - 1).setCounsellor(counsellor);
    }

    public String toString() {
        return patientname;
    }

    public Assessment getPatientLatestAssessment() {

        if (getAssessments().isEmpty()) {
            return null;
        }

        return getAssessments().get(assessments.size() - 1);

    }
    
    public Assessment getPatientFirstAssessment() {

        if (getAssessments().isEmpty()) {
            return null;
        }

        return getAssessments().get(0);

    }

    public boolean isProgressPositive() {

        boolean isPositiveProgress = false;

        if (assessments.size() < 2) {

            return isPositiveProgress;
        }

        Assessment firstAssessment = assessments.get(0);
        Assessment lastAssessment = getPatientLatestAssessment();

        int firstScore = firstAssessment.getScore();
        int lastScore = lastAssessment.getScore();

        int difference = firstScore - lastScore;

        if (firstScore > 30) {

            if (difference >= 10) {
                isPositiveProgress = true;
            }

        } else if (firstScore > 20 && firstScore <= 30) {

            if (difference >= 6) {
                isPositiveProgress = true;
            }

        } else {

            if (difference >= 5) {
                isPositiveProgress = true;
            }

        }

        return isPositiveProgress;

    }
    
    
    public boolean isFirstAssessmentHighZone(){
        
        
        Assessment firstAssessment = assessments.get(0);
        boolean isZone3Zone4 = firstAssessment.getZone() == ZonesEnum.ZONE3 || firstAssessment.getZone() == ZonesEnum.ZONE4;
        
        
        return isZone3Zone4;
        
    }

}
