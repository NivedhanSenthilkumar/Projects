/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.HealthInspectorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CDC.HealthInspectorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class HealthInspectorRole extends Role {

    private static final String ROLE_NAME = "Health Inspector Role";

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new HealthInspectorWorkAreaJPanel(userProcessContainer, account, network, (HealthInspectorOrganization) organization, enterprise);

    }

    @Override
    public String toString() {
        return ROLE_NAME;
    }
}
