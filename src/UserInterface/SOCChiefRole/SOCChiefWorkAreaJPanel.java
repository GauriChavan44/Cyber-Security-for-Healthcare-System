/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SOCChiefRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SecurityOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class SOCChiefWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private SecurityOrganization securityOrganization;
    private Enterprise enterprise;
    
    private static final Logger logger =Logger.getLogger(SOCChiefWorkAreaJPanel.class);
    /**
     * Creates new form SOCChiefWorkAreaJPanel
     */
    public SOCChiefWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, SecurityOrganization securityOrganization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=account;
        this.securityOrganization=securityOrganization;
        this.enterprise=enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAddSecurityEmployees = new javax.swing.JButton();
        btnViewSecurityEmployees = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("SOC Chief Work Area");

        btnAddSecurityEmployees.setText("Add Security Employees");
        btnAddSecurityEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSecurityEmployeesActionPerformed(evt);
            }
        });

        btnViewSecurityEmployees.setText("View Security Employees");
        btnViewSecurityEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSecurityEmployeesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddSecurityEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewSecurityEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(btnAddSecurityEmployees)
                .addGap(18, 18, 18)
                .addComponent(btnViewSecurityEmployees)
                .addContainerGap(455, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSecurityEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSecurityEmployeesActionPerformed
        // TODO add your handling code here:
        ManageSecurityEmployeesJPanel manageSecurityEmployeesJPanel = new ManageSecurityEmployeesJPanel(userProcessContainer,securityOrganization);
        userProcessContainer.add("manageSecurityEmployeesJPanel",manageSecurityEmployeesJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddSecurityEmployeesActionPerformed

    private void btnViewSecurityEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSecurityEmployeesActionPerformed
        // TODO add your handling code here:
        ViewSecurityEmployeesJPanel viewSecurityEmployeesJPanel = new ViewSecurityEmployeesJPanel(userProcessContainer,securityOrganization);
        userProcessContainer.add("viewSecurityEmployeesJPanel",viewSecurityEmployeesJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewSecurityEmployeesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSecurityEmployees;
    private javax.swing.JButton btnViewSecurityEmployees;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
