/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.PatientRole.PatientWorkAreaJPanel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class PatientRole extends Role{

    private RoleType roleType=RoleType.Patient;
    private static final Logger logger =Logger.getLogger(PatientRole.class);
    
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
        logger.info("Patient Logged In !!");
        logger.info("In Patient Work Area ! UserName : "+account.getUserName());
        return new PatientWorkAreaJPanel(userProcessContainer,account, (PatientOrganization) organization,enterprise,business);
    }

    
   
}
