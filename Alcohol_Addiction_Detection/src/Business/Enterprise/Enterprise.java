/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Dell
 */
public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public Enterprise(String name, EnterpriseType type) {
        super(name, null);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();

    }

    public enum EnterpriseType {
        Hospital("Hospital"),
        RehabCentre("Rehabilitation"),
        CDC("CDC");

        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {

        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public List<UserAccount> getAllUserAccounts() {

        List<UserAccount> allUserAccounts = this.getUserAccountDirectory().getUserAccountList().stream().collect(Collectors.toList());

        allUserAccounts.addAll(this.organizationDirectory.getOrganizationList().stream()
                .flatMap(o -> o.getUserAccountDirectory().getUserAccountList().stream())
                .collect(Collectors.toList()));

        return allUserAccounts;

    }

    public abstract List<Type> getSupportedOrganization();

}
