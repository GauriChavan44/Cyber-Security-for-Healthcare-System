/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SOCAnalysisTeamRole;
import Business.Role.Tier1AnalystRole;
import Business.Role.Tier2AnalystRole;
import java.util.ArrayList;

/**
 *
 * @author Gauri
 */
public class SecurityOrganization extends Organization{

    public SecurityOrganization() {
        super(Type.Security.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Tier1AnalystRole());
        roles.add(new Tier2AnalystRole());
        roles.add(new SOCAnalysisTeamRole());
        return roles;
    }
    
}
