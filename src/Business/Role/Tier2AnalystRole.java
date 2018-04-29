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
import UserInterface.Tier2Analyst.Tier2WorkAreaJPanel;
import UserInterface.Tier2Analyst.ViewWorkRequestsJPanel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class Tier2AnalystRole extends Role{

    private RoleType roleType=RoleType.Tier2Analyst;
    private static final Logger logger =Logger.getLogger(Tier2AnalystRole.class);
    
    @Override
    public RoleType getRoleType() {
        return roleType;
    }

    @Override
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business) {
        logger.info("Tier 2 Analyst Logged In !!");
        logger.info("In Tier 2 Analyst Work Area ! UserName : "+account.getUserName());
        return new Tier2WorkAreaJPanel(userProcessContainer, account, (SecurityOrganization) organization, enterprise);
    }
}
