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
import UserInterface.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class AdminRole extends Role{
private RoleType roleType=RoleType.Admin;
    
@Override
  public RoleType getRoleType() {
        return roleType;
    }

@Override
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    
    private static final Logger logger =Logger.getLogger(AdminRole.class);
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //System.out.println("In Adminn");
        logger.info("Admin Logged In !!");
        logger.info("In Admin Work Area ! UserName : "+account.getUserName());
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise,business);
    }
   
}
