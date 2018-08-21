/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Clinic;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.RehabCentreEnterprise;
import Business.Network.Network;
import Business.Organization.CounselorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Patient.Assessment;
import Business.Patient.Patient;
import Business.Patient.PatientRequestStatus;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabAssessment;
import Business.WorkQueue.PatientEvaluationWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class DoctorAssesmentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorAssesmentJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private PatientEvaluationWorkRequest patientEvaluationWorkRequest;
    private EcoSystem system;
    private Organization organization;
    private EnterpriseDirectory enterpriseDirectory;
    private Network network;
    
    public DoctorAssesmentJPanel(JPanel userProcessContainer, UserAccount userAccount, Network network, Enterprise enterprise, PatientEvaluationWorkRequest patientEvaluationWorkRequest) {
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.patientEvaluationWorkRequest = patientEvaluationWorkRequest;
        this.system = EcoSystem.getInstance();
        this.network = network;
        initComponents();
        setSize(1200, 1200);
        setFields();
        populateEnterpriseComboBox();
        printThemAll();
    }

    private void populateEnterpriseComboBox(){
        enterpriseComboBox.removeAllItems();
       
        for (Enterprise enter : network.getEnterpriseDirectory().getEnterpriseList()) 
        {
            if (enter instanceof RehabCentreEnterprise )
                enterpriseComboBox.addItem(enter);
        }   
        
    }
    private void setFields() {
        patientName.setText(patientEvaluationWorkRequest.getPatient().getPatientname());

        Assessment assessment = patientEvaluationWorkRequest.getAssessment();

        lblScore.setText(String.valueOf(assessment.getScore()));
        lblZone.setText(assessment.getZone().getValue());

        if (null != assessment.getLabAssessment()) {
            LabAssessment labAssessment = assessment.getLabAssessment();

            lblGGT.setText(labAssessment.getGGT().getValue());
            lblAST.setText(labAssessment.getAST().getValue());
            lblCDT.setText(labAssessment.getCDT().getValue());
            lblMCV.setText(labAssessment.getMCV().getValue());

        } else {

            String na = "NA";
            lblGGT.setText(na);
            lblAST.setText(na);
            lblCDT.setText(na);
            lblMCV.setText(na);

        }

    }

    private void printThemAll() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            String filename = "Business/assesment.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return;
            }

            prop.load(input);

            label1.setText(prop.getProperty("label1"));
            label2.setText(prop.getProperty("label2"));
            label3.setText(prop.getProperty("label3"));
            label4.setText(prop.getProperty("label4"));
            label5.setText(prop.getProperty("label5"));
            label6.setText(prop.getProperty("label6"));
            label7.setText(prop.getProperty("label7"));
            label8.setText(prop.getProperty("label8"));
            label9.setText(prop.getProperty("label9"));
            label10.setText(prop.getProperty("label10"));
            label11.setText(prop.getProperty("label11"));
            label12.setText(prop.getProperty("label12"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        AssesmentReportsjPanel = new javax.swing.JPanel();
        lblAST = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        RehabButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblZone = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblGGT = new javax.swing.JLabel();
        btnDischarged = new javax.swing.JButton();
        lblMCV = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblCDT = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        patientName = new javax.swing.JLabel();
        enterpriseComboBox = new javax.swing.JComboBox();
        Zone1AssesmentjPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        Zone2AssesmentjPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();

        jLabel4.setText(" How often during the last year have you had a feeling of guilt or remorse after drinking?");

        lblAST.setText("<value>");

        jLabel9.setText("Mean Corpuscular Volume :");

        RehabButton.setText("Recommend Rehabilitation");
        RehabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RehabButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Evalutaion Score:");

        lblZone.setText("<value>");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Assesement Reports");

        jLabel7.setText("Patient:");

        lblGGT.setText("<value>");

        btnDischarged.setText("No treatment Required");
        btnDischarged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDischargedActionPerformed(evt);
            }
        });

        lblMCV.setText("<vaue>");

        jLabel5.setText("Gamma-Glutamyl Transferase:");

        lblScore.setText("<value>");

        lblCDT.setText("<value>");

        jLabel8.setText("Laboratory Test:");

        jLabel6.setText("Aspartate Amino Transferase:");

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Zone :");

        jLabel14.setText("Carbohydrate Deficient Transferrin");

        patientName.setText("<value>");

        enterpriseComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout AssesmentReportsjPanelLayout = new javax.swing.GroupLayout(AssesmentReportsjPanel);
        AssesmentReportsjPanel.setLayout(AssesmentReportsjPanelLayout);
        AssesmentReportsjPanelLayout.setHorizontalGroup(
            AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssesmentReportsjPanelLayout.createSequentialGroup()
                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AssesmentReportsjPanelLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(AssesmentReportsjPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(patientName))
                            .addGroup(AssesmentReportsjPanelLayout.createSequentialGroup()
                                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblZone)
                                    .addComponent(lblScore)
                                    .addComponent(lblAST)
                                    .addComponent(lblMCV)
                                    .addComponent(lblCDT)
                                    .addComponent(lblGGT)))
                            .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(RehabButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDischarged, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))))
                    .addGroup(AssesmentReportsjPanelLayout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel1)))
                .addGap(249, 249, 249))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AssesmentReportsjPanelLayout.createSequentialGroup()
                .addComponent(enterpriseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );
        AssesmentReportsjPanelLayout.setVerticalGroup(
            AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssesmentReportsjPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(patientName))
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblGGT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblMCV))
                .addGap(18, 18, 18)
                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblAST))
                .addGap(18, 18, 18)
                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblCDT))
                .addGap(16, 16, 16)
                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblScore))
                .addGap(18, 18, 18)
                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblZone))
                .addGap(22, 22, 22)
                .addGroup(AssesmentReportsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RehabButton)
                    .addComponent(enterpriseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDischarged)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Assesment Reports", AssesmentReportsjPanel);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Zone 1 Instructions");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        label1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label1.setText("jLabel11");

        label2.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        label2.setText("jLabel11");

        label3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label3.setText("jLabel11");

        label4.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        label4.setText("jLabel11");

        label5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label5.setText("jLabel11");

        label6.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        label6.setText("jLabel11");

        javax.swing.GroupLayout Zone1AssesmentjPanelLayout = new javax.swing.GroupLayout(Zone1AssesmentjPanel);
        Zone1AssesmentjPanel.setLayout(Zone1AssesmentjPanelLayout);
        Zone1AssesmentjPanelLayout.setHorizontalGroup(
            Zone1AssesmentjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Zone1AssesmentjPanelLayout.createSequentialGroup()
                .addGroup(Zone1AssesmentjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Zone1AssesmentjPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(Zone1AssesmentjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(Zone1AssesmentjPanelLayout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(375, 375, 375))
        );
        Zone1AssesmentjPanelLayout.setVerticalGroup(
            Zone1AssesmentjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Zone1AssesmentjPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(label1)
                .addGap(18, 18, 18)
                .addComponent(label2)
                .addGap(18, 18, 18)
                .addComponent(label3)
                .addGap(18, 18, 18)
                .addComponent(label4)
                .addGap(18, 18, 18)
                .addComponent(label5)
                .addGap(18, 18, 18)
                .addComponent(label6)
                .addGap(361, 361, 361))
        );

        jTabbedPane1.addTab("Zone1 Instructions", Zone1AssesmentjPanel);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Zone 2 Instructions");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        label9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label9.setText("jLabel11");

        label10.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        label10.setText("jLabel11");

        label11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label11.setText("jLabel11");

        label12.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        label12.setText("jLabel11");

        label7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label7.setText("jLabel11");

        label8.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        label8.setText("jLabel11");

        javax.swing.GroupLayout Zone2AssesmentjPanelLayout = new javax.swing.GroupLayout(Zone2AssesmentjPanel);
        Zone2AssesmentjPanel.setLayout(Zone2AssesmentjPanelLayout);
        Zone2AssesmentjPanelLayout.setHorizontalGroup(
            Zone2AssesmentjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Zone2AssesmentjPanelLayout.createSequentialGroup()
                .addGroup(Zone2AssesmentjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Zone2AssesmentjPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(Zone2AssesmentjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label12)
                            .addComponent(label11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label10)
                            .addComponent(label8)
                            .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label9)))
                    .addGroup(Zone2AssesmentjPanelLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(375, 375, 375))
        );
        Zone2AssesmentjPanelLayout.setVerticalGroup(
            Zone2AssesmentjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Zone2AssesmentjPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(label8)
                .addGap(18, 18, 18)
                .addComponent(label9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(label10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(label11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(label12)
                .addGap(396, 396, 396))
        );

        jTabbedPane1.addTab("Zone 2 Instructions", Zone2AssesmentjPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 965, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RehabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RehabButtonActionPerformed
        // TODO add your handling code here:
        patientEvaluationWorkRequest.setPatientRequestStatus(PatientRequestStatus.Recommended_Rehab);

        RehabCentreEnterprise rehabEnterprise = (RehabCentreEnterprise)enterpriseComboBox.getSelectedItem();

        rehabEnterprise.getOrganizationDirectory().getOrganizationList().stream()
                .filter(org -> org instanceof CounselorOrganization)
                .findAny()
                .get()
                .getWorkQueue()
                .getWorkRequestList()
                .add(patientEvaluationWorkRequest);
        
        RehabButton.setEnabled(false);
        btnDischarged.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Recommendation Send to Rehabilitation Center!!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_RehabButtonActionPerformed

    private void btnDischargedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDischargedActionPerformed
        // TODO add your handling code here:
        patientEvaluationWorkRequest.setPatientRequestStatus(PatientRequestStatus.Discharged);
        RehabButton.setEnabled(false);
        btnDischarged.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Patient Discharged!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDischargedActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorWorkAreaJPanel dwjp = (DoctorWorkAreaJPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JPanel AssesmentReportsjPanel;
    javax.swing.JButton RehabButton;
    javax.swing.JPanel Zone1AssesmentjPanel;
    javax.swing.JPanel Zone2AssesmentjPanel;
    javax.swing.JButton backButton;
    javax.swing.JButton btnDischarged;
    javax.swing.JComboBox enterpriseComboBox;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel14;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JTabbedPane jTabbedPane1;
    javax.swing.JLabel label1;
    javax.swing.JLabel label10;
    javax.swing.JLabel label11;
    javax.swing.JLabel label12;
    javax.swing.JLabel label2;
    javax.swing.JLabel label3;
    javax.swing.JLabel label4;
    javax.swing.JLabel label5;
    javax.swing.JLabel label6;
    javax.swing.JLabel label7;
    javax.swing.JLabel label8;
    javax.swing.JLabel label9;
    javax.swing.JLabel lblAST;
    javax.swing.JLabel lblCDT;
    javax.swing.JLabel lblGGT;
    javax.swing.JLabel lblMCV;
    javax.swing.JLabel lblScore;
    javax.swing.JLabel lblZone;
    javax.swing.JLabel patientName;
    // End of variables declaration//GEN-END:variables
}
