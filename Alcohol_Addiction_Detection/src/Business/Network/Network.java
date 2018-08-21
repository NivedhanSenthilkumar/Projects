/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.Patient.Assessment;
import Business.Patient.CounselorAssessment;
import Business.Patient.CounselorAssessmentEnum;
import Business.Patient.CounselorAssessmentReportEnum;
import Business.Patient.LabAssessmentEnum;
import Business.Patient.LabTestEnum;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Patient.ViolenceEnum;
import Business.Patient.ZonesEnum;
import Business.WorkQueue.LabAssessment;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Dell
 */
public class Network {

    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private PatientDirectory patientDirectory;

    public Network() {

        enterpriseDirectory = new EnterpriseDirectory();
        patientDirectory = new PatientDirectory();
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public List<Assessment> getAllAssessment() {

        List<Assessment> allAssessments = this.patientDirectory.getPatientlist().stream()
                .filter(p -> !p.getAssessments().isEmpty())
                .map(p -> p.getPatientLatestAssessment())
                .collect(Collectors.toList());

        return allAssessments;

    }

    public List<Assessment> getAllFirstAssessment() {

        List<Assessment> allAssessments = this.patientDirectory.getPatientlist().stream()
                .filter(p -> !p.getAssessments().isEmpty())
                .map(p -> p.getPatientFirstAssessment())
                .collect(Collectors.toList());

        return allAssessments;

    }

    public List<LabAssessment> getAllLabAssessments() {

        List<LabAssessment> labAssessments = this.patientDirectory.getPatientlist().stream()
                .filter(p -> !p.getAssessments().isEmpty())
                .filter(p -> p.getPatientLatestAssessment().getLabAssessment() != null)
                .map(p -> p.getPatientLatestAssessment().getLabAssessment())
                .collect(Collectors.toList());
        return labAssessments;
    }

    public Map<String, Long> getZoneConcentration() {

        Map<String, Long> zoneConcentration = this.getAllAssessment().stream()
                .map(a -> a.getZone().getValue())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return zoneConcentration;

    }

    public long getZone3Zone4Count() {

        long zone3zone4Count = this.getAllAssessment().stream()
                .filter(a -> (a.getZone() == ZonesEnum.ZONE3 || a.getZone() == ZonesEnum.ZONE4))
                .count();

        return zone3zone4Count;

    }

    public Map<Integer, Long> getHighZonePattern() {

        Map<Integer, Long> getAnsweringPattern = this.getAllAssessment().stream()
                .flatMap(a -> a.getHighScoringQuestions().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return getAnsweringPattern;

    }

    public Map<Integer, Long> getZoneLevelPattern(ZonesEnum zone) {

        Map<Integer, Long> getAnsweringPattern = this.getAllAssessment().stream()
                .filter(a -> a.getZone() == zone)
                .flatMap(a -> a.getHighScoringQuestions().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return getAnsweringPattern;

    }

    public int getCountofFactor(CounselorAssessmentReportEnum counselorAssessmentReportEnum) {

        Predicate<CounselorAssessment> p = null;

        switch (counselorAssessmentReportEnum) {

            case DRINKINGTOCOPE:

                p = c -> c.getDrinkingToCope() == CounselorAssessmentEnum.YES;
                break;

            case FamilySocialSupport:

                p = c -> c.getFamilySocialSupport() == CounselorAssessmentEnum.NO;
                break;

            case FriendSocialSupport:

                p = c -> c.getFriendSocialSupport() == CounselorAssessmentEnum.NO;
                break;
            case DrinkingToEnhance:

                p = c -> c.getDrinkingToEnhance() == CounselorAssessmentEnum.YES;
                break;

            case NegativeLifeEventsinLastYear:

                p = c -> c.getNegativeLifeEventsinLastYear() == CounselorAssessmentEnum.YES;
                break;

            case Violence:

                p = c -> c.getViolenceEnum() != ViolenceEnum.NA;
                break;

            default:

        }

        Long count = this.getAllCounselorAssessments().stream()
                .filter(p)
                .count();

        return count.intValue();

    }

    public List<CounselorAssessment> getAllCounselorAssessments() {
        List<CounselorAssessment> allCounselorAssessments = this.getAllFirstAssessment().stream()
                .filter(a -> a.getCounselorAssessment() != null)
                .map(a -> a.getCounselorAssessment())
                .collect(Collectors.toList());

        return allCounselorAssessments;

    }

    public List<Map<Integer, List<String>>> getAllQuestionAnswersMap() {

        List<Map<Integer, List<String>>> questionAnswersMap = this.getAllAssessment().stream()
                .map(a -> a.getQuestionAnswer())
                .collect(Collectors.toList());

        return questionAnswersMap;

    }

    public List<Patient> getAllPatientsWithMin2Assessments() {

        List<Patient> allPatients = this.patientDirectory.getPatientlist().stream()
                .filter(p -> p.getAssessments().size() >= 2)
                .collect(Collectors.toList());

        return allPatients;

    }

    public int getCountofLabTests(LabAssessmentEnum labAssessmentEnum) {

        Predicate<LabAssessment> p = null;

        switch (labAssessmentEnum) {

            case GGT:

                p = c -> c.getGGT() == LabTestEnum.HIGH;
                break;

            case MCV:

                p = c -> c.getMCV() == LabTestEnum.HIGH;
                break;

            case CDT:

                p = c -> c.getCDT() == LabTestEnum.HIGH;
                break;

            case AST:

                p = c -> c.getAST() == LabTestEnum.HIGH;
                break;

            default:

        }

        Long count = this.getAllLabAssessments().stream()
                .filter(p)
                .count();

        return count.intValue();

    }

    public int getPatientProgress(boolean positiveProgress) {
        Predicate<Patient> predicate;

        if (positiveProgress) {
            predicate = p -> p.isProgressPositive();
        } else {

            predicate = p -> !p.isProgressPositive();

        }

        Long countPatientWithProgress = getAllPatientsWithMin2Assessments().stream()
                .filter(predicate)
                .count();

        return countPatientWithProgress.intValue();

    }

    public Map<String, Long> getAlcoholRelatedCrimeReport() {

        Map<String, Long> alcoholRelatedCrime = this.getAllCounselorAssessments().stream()
                .filter(c -> c.getViolenceEnum() != ViolenceEnum.NA)
                .map(c -> c.getViolenceEnum().getValue())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return alcoholRelatedCrime;

    }

    public int getAlcoholRelatedCrimeCount() {

        Long count = this.getAllCounselorAssessments().stream()
                .filter(c -> c.getViolenceEnum() != ViolenceEnum.NA)
                .count();

        return count.intValue();

    }

}
