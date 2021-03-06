/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.LabRole.LabWorkAreaJPanel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class LabRole extends Role{

    private RoleType roleType=RoleType.Lab;
    private static final Logger logger =Logger.getLogger(LabRole.class);
    
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
        logger.info("Lab Employee Logged In !!");
        logger.info("In Lab Work Area ! UserName : "+account.getUserName());
        return new LabWorkAreaJPanel(userProcessContainer,account, (LabOrganization) organization,enterprise,business);
    }

    
 
}
