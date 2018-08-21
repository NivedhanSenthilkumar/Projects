/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Assessment;
import Business.Patient.CounselorAssessment;
import Business.Patient.CounselorAssessmentEnum;
import Business.Patient.CounselorAssessmentReportEnum;
import Business.Patient.LabAssessmentEnum;
import Business.Patient.LabTestEnum;
import Business.Patient.Patient;
import Business.Patient.ViolenceEnum;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabAssessment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Dell
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private PersonDirectory personDirectory;
    //private PatientDirectory patientDirectory;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null, null);
        networkList = new ArrayList<>();
        personDirectory = new PersonDirectory();
        // patientDirectory = new PatientDirectory();

    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    public Person createAndAddPerson(String firstName, String lastName) {

        Person p = personDirectory.createPerson(firstName, lastName);
        return p;
    }

    public Person makeInActive(int id) {

        Person p = findById(id);
        p.setActive(false);
        return p;
    }

    public Person findById(int id) {

        return personDirectory.findById(id);

    }

    public List<Person> getAllPersons() {

        return personDirectory.getPersons();

    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

        List<UserAccount> getAllUserAccounts = this.getAllEnterprises().stream()
                .flatMap(e -> e.getAllUserAccounts().stream())
                .collect(Collectors.toList());

        boolean userNameAlreadyPresent = getAllUserAccounts.stream()
                .anyMatch(account -> account.getUsername().equals(username));

        return !userNameAlreadyPresent;
    }

    private List<UserAccount> getAllUserAccounts() {

        List<UserAccount> getAllUserAccounts = this.getAllEnterprises().stream()
                .flatMap(e -> e.getAllUserAccounts().stream())
                .collect(Collectors.toList());

        return getAllUserAccounts;

    }

    public void printAllUserAccounts() {

        for (UserAccount ua : getAllUserAccounts()) {

            System.out.println("Role " + ua.getRole() + " " + "UserName " + ua.getUsername() + " " + "Password " + ua.getPassword());
        }

    }

    public List<Enterprise> getAllEnterprises() {

        return getNetworkList().stream()
                .flatMap(network -> network.getEnterpriseDirectory().getEnterpriseList().stream())
                .collect(Collectors.toList());

    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public Map<String, Long> getZoneConcentration() {

        Map<String, Long> zoneConcentration = getAllAssessments().stream()
                .map(a -> a.getZone().getValue())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return zoneConcentration;

    }

    public List<Assessment> getAllAssessments() {

        List<Assessment> allAssessments = this.networkList.stream()
                .flatMap(n -> n.getAllAssessment().stream())
                .collect(Collectors.toList());

        return allAssessments;

    }

    public Map<Integer, Long> getHighZonePattern() {

        Map<Integer, Long> getAnsweringPattern = this.getAllAssessments().stream()
                .flatMap(a -> a.getHighScoringQuestions().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return getAnsweringPattern;

    }

    public List<CounselorAssessment> getAllCounselorAssessments() {
        List<CounselorAssessment> allCounselorAssessments = this.getAllFirstAssessments().stream()
                .filter(a -> a.getCounselorAssessment() != null)
                .map(a -> a.getCounselorAssessment())
                .collect(Collectors.toList());

        return allCounselorAssessments;

    }
    
      public List<Assessment> getAllFirstAssessments() {

        List<Assessment> allAssessments = this.networkList.stream()
                .flatMap(n -> n.getAllFirstAssessment().stream())
                .collect(Collectors.toList());

        return allAssessments;

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

    public List<Patient> getAllPatientsWithMin2Assessments() {

        List<Patient> allPatients = this.getNetworkList().stream()
                .flatMap(n -> n.getAllPatientsWithMin2Assessments().stream())
                .collect(Collectors.toList());

        return allPatients;

    }

    public List<LabAssessment> getAllLabAssessments() {

        List<LabAssessment> labAssessments = this.getNetworkList().stream()
                .flatMap(n -> n.getAllLabAssessments().stream())
                .collect(Collectors.toList());

        return labAssessments;
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

    public Map<String, Integer> getNetworkLevelAlcoholCrime() {

        Map<String, Integer> networkLevelCrimeCount = this.networkList.stream()
                .collect(Collectors.toMap(n -> n.getName(), n -> n.getAlcoholRelatedCrimeCount()));

        return networkLevelCrimeCount;

    }

}
