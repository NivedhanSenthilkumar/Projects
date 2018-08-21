/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabAssessment;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anubhavgupta
 */
public class Assessment {

    private int score;

    private Date createdDate;

    private UserAccount nurse;

    private UserAccount doctor;

    private UserAccount counsellor;

    private UserAccount labAssistant;

    private ZonesEnum zone;

    private LabAssessment labAssessment;

    private CounselorAssessment counselorAssessment;

    private Map<Integer, List<String>> questionAnswer;

    public Assessment(int score, UserAccount nurse, ZonesEnum zone) {
        this.score = score;
        this.createdDate = new Date();
        this.nurse = nurse;
        this.zone = zone;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserAccount getNurse() {
        return nurse;
    }

    public void setNurse(UserAccount nurse) {
        this.nurse = nurse;
    }

    public UserAccount getDoctor() {
        return doctor;
    }

    public void setDoctor(UserAccount doctor) {
        this.doctor = doctor;
    }

    public UserAccount getCounsellor() {
        return counsellor;
    }

    public void setCounsellor(UserAccount counsellor) {
        this.counsellor = counsellor;
    }

    public ZonesEnum getZone() {
        return zone;
    }

    public void setZone(ZonesEnum zone) {
        this.zone = zone;
    }

    public LabAssessment getLabAssessment() {
        return labAssessment;
    }

    public void setLabAssessment(LabAssessment labAssessment) {
        this.labAssessment = labAssessment;
    }

    public UserAccount getLabAssistant() {
        return labAssistant;
    }

    public void setLabAssistant(UserAccount labAssistant) {
        this.labAssistant = labAssistant;
    }

    public CounselorAssessment getCounselorAssessment() {
        return counselorAssessment;
    }

    public void setCounselorAssessment(CounselorAssessment counselorAssessment) {
        this.counselorAssessment = counselorAssessment;
    }

    public Map<Integer, List<String>> getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(Map<Integer, List<String>> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    @Override
    public String toString(){
        return getNurse().getFirstName();
    }
    
    
    public  List<Integer> getHighScoringQuestions(){
        
        //Map<Integer,Integer> pattern = new HashMap<>();
        
        List<Integer> highScoringQuestion = new ArrayList<>();
        
        for (Map.Entry<Integer, List<String>> entry : this.getQuestionAnswer().entrySet()) {
            Integer key = entry.getKey();
            //Integer answerValue = 0;
            
            String answerCode = entry.getValue().get(0);
            String[] data = answerCode.split("_");
            Integer answerOption = Integer.parseInt(data[1]);
            if(answerOption >= 2){
                highScoringQuestion.add(key);
            }
           // pattern.put(key, answerValue);
            
            
        }
        
        return highScoringQuestion;
        
        
    }

}
