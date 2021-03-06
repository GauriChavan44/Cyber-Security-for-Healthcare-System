/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package UserInterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.SecurityOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.UnusualActivityWorkRequest;
import UserInterface.ReceptionistRole.ViewProfileJPanel;
import java.awt.CardLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class PatientWorkAreaJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private PatientOrganization patientOrganization;
    private Enterprise enterprise;
    private UserAccount patientAccount;
    private EcoSystem system;
    
    private static final Logger logger =Logger.getLogger(PatientWorkAreaJPanel.class);
    
    public PatientWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, PatientOrganization patientOrganization, Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.patientOrganization=patientOrganization;
        this.enterprise=enterprise;
        this.patientAccount=userAccount;
        this.system=system;
        
        userWithDifferentIPAddress(patientAccount.getPerson().getId());
        userWithDifferentCountry(patientAccount.getPerson().getId(),patientAccount.getPerson().getAddress().getCountry());
    }
    
    public void userWithDifferentIPAddress(int id){
        if(id==35){
            String ipAddress = patientAccount.getPerson().getIPAddress();
            
            
            InetAddress IP = null;
            try {
                IP = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                java.util.logging.Logger.getLogger(PatientWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            if(!ipAddress.equals(IP.getHostAddress())){
                
                UnusualActivityWorkRequest unusualActivityWorkRequest = new UnusualActivityWorkRequest();
                unusualActivityWorkRequest.setThreatUser(patientAccount);
                unusualActivityWorkRequest.setMessage("User Logged In from different IP Address");
                unusualActivityWorkRequest.setStatus("Sent");
                logger.info(patientAccount.getUserName()+" : User Logged In from different IP Address");
                
                for(Organization org :enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(org instanceof SecurityOrganization){
                        
                        org.getWorkQueue().getWorkRequestList().add(unusualActivityWorkRequest);
                    }
                }
            }
            
        }
    }
    
    public void userWithDifferentCountry(int id,String country){
        
        if(id==36){
            String patientCurrentCountry = "Iran";
            if(!country.equals(patientCurrentCountry)){
                UnusualActivityWorkRequest unusualActivityWorkRequest = new UnusualActivityWorkRequest();
                unusualActivityWorkRequest.setThreatUser(patientAccount);
                unusualActivityWorkRequest.setMessage("User Logged In from Country");
                unusualActivityWorkRequest.setStatus("Sent");
                logger.info(patientAccount.getUserName()+" : User Logged In from different Country");
                
                for(Organization org :enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(org instanceof SecurityOrganization){
                        org.getWorkQueue().getWorkRequestList().add(unusualActivityWorkRequest);
                    }
                }
            }
        }
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRequestDoctor = new javax.swing.JButton();
        btnViewVitalSign = new javax.swing.JButton();
        btnViewPatientProfile = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRequestDoctor.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnRequestDoctor.setText("Request Doctor");
        btnRequestDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestDoctorActionPerformed(evt);
            }
        });
        add(btnRequestDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, 48));

        btnViewVitalSign.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnViewVitalSign.setText("View Vital Sign");
        btnViewVitalSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVitalSignActionPerformed(evt);
            }
        });
        add(btnViewVitalSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 164, 48));

        btnViewPatientProfile.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnViewPatientProfile.setText("View Profile");
        btnViewPatientProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPatientProfileActionPerformed(evt);
            }
        });
        add(btnViewPatientProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 164, 48));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Patient Work Area");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/4.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestDoctorActionPerformed
        // TODO add your handling code here:
        RequestDoctorJPanel requestDoctor = new RequestDoctorJPanel(userProcessContainer,patientAccount,enterprise,system);
        userProcessContainer.add("requestDoctor",requestDoctor);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRequestDoctorActionPerformed

    private void btnViewVitalSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVitalSignActionPerformed
        // TODO add your handling code here:
        logger.info(patientAccount.getUserName()+" Viewed Vital Sign");
        ViewVitalSignJPanel viewVitalSignJPanel = new ViewVitalSignJPanel(userProcessContainer,patientAccount,enterprise);
        userProcessContainer.add("viewVitalSignJPanel",viewVitalSignJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewVitalSignActionPerformed

    private void btnViewPatientProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPatientProfileActionPerformed
        // TODO add your handling code here:
        logger.info(patientAccount.getUserName()+" Viewed Profile");
        ViewProfileJPanel viewPatientProfileJPanel = new ViewProfileJPanel(userProcessContainer,enterprise,patientAccount);
        userProcessContainer.add("viewPatientProfileJPanel",viewPatientProfileJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewPatientProfileActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRequestDoctor;
    private javax.swing.JButton btnViewPatientProfile;
    private javax.swing.JButton btnViewVitalSign;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
