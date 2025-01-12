/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Rehab;

import Business.Enterprise.Enterprise;
import Business.Patient.Assessment;
import Business.Patient.CounselorAssessment;
import Business.Patient.CounselorAssessmentEnum;
import Business.Patient.Patient;
import Business.Patient.PatientRequestStatus;
import Business.Patient.ViolenceEnum;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PatientEvaluationWorkRequest;
import UserInterface.Clinic.DoctorWorkAreaJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author anubhavgupta
 */
public class CounselorAssessmentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CounselorAssessmentJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Patient patient;
    private PatientEvaluationWorkRequest patientEvaluationWorkRequest;

    public CounselorAssessmentJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, PatientEvaluationWorkRequest patientEvaluationWorkRequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.patientEvaluationWorkRequest = patientEvaluationWorkRequest;
        this.patient = patientEvaluationWorkRequest.getPatient();
        populateFields();
        setSize(1200,1200);
    }

    private void populateFields() {

        Assessment assessment = patientEvaluationWorkRequest.getAssessment();

        lblPatientName.setText(patient.getPatientname());
        lblScore.setText(String.valueOf(assessment.getScore()));
        lblZone.setText(assessment.getZone().getValue());

        Component[] components = this.getComponents();
        List<Component> comList = Arrays.asList(components)
                .stream()
                .filter(com -> com instanceof JComboBox)
                .collect(Collectors.toList());

        for (Component comp : comList) {
            JComboBox box = ((JComboBox) comp);
            box.removeAllItems();

        }

        for (CounselorAssessmentEnum value : CounselorAssessmentEnum.values()) {

            comboAntisocial.addItem(value);
            comboConform.addItem(value);
            comboDrinkCope.addItem(value);
            comboEnhance.addItem(value);
            comboFamilySupport.addItem(value);
            comboNegativeLifeEvent.addItem(value);
            comboSensationSeeking.addItem(value);
            comboSocialSupport.addItem(value);
            comboSocialize.addItem(value);
            comboTraitAnxiety.addItem(value);

        }

        for (ViolenceEnum value : ViolenceEnum.values()) {
            comboViolence.addItem(value);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comboDrinkCope = new javax.swing.JComboBox();
        comboSocialize = new javax.swing.JComboBox();
        comboEnhance = new javax.swing.JComboBox();
        comboConform = new javax.swing.JComboBox();
        comboSensationSeeking = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        comboNegativeLifeEvent = new javax.swing.JComboBox();
        comboAntisocial = new javax.swing.JComboBox();
        comboFamilySupport = new javax.swing.JComboBox();
        comboSocialSupport = new javax.swing.JComboBox();
        comboTraitAnxiety = new javax.swing.JComboBox();
        comboViolence = new javax.swing.JComboBox();
        lblPatientName = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblZone = new javax.swing.JLabel();
        lblNegative = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Brief Intervention");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Assessment Report :");

        jLabel3.setText("Patient");

        jLabel4.setText("Evaluation Score ");

        jLabel5.setText("Zone");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Qualitative Analysis :");

        jLabel8.setText("Drinking to Cope");

        jLabel9.setText("Drinking to Socialize");

        jLabel10.setText("Drinking to Enhance");

        jLabel11.setText("Drinking to Conform");

        jLabel12.setText("Sensation Seeking");

        comboDrinkCope.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboSocialize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboEnhance.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboConform.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboSensationSeeking.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSensationSeeking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSensationSeekingActionPerformed(evt);
            }
        });

        jLabel13.setText("Antisocial Personality Trait");

        jLabel14.setText("Family Social Support");

        jLabel15.setText("Friend Social Support");

        jLabel16.setText("Trait Anxiety");

        jLabel17.setText("Involved in Violence");

        jLabel18.setText("Negative Life Event");

        comboNegativeLifeEvent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboAntisocial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboFamilySupport.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboSocialSupport.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboTraitAnxiety.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboViolence.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSubmit.setText("Submit Analysis");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSocialize, 0, 140, Short.MAX_VALUE)
                                    .addComponent(comboEnhance, 0, 140, Short.MAX_VALUE)
                                    .addComponent(comboDrinkCope, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(48, 48, 48)
                                .addComponent(comboConform, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel18))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboSensationSeeking, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboNegativeLifeEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboFamilySupport, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboSocialSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboAntisocial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel17)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(167, 167, 167)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboViolence, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboTraitAnxiety, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSubmit)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(lblNegative, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(113, 113, 113)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblZone, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblPatientName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblZone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNegative)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboDrinkCope, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(comboAntisocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboSocialize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(comboFamilySupport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboEnhance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(comboSocialSupport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboConform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(comboTraitAnxiety, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboSensationSeeking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(comboViolence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboNegativeLifeEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSubmit))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        Assessment assessment = patientEvaluationWorkRequest.getAssessment();

        CounselorAssessmentEnum antisocial = (CounselorAssessmentEnum) comboAntisocial.getSelectedItem();
        CounselorAssessmentEnum conform = (CounselorAssessmentEnum) comboConform.getSelectedItem();
        CounselorAssessmentEnum drinkCope = (CounselorAssessmentEnum) comboDrinkCope.getSelectedItem();
        CounselorAssessmentEnum enhance = (CounselorAssessmentEnum) comboEnhance.getSelectedItem();
        CounselorAssessmentEnum familySupport = (CounselorAssessmentEnum) comboFamilySupport.getSelectedItem();
        CounselorAssessmentEnum negativeLifeEvent = (CounselorAssessmentEnum) comboNegativeLifeEvent.getSelectedItem();
        CounselorAssessmentEnum sensationSeeking = (CounselorAssessmentEnum) comboSensationSeeking.getSelectedItem();
        CounselorAssessmentEnum socialSupport = (CounselorAssessmentEnum) comboSocialSupport.getSelectedItem();
        CounselorAssessmentEnum socialize = (CounselorAssessmentEnum) comboSocialize.getSelectedItem();
        CounselorAssessmentEnum traitAnxiety = (CounselorAssessmentEnum) comboTraitAnxiety.getSelectedItem();

        ViolenceEnum violenceField = (ViolenceEnum) comboViolence.getSelectedItem();

        CounselorAssessment counselorAssessment = new CounselorAssessment();
        assessment.setCounselorAssessment(counselorAssessment);

        counselorAssessment.setAntisocialPersonalityTraits(antisocial);
        counselorAssessment.setDrinkingToConform(conform);
        counselorAssessment.setDrinkingToCope(drinkCope);
        counselorAssessment.setDrinkingToEnhance(enhance);
        counselorAssessment.setDrinkingToSocialize(socialize);
        counselorAssessment.setFamilySocialSupport(familySupport);
        counselorAssessment.setFriendSocialSupport(socialSupport);
        counselorAssessment.setNegativeLifeEventsinLastYear(negativeLifeEvent);
        counselorAssessment.setSensationSeeking(sensationSeeking);
        counselorAssessment.setTraitAnxiety(traitAnxiety);
        counselorAssessment.setViolenceEnum(violenceField);

        patientEvaluationWorkRequest.setPatientRequestStatus(PatientRequestStatus.Completed);

        JOptionPane.showMessageDialog(null, "Assessment Successfully Submitted!!", "Information", JOptionPane.INFORMATION_MESSAGE);

        btnSubmit.setEnabled(false);

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CounselorWorkAreaJPanel counselorWorkAreaJPanel = (CounselorWorkAreaJPanel) component;
        counselorWorkAreaJPanel.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);


    }//GEN-LAST:event_btnBackActionPerformed

    private void comboSensationSeekingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSensationSeekingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSensationSeekingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox comboAntisocial;
    private javax.swing.JComboBox comboConform;
    private javax.swing.JComboBox comboDrinkCope;
    private javax.swing.JComboBox comboEnhance;
    private javax.swing.JComboBox comboFamilySupport;
    private javax.swing.JComboBox comboNegativeLifeEvent;
    private javax.swing.JComboBox comboSensationSeeking;
    private javax.swing.JComboBox comboSocialSupport;
    private javax.swing.JComboBox comboSocialize;
    private javax.swing.JComboBox comboTraitAnxiety;
    private javax.swing.JComboBox comboViolence;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblNegative;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblZone;
    // End of variables declaration//GEN-END:variables
}
