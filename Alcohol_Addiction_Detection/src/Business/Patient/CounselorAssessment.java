/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.Date;

/**
 *
 * @author anubhavgupta
 */
public class CounselorAssessment {

    private CounselorAssessmentEnum drinkingToCope;

    private CounselorAssessmentEnum drinkingToSocialize;

    private CounselorAssessmentEnum drinkingToEnhance;

    private CounselorAssessmentEnum drinkingToConform;

    private CounselorAssessmentEnum sensationSeeking;

    private CounselorAssessmentEnum negativeLifeEventsinLastYear;

    private CounselorAssessmentEnum antisocialPersonalityTraits;

    private CounselorAssessmentEnum traitAnxiety;

    private CounselorAssessmentEnum familySocialSupport;

    private CounselorAssessmentEnum friendSocialSupport;

    private ViolenceEnum violenceEnum;
    
    private Date createdDate;

    public CounselorAssessment() {

        this.createdDate = new Date();
    }

    public CounselorAssessmentEnum getDrinkingToCope() {
        return drinkingToCope;
    }

    public void setDrinkingToCope(CounselorAssessmentEnum drinkingToCope) {
        this.drinkingToCope = drinkingToCope;
    }

    public CounselorAssessmentEnum getDrinkingToSocialize() {
        return drinkingToSocialize;
    }

    public void setDrinkingToSocialize(CounselorAssessmentEnum drinkingToSocialize) {
        this.drinkingToSocialize = drinkingToSocialize;
    }

    public CounselorAssessmentEnum getDrinkingToEnhance() {
        return drinkingToEnhance;
    }

    public void setDrinkingToEnhance(CounselorAssessmentEnum drinkingToEnhance) {
        this.drinkingToEnhance = drinkingToEnhance;
    }

    public CounselorAssessmentEnum getDrinkingToConform() {
        return drinkingToConform;
    }

    public void setDrinkingToConform(CounselorAssessmentEnum drinkingToConform) {
        this.drinkingToConform = drinkingToConform;
    }

    public CounselorAssessmentEnum getSensationSeeking() {
        return sensationSeeking;
    }

    public void setSensationSeeking(CounselorAssessmentEnum sensationSeeking) {
        this.sensationSeeking = sensationSeeking;
    }

    public CounselorAssessmentEnum getNegativeLifeEventsinLastYear() {
        return negativeLifeEventsinLastYear;
    }

    public void setNegativeLifeEventsinLastYear(CounselorAssessmentEnum negativeLifeEventsinLastYear) {
        this.negativeLifeEventsinLastYear = negativeLifeEventsinLastYear;
    }

    public CounselorAssessmentEnum getAntisocialPersonalityTraits() {
        return antisocialPersonalityTraits;
    }

    public void setAntisocialPersonalityTraits(CounselorAssessmentEnum antisocialPersonalityTraits) {
        this.antisocialPersonalityTraits = antisocialPersonalityTraits;
    }

    public CounselorAssessmentEnum getTraitAnxiety() {
        return traitAnxiety;
    }

    public void setTraitAnxiety(CounselorAssessmentEnum traitAnxiety) {
        this.traitAnxiety = traitAnxiety;
    }

    public CounselorAssessmentEnum getFamilySocialSupport() {
        return familySocialSupport;
    }

    public void setFamilySocialSupport(CounselorAssessmentEnum familySocialSupport) {
        this.familySocialSupport = familySocialSupport;
    }

    public CounselorAssessmentEnum getFriendSocialSupport() {
        return friendSocialSupport;
    }

    public void setFriendSocialSupport(CounselorAssessmentEnum friendSocialSupport) {
        this.friendSocialSupport = friendSocialSupport;
    }

    public ViolenceEnum getViolenceEnum() {
        return violenceEnum;
    }

    public void setViolenceEnum(ViolenceEnum violenceEnum) {
        this.violenceEnum = violenceEnum;
    }

    

    public Date getCreatedDate() {
        return createdDate;
    }

    
}
