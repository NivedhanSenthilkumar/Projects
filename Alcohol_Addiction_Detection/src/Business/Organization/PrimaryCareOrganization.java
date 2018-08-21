/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.NurseRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anubhavgupta
 */
public class PrimaryCareOrganization extends Organization {

    public PrimaryCareOrganization(String name) {

        super(name, Organization.Type.PrimaryCare.getValue());
    }

    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList<>();
        roles.add(new NurseRole());
        roles.add(new DoctorRole());
        return roles;

    }

}
