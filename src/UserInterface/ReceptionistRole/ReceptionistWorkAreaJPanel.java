/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ReceptionistRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.ReceptionOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class ReceptionistWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private ReceptionOrganization receptionOrganization;
    private Enterprise enterprise;
    private EcoSystem system;
    
    private static final Logger logger =Logger.getLogger(ReceptionistWorkAreaJPanel.class);
    /**
     * Creates new form ReceptionistWorkAreaJPanel
     */
    public ReceptionistWorkAreaJPanel(JPanel userProcessContainer,UserAccount userAccount,ReceptionOrganization receptionOrganization,Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.receptionOrganization=receptionOrganization;
        this.enterprise=enterprise;
        this.system=system;
        
        Organization org=null;
        for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
            if(organization instanceof PatientOrganization){
                org=organization;
                break;
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

        btnAddPatient = new javax.swing.JButton();
        btnViewPatient = new javax.swing.JButton();
        btnViewProfile = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddPatient.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnAddPatient.setText("Add Patient");
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });
        add(btnAddPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 154, 51));

        btnViewPatient.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnViewPatient.setText("View Patient");
        btnViewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPatientActionPerformed(evt);
            }
        });
        add(btnViewPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 154, 51));

        btnViewProfile.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnViewProfile.setText("View Profile");
        btnViewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProfileActionPerformed(evt);
            }
        });
        add(btnViewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 154, 51));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Receptionist Work Area");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 32, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
        // TODO add your handling code here:
        AddPatientJPanel addPatientJPanel = new AddPatientJPanel(userProcessContainer,enterprise,system);
        userProcessContainer.add("addPatientJPanel",addPatientJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void btnViewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPatientActionPerformed
        // TODO add your handling code here:
        logger.info("Receptionist Viewed Patients");
        ViewPatientsJPanel viewPatientsJPanel = new ViewPatientsJPanel(userProcessContainer,enterprise);
        userProcessContainer.add("viewPatientsJPanel",viewPatientsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewPatientActionPerformed

    private void btnViewProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProfileActionPerformed
        // TODO add your handling code here:
        logger.info("Receptionist Viewed Profile");
        ViewProfileJPanel viewReceptionistProfileJPanel = new ViewProfileJPanel(userProcessContainer,enterprise,userAccount);
        userProcessContainer.add("viewReceptionistProfileJPanel",viewReceptionistProfileJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnViewPatient;
    private javax.swing.JButton btnViewProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
