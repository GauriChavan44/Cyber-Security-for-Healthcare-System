/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ReceptionOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.ReceptionistRole.ReceptionistWorkAreaJPanel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class ReceptionRole extends Role{

    private RoleType roleType=RoleType.Reception;
    private static final Logger logger =Logger.getLogger(ReceptionRole.class);
    
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
        logger.info("Receptionist Logged In !!");
        logger.info("In Reception Work Area ! UserName : "+account.getUserName());
        return new ReceptionistWorkAreaJPanel(userProcessContainer,account, (ReceptionOrganization) organization,enterprise, business);
    }

    
  
}
