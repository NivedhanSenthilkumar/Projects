/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PrimaryCareOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.Clinic.DoctorWorkAreaJPanel;

import javax.swing.JPanel;

/**
 *
 * @author anubhavgupta
 */
public class DoctorRole extends Role {

    private static final String ROLE_NAME = "Doctor Role";

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,Network network, Organization organization, Enterprise enterprise, EcoSystem business) {

        return new DoctorWorkAreaJPanel(userProcessContainer, account, network,(PrimaryCareOrganization) organization, enterprise);

    }

    @Override
    public String toString() {
        return ROLE_NAME;
    }
}
