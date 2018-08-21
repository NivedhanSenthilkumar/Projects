/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CounselorRole;
import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mehta
 */
public class CounselorOrganization extends Organization{

     public CounselorOrganization(String name) {

        super(name, Organization.Type.Counselor.getValue());
    }
    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList<>();
        roles.add(new CounselorRole());
        return roles;
    }
    
}
