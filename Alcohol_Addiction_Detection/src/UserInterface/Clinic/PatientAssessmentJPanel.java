/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Clinic;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Patient.Assessment;
import Business.Patient.Patient;
import Business.Patient.PatientRequestStatus;
import Business.Patient.PointsEnum;
import Business.Patient.ZonesEnum;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PatientEvaluationWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Dell
 */
public class PatientAssessmentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Organization organization;
    private UserAccount userAccount;
    private Patient patient;

    public PatientAssessmentJPanel(JPanel userProcessContainer, Enterprise enterprise, Organization organization, UserAccount userAccount, Patient patient) {

        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.patient = patient;
        groupButton();
        setNameRadButtons();
        setSize(1200, 1200);

    }

    private void groupButton() {

        ButtonGroup bg1 = new ButtonGroup();
        ButtonGroup bg2 = new ButtonGroup();
        ButtonGroup bg3 = new ButtonGroup();
        ButtonGroup bg4 = new ButtonGroup();
        ButtonGroup bg5 = new ButtonGroup();
        ButtonGroup bg6 = new ButtonGroup();
        ButtonGroup bg7 = new ButtonGroup();
        ButtonGroup bg8 = new ButtonGroup();
        ButtonGroup bg9 = new ButtonGroup();
        ButtonGroup bg10 = new ButtonGroup();

        bg1.add(rad1_1);
        bg1.add(rad1_2);
        bg1.add(rad1_3);
        bg1.add(rad1_4);
        bg1.add(rad1_5);

        bg2.add(rad2_1);
        bg2.add(rad2_2);
        bg2.add(rad2_3);
        bg2.add(rad2_4);
        bg2.add(rad2_5);

        bg3.add(rad3_1);
        bg3.add(rad3_2);
        bg3.add(rad3_3);
        bg3.add(rad3_4);
        bg3.add(rad3_5);

        bg4.add(rad4_1);
        bg4.add(rad4_2);
        bg4.add(rad4_3);
        bg4.add(rad4_4);
        bg4.add(rad4_5);

        bg5.add(rad5_1);
        bg5.add(rad5_2);
        bg5.add(rad5_3);
        bg5.add(rad5_4);
        bg5.add(rad5_5);

        bg6.add(rad6_1);
        bg6.add(rad6_2);
        bg6.add(rad6_3);
        bg6.add(rad6_4);
        bg6.add(rad6_5);

        bg7.add(rad7_1);
        bg7.add(rad7_2);
        bg7.add(rad7_3);
        bg7.add(rad7_4);
        bg7.add(rad7_5);

        bg8.add(rad8_1);
        bg8.add(rad8_2);
        bg8.add(rad8_3);
        bg8.add(rad8_4);
        bg8.add(rad8_5);

        bg9.add(rad9_1);
        bg9.add(rad9_2);
        bg9.add(rad9_3);

        bg10.add(rad10_1);
        bg10.add(rad10_2);
        bg10.add(rad10_3);

    }

    private void setNameRadButtons() {

        rad1_1.setName("rad1_1");
        rad1_2.setName("rad1_2");
        rad1_3.setName("rad1_3");
        rad1_4.setName("rad1_4");
        rad1_5.setName("rad1_5");

        rad2_1.setName("rad2_1");
        rad2_2.setName("rad2_2");
        rad2_3.setName("rad2_3");
        rad2_4.setName("rad2_4");
        rad2_5.setName("rad2_5");

        rad3_1.setName("rad3_1");
        rad3_2.setName("rad3_2");
        rad3_3.setName("rad3_3");
        rad3_4.setName("rad3_4");
        rad3_5.setName("rad3_5");

        rad4_1.setName("rad4_1");
        rad4_2.setName("rad4_2");
        rad4_3.setName("rad4_3");
        rad4_4.setName("rad4_4");
        rad4_5.setName("rad4_5");

        rad5_1.setName("rad5_1");
        rad5_2.setName("rad5_2");
        rad5_3.setName("rad5_3");
        rad5_4.setName("rad5_4");
        rad5_5.setName("rad5_5");

        rad6_1.setName("rad6_1");
        rad6_2.setName("rad6_2");
        rad6_3.setName("rad6_3");
        rad6_4.setName("rad6_4");
        rad6_5.setName("rad6_5");

        rad7_1.setName("rad7_1");
        rad7_2.setName("rad7_2");
        rad7_3.setName("rad7_3");
        rad7_4.setName("rad7_4");
        rad7_5.setName("rad7_5");

        rad8_1.setName("rad8_1");
        rad8_2.setName("rad8_2");
        rad8_3.setName("rad8_3");
        rad8_4.setName("rad8_4");
        rad8_5.setName("rad8_5");

        rad9_1.setName("rad9_1");
        rad9_2.setName("rad9_2");
        rad9_3.setName("rad9_3");

        rad10_1.setName("rad10_1");
        rad10_2.setName("rad10_2");
        rad10_3.setName("rad10_3");

    }

    private List<String> getAnswerCodeAndString(JRadioButton rad) {

        List<String> answerCodeString = new ArrayList<>();

        answerCodeString.add(rad.getName().replace("rad", ""));
        answerCodeString.add(rad.getText());

        return answerCodeString;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        rad4_1 = new javax.swing.JRadioButton();
        rad5_4 = new javax.swing.JRadioButton();
        rad5_3 = new javax.swing.JRadioButton();
        rad5_2 = new javax.swing.JRadioButton();
        rad5_5 = new javax.swing.JRadioButton();
        rad5_1 = new javax.swing.JRadioButton();
        rad6_4 = new javax.swing.JRadioButton();
        rad6_3 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rad6_2 = new javax.swing.JRadioButton();
        rad6_5 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        rad6_1 = new javax.swing.JRadioButton();
        rad7_4 = new javax.swing.JRadioButton();
        rad7_3 = new javax.swing.JRadioButton();
        rad7_2 = new javax.swing.JRadioButton();
        rad1_1 = new javax.swing.JRadioButton();
        rad1_4 = new javax.swing.JRadioButton();
        rad1_5 = new javax.swing.JRadioButton();
        rad1_2 = new javax.swing.JRadioButton();
        rad1_3 = new javax.swing.JRadioButton();
        rad2_2 = new javax.swing.JRadioButton();
        rad2_3 = new javax.swing.JRadioButton();
        rad7_5 = new javax.swing.JRadioButton();
        rad2_4 = new javax.swing.JRadioButton();
        rad7_1 = new javax.swing.JRadioButton();
        rad2_5 = new javax.swing.JRadioButton();
        rad2_1 = new javax.swing.JRadioButton();
        rad3_4 = new javax.swing.JRadioButton();
        rad3_3 = new javax.swing.JRadioButton();
        rad3_2 = new javax.swing.JRadioButton();
        rad3_5 = new javax.swing.JRadioButton();
        rad3_1 = new javax.swing.JRadioButton();
        rad4_4 = new javax.swing.JRadioButton();
        rad4_3 = new javax.swing.JRadioButton();
        rad4_2 = new javax.swing.JRadioButton();
        rad4_5 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        rad10_1 = new javax.swing.JRadioButton();
        rad10_2 = new javax.swing.JRadioButton();
        rad10_3 = new javax.swing.JRadioButton();
        rad8_4 = new javax.swing.JRadioButton();
        rad8_3 = new javax.swing.JRadioButton();
        rad8_2 = new javax.swing.JRadioButton();
        rad8_5 = new javax.swing.JRadioButton();
        rad8_1 = new javax.swing.JRadioButton();
        rad9_1 = new javax.swing.JRadioButton();
        rad9_2 = new javax.swing.JRadioButton();
        rad9_3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        rad4_1.setText("Never");
        rad4_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad4_1ActionPerformed(evt);
            }
        });

        rad5_4.setText("Weekly");
        rad5_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad5_4ActionPerformed(evt);
            }
        });

        rad5_3.setText("Less than monthly");
        rad5_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad5_3ActionPerformed(evt);
            }
        });

        rad5_2.setText("Monthly");
        rad5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad5_2ActionPerformed(evt);
            }
        });

        rad5_5.setText("Daily or almost daily");

        rad5_1.setText("Never");
        rad5_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad5_1ActionPerformed(evt);
            }
        });

        rad6_4.setText("Weekly");
        rad6_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad6_4ActionPerformed(evt);
            }
        });

        rad6_3.setText("Less than monthly");
        rad6_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad6_3ActionPerformed(evt);
            }
        });

        jLabel7.setText(" 1. How often do you have a drink containing alcohol ?");

        jLabel8.setText(" 2. How many drinks containing alcohol do you have on a typical day when you are drinking?");

        jLabel9.setText(" 3. How often do you have 6* or more drinks on one occassion ?");

        rad6_2.setText("Monthly");
        rad6_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad6_2ActionPerformed(evt);
            }
        });

        rad6_5.setText("Daily or almost daily");

        jLabel10.setText(" 4. How often during the last year have you found that  you were not able to stop drinking once you had started?");

        rad6_1.setText("Never");
        rad6_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad6_1ActionPerformed(evt);
            }
        });

        rad7_4.setText("Weekly");
        rad7_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad7_4ActionPerformed(evt);
            }
        });

        rad7_3.setText("Less than monthly");
        rad7_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad7_3ActionPerformed(evt);
            }
        });

        rad7_2.setText("Monthly");
        rad7_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad7_2ActionPerformed(evt);
            }
        });

        rad1_1.setText("Never");
        rad1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad1_1ActionPerformed(evt);
            }
        });

        rad1_4.setText("2-3 times a week");

        rad1_5.setText("4 or more times a week");

        rad1_2.setText("Monthly");

        rad1_3.setText("2-4 times a month");

        rad2_2.setText("3 or 4");
        rad2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad2_2ActionPerformed(evt);
            }
        });

        rad2_3.setText("5 or 6");

        rad7_5.setText("Daily or almost daily");

        rad2_4.setText("7 or 9");
        rad2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad2_4ActionPerformed(evt);
            }
        });

        rad7_1.setText("Never");
        rad7_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad7_1ActionPerformed(evt);
            }
        });

        rad2_5.setText("10 or more");

        rad2_1.setText("1 or 2");
        rad2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad2_1ActionPerformed(evt);
            }
        });

        rad3_4.setText("Weekly");
        rad3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad3_4ActionPerformed(evt);
            }
        });

        rad3_3.setText("Less than monthly");
        rad3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad3_3ActionPerformed(evt);
            }
        });

        rad3_2.setText("Monthly");
        rad3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad3_2ActionPerformed(evt);
            }
        });

        rad3_5.setText("Daily or almost daily");

        rad3_1.setText("Never");
        rad3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad3_1ActionPerformed(evt);
            }
        });

        rad4_4.setText("Weekly");
        rad4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad4_4ActionPerformed(evt);
            }
        });

        rad4_3.setText("Less than monthly");
        rad4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad4_3ActionPerformed(evt);
            }
        });

        rad4_2.setText("Monthly");
        rad4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad4_2ActionPerformed(evt);
            }
        });

        rad4_5.setText("Daily or almost daily");

        jLabel11.setText(" 9. Have you or someone else been injured as a result of your drinking?");

        rad10_1.setText("No");

        rad10_2.setText("Yes, but not in the past year");

        rad10_3.setText("Yes, during the past year");
        rad10_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad10_3ActionPerformed(evt);
            }
        });

        rad8_4.setText("Weekly");
        rad8_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad8_4ActionPerformed(evt);
            }
        });

        rad8_3.setText("Less than monthly");
        rad8_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad8_3ActionPerformed(evt);
            }
        });

        rad8_2.setText("Monthly");
        rad8_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad8_2ActionPerformed(evt);
            }
        });

        rad8_5.setText("Daily or almost daily");

        rad8_1.setText("Never");
        rad8_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad8_1ActionPerformed(evt);
            }
        });

        rad9_1.setText("No");

        rad9_2.setText("Yes, but not in the past year");

        rad9_3.setText("Yes, during the past year");
        rad9_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad9_3ActionPerformed(evt);
            }
        });

        jLabel1.setText(" 5. How often during the last year have you failed to do what was normally expected from you because of drinking ?");

        jLabel2.setText(" 6. How often during the past year have needed a first drink in the morning to get yourself going after a heavy night of drinking ?");

        jLabel3.setText(" 7. How often during the last year have you felt guilt or remorse after drinking ?");

        jLabel4.setText(" 8. How often during the past year have you been unable to remember what happened the night before because you were drinking ?");

        jLabel5.setText(" 10. Has a relative or a  friend or a doctor or  health worker been concerned about your drinking or suggeseted you cut down ?");

        backButton.setText("< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad7_1)
                        .addGap(30, 30, 30)
                        .addComponent(rad7_2)
                        .addGap(18, 18, 18)
                        .addComponent(rad7_3)
                        .addGap(30, 30, 30)
                        .addComponent(rad7_4)
                        .addGap(18, 18, 18)
                        .addComponent(rad7_5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad6_1)
                        .addGap(30, 30, 30)
                        .addComponent(rad6_2)
                        .addGap(18, 18, 18)
                        .addComponent(rad6_3)
                        .addGap(30, 30, 30)
                        .addComponent(rad6_4)
                        .addGap(18, 18, 18)
                        .addComponent(rad6_5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad5_1)
                        .addGap(30, 30, 30)
                        .addComponent(rad5_2)
                        .addGap(18, 18, 18)
                        .addComponent(rad5_3)
                        .addGap(30, 30, 30)
                        .addComponent(rad5_4)
                        .addGap(18, 18, 18)
                        .addComponent(rad5_5))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad1_1)
                        .addGap(34, 34, 34)
                        .addComponent(rad1_2)
                        .addGap(39, 39, 39)
                        .addComponent(rad1_3)
                        .addGap(37, 37, 37)
                        .addComponent(rad1_4)
                        .addGap(18, 18, 18)
                        .addComponent(rad1_5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad2_1)
                        .addGap(32, 32, 32)
                        .addComponent(rad2_2)
                        .addGap(29, 29, 29)
                        .addComponent(rad2_3)
                        .addGap(45, 45, 45)
                        .addComponent(rad2_4)
                        .addGap(31, 31, 31)
                        .addComponent(rad2_5))
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad3_1)
                        .addGap(30, 30, 30)
                        .addComponent(rad3_2)
                        .addGap(18, 18, 18)
                        .addComponent(rad3_3)
                        .addGap(30, 30, 30)
                        .addComponent(rad3_4)
                        .addGap(18, 18, 18)
                        .addComponent(rad3_5))
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad4_1)
                        .addGap(30, 30, 30)
                        .addComponent(rad4_2)
                        .addGap(18, 18, 18)
                        .addComponent(rad4_3)
                        .addGap(30, 30, 30)
                        .addComponent(rad4_4)
                        .addGap(18, 18, 18)
                        .addComponent(rad4_5))
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad9_1)
                        .addGap(51, 51, 51)
                        .addComponent(rad9_2)
                        .addGap(65, 65, 65)
                        .addComponent(rad9_3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(324, 324, 324)
                        .addComponent(submitButton)
                        .addGap(334, 334, 334)
                        .addComponent(cancelButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad8_1)
                        .addGap(30, 30, 30)
                        .addComponent(rad8_2)
                        .addGap(18, 18, 18)
                        .addComponent(rad8_3)
                        .addGap(30, 30, 30)
                        .addComponent(rad8_4)
                        .addGap(18, 18, 18)
                        .addComponent(rad8_5))
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad10_1)
                        .addGap(51, 51, 51)
                        .addComponent(rad10_2)
                        .addGap(65, 65, 65)
                        .addComponent(rad10_3)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad1_5)
                    .addComponent(rad1_4)
                    .addComponent(rad1_1)
                    .addComponent(rad1_3)
                    .addComponent(rad1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad2_1)
                    .addComponent(rad2_2)
                    .addComponent(rad2_3)
                    .addComponent(rad2_4)
                    .addComponent(rad2_5))
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad3_1)
                    .addComponent(rad3_4)
                    .addComponent(rad3_3)
                    .addComponent(rad3_2)
                    .addComponent(rad3_5))
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad4_1)
                    .addComponent(rad4_3)
                    .addComponent(rad4_2)
                    .addComponent(rad4_5)
                    .addComponent(rad4_4))
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad5_2)
                    .addComponent(rad5_4)
                    .addComponent(rad5_1)
                    .addComponent(rad5_3)
                    .addComponent(rad5_5))
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad6_2)
                    .addComponent(rad6_4)
                    .addComponent(rad6_3)
                    .addComponent(rad6_5)
                    .addComponent(rad6_1))
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad7_4)
                    .addComponent(rad7_2)
                    .addComponent(rad7_5)
                    .addComponent(rad7_3)
                    .addComponent(rad7_1))
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad8_1)
                    .addComponent(rad8_3)
                    .addComponent(rad8_2)
                    .addComponent(rad8_5)
                    .addComponent(rad8_4))
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad9_1)
                    .addComponent(rad9_2)
                    .addComponent(rad9_3))
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad10_1)
                    .addComponent(rad10_2)
                    .addComponent(rad10_3))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(submitButton)
                    .addComponent(cancelButton))
                .addGap(30, 30, 30))
        );

        jScrollPane1.setViewportView(jPanel1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Disorder Identification Panel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(jLabel6)
                .addGap(356, 356, 356))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rad4_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad4_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad4_1ActionPerformed

    private void rad5_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad5_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad5_4ActionPerformed

    private void rad5_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad5_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad5_3ActionPerformed

    private void rad5_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad5_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad5_2ActionPerformed

    private void rad5_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad5_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad5_1ActionPerformed

    private void rad6_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad6_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad6_4ActionPerformed

    private void rad6_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad6_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad6_3ActionPerformed

    private void rad6_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad6_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad6_2ActionPerformed

    private void rad6_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad6_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad6_1ActionPerformed

    private void rad7_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad7_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad7_4ActionPerformed

    private void rad7_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad7_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad7_3ActionPerformed

    private void rad7_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad7_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad7_2ActionPerformed

    private void rad1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad1_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad1_1ActionPerformed

    private void rad2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad2_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad2_2ActionPerformed

    private void rad2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad2_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad2_4ActionPerformed

    private void rad7_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad7_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad7_1ActionPerformed

    private void rad2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad2_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad2_1ActionPerformed

    private void rad3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad3_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad3_4ActionPerformed

    private void rad3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad3_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad3_3ActionPerformed

    private void rad3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad3_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad3_2ActionPerformed

    private void rad3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad3_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad3_1ActionPerformed

    private void rad4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad4_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad4_4ActionPerformed

    private void rad4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad4_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad4_3ActionPerformed

    private void rad4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad4_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad4_2ActionPerformed

    private void rad10_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad10_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad10_3ActionPerformed

    private void rad8_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad8_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad8_4ActionPerformed

    private void rad8_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad8_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad8_3ActionPerformed

    private void rad8_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad8_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad8_2ActionPerformed

    private void rad8_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad8_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad8_1ActionPerformed

    private void rad9_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad9_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad9_3ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:

        Component[] components = jPanel1.getComponents();
        List<Component> comList = Arrays.asList(components)
                .stream()
                .filter(com -> com instanceof JRadioButton)
                .collect(Collectors.toList());

        List<JRadioButton> jRadioButtons = new ArrayList<>();

        for (Component comp : comList) {
            jRadioButtons.add((JRadioButton) comp);

        }

        Long buttonSelectCount = jRadioButtons.stream()
                .filter(rad -> rad.isSelected())
                .count();

        if (buttonSelectCount < 10) {
           JOptionPane.showMessageDialog(null, "Please answer all the questions", "Warning", JOptionPane.INFORMATION_MESSAGE);
           return;
        }
        
        
        long score = jRadioButtons.stream()
                .filter(rad -> rad.isSelected())
                .mapToInt(rad -> PointsEnum.getPointsFromName(rad.getName()))
                .sum();
        Map<Integer, List<String>> questionAnswerMap = jRadioButtons.stream()
                .filter(rad -> rad.isSelected())
                .collect(Collectors.toMap(rad -> PointsEnum.getQuestionNumberFromName(rad.getName()), rad -> getAnswerCodeAndString(rad)));

        ZonesEnum zone;

        if (score >= 0 && score <= 7) {

            zone = ZonesEnum.ZONE1;

        } else if (score >= 8 && score <= 15) {

            zone = ZonesEnum.ZONE2;

        } else if (score >= 16 && score <= 19) {

            zone = ZonesEnum.ZONE3;

        } else {

            zone = ZonesEnum.ZONE4;

        }

        PatientEvaluationWorkRequest evaluationWorkRequest = new PatientEvaluationWorkRequest();
        Assessment assessment = new Assessment((int) score, userAccount, zone);
        assessment.setQuestionAnswer(questionAnswerMap);
        evaluationWorkRequest.setAssessment(assessment);
        patient.getAssessments().add(assessment);
        //evaluationWorkRequest.setDoctor(userAccount);
