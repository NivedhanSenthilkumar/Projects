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
public class CDCEnterprise extends Enterprise {
    
        public CDCEnterprise(String name) {
        super(name, EnterpriseType.CDC);

    }

    @Override
    public List<Type> getSupportedOrganization() {
        List<Organization.Type> supportedOrganization = new ArrayList<>();
        supportedOrganization.add(Organization.Type.HealthInspector);
        return supportedOrganization;
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }
    
}
