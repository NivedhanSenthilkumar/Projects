/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class RehabCentreEnterprise extends Enterprise {

    public RehabCentreEnterprise(String name) {
        super(name, EnterpriseType.RehabCentre);

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    @Override
    public List<Type> getSupportedOrganization() {

        List<Organization.Type> supportedOrganization = new ArrayList<>();
        supportedOrganization.add(Organization.Type.Counselor);
        return supportedOrganization;

    }

}
