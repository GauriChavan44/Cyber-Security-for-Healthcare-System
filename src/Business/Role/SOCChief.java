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
import UserInterface.SOCChiefRole.SOCChiefWorkAreaJPanel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class SOCChief extends Role{

    private RoleType roleType=RoleType.SOCChief;
    private static final Logger logger =Logger.getLogger(SOCChief.class);
    
    @Override
    public RoleType getRoleType() {
        return roleType;
    }

    @Override
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        logger.info("SOC Chief Logged In !!");
        logger.info("In SOC Chief Work Area ! UserName : "+account.getUserName());
        return new SOCChiefWorkAreaJPanel(userProcessContainer,account, (SecurityOrganization) organization,enterprise);
    }

    
}
