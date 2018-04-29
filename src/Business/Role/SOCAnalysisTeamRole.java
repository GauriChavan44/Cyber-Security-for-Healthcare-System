/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SecurityOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.SOCAnalysisTeam.SOCAnalysisTeamWorkAreaJPanel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class SOCAnalysisTeamRole extends Role{

     private RoleType roleType=RoleType.SOCAnalysisTeam;
    private static final Logger logger =Logger.getLogger(SOCAnalysisTeamRole.class);
     
    @Override
    public void setRoleType(RoleType roleType) {
        this.roleType=roleType;
    }

    @Override
    public RoleType getRoleType() {
        return roleType;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        logger.info("SOS Analyst Logged In !!");
        logger.info("In SOC Analysis Work Area ! UserName : "+account.getUserName());
        return new SOCAnalysisTeamWorkAreaJPanel(userProcessContainer,account, (SecurityOrganization) organization,enterprise);
    }
    
}
