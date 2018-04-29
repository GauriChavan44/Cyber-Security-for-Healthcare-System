/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DoctorRole.DoctorWorkAreaJPanel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class DoctorRole extends Role{
   
    private RoleType roleType=RoleType.Doctor;
    private static final Logger logger =Logger.getLogger(DoctorRole.class);
    
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
        logger.info("Doctor Logged In !!");
        logger.info("In Doctor Work Area ! UserName : "+account.getUserName());
        return new DoctorWorkAreaJPanel(userProcessContainer, account, (DoctorOrganization)organization, enterprise,business);
    }

   

    
}
