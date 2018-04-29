/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInferface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class SystemAdminRole extends Role{
    
    private RoleType roleType=RoleType.Admin;
    private static final Logger logger =Logger.getLogger(SystemAdminRole.class);
    
    @Override
    public RoleType getRoleType() {
        return roleType;
    }

    @Override
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    

    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        logger.info("System Admin Logged In !!");
        logger.info("In System Admin Work Area ! UserName : "+account.getUserName());
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }

    
}