//        evaluationWorkRequest.setScore((int) score);
//        evaluationWorkRequest.setZone(zone);
//        evaluationWorkRequest.setNurse(userAccount);
        evaluationWorkRequest.setPatient(patient);
        evaluationWorkRequest.setPatientRequestStatus(PatientRequestStatus.Assessment);

        userAccount.getWorkQueue().getWorkRequestList().add(evaluationWorkRequest);
        organization.getWorkQueue().getWorkRequestList().add(evaluationWorkRequest);

        JOptionPane.showMessageDialog(null, " Successfully submitted for Assessment", "Information", JOptionPane.INFORMATION_MESSAGE);
        submitButton.setEnabled(false);
    }//GEN-LAST:event_submitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rad10_1;
    private javax.swing.JRadioButton rad10_2;
    private javax.swing.JRadioButton rad10_3;
    private javax.swing.JRadioButton rad1_1;
    private javax.swing.JRadioButton rad1_2;
    private javax.swing.JRadioButton rad1_3;
    private javax.swing.JRadioButton rad1_4;
    private javax.swing.JRadioButton rad1_5;
    private javax.swing.JRadioButton rad2_1;
    private javax.swing.JRadioButton rad2_2;
    private javax.swing.JRadioButton rad2_3;
    private javax.swing.JRadioButton rad2_4;
    private javax.swing.JRadioButton rad2_5;
    private javax.swing.JRadioButton rad3_1;
    private javax.swing.JRadioButton rad3_2;
    private javax.swing.JRadioButton rad3_3;
    private javax.swing.JRadioButton rad3_4;
    private javax.swing.JRadioButton rad3_5;
    private javax.swing.JRadioButton rad4_1;
    private javax.swing.JRadioButton rad4_2;
    private javax.swing.JRadioButton rad4_3;
    private javax.swing.JRadioButton rad4_4;
    private javax.swing.JRadioButton rad4_5;
    private javax.swing.JRadioButton rad5_1;
    private javax.swing.JRadioButton rad5_2;
    private javax.swing.JRadioButton rad5_3;
    private javax.swing.JRadioButton rad5_4;
    private javax.swing.JRadioButton rad5_5;
    private javax.swing.JRadioButton rad6_1;
    private javax.swing.JRadioButton rad6_2;
    private javax.swing.JRadioButton rad6_3;
    private javax.swing.JRadioButton rad6_4;
    private javax.swing.JRadioButton rad6_5;
    private javax.swing.JRadioButton rad7_1;
    private javax.swing.JRadioButton rad7_2;
    private javax.swing.JRadioButton rad7_3;
    private javax.swing.JRadioButton rad7_4;
    private javax.swing.JRadioButton rad7_5;
    private javax.swing.JRadioButton rad8_1;
    private javax.swing.JRadioButton rad8_2;
    private javax.swing.JRadioButton rad8_3;
    private javax.swing.JRadioButton rad8_4;
    private javax.swing.JRadioButton rad8_5;
    private javax.swing.JRadioButton rad9_1;
    private javax.swing.JRadioButton rad9_2;
    private javax.swing.JRadioButton rad9_3;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
