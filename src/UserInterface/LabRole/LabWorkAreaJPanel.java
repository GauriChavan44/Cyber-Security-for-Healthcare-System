/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LabRole;

import Business.Doctor.Doctor;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.SecurityOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PerformTestWorkRequest;
import Business.WorkQueue.UnusualActivityWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.ReceptionistRole.ViewProfileJPanel;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class LabWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount labAccount;
    private LabOrganization labOrganization;
    private Enterprise enterprise;
    private EcoSystem system;
    
    private static final Logger logger =Logger.getLogger(LabWorkAreaJPanel.class);
    /**
     * Creates new form LabWorkAreaJPanel
     */
    public LabWorkAreaJPanel(JPanel userProcessContainer,UserAccount userAccount,LabOrganization labOrganization,Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.labAccount=userAccount;
        this.labOrganization=labOrganization;
        this.enterprise=enterprise;
        this.system=system;
        
        populatePerformTest();
    }

    public void populatePerformTest(){
        DefaultTableModel model = (DefaultTableModel)tblPerformTest.getModel();
        model.setRowCount(0);
        
        
        for(WorkRequest request:labOrganization.getWorkQueue().getWorkRequestList()){
            if(request instanceof PerformTestWorkRequest){
//             int selectedRow = tblPerformTest.getSelectedRow();
   
            Doctor d = (Doctor) request.getSender().getPerson();
            Patient p = (Patient) ((PerformTestWorkRequest) request).getPatientAccount().getPerson();
            Object row[]=new Object[6];
            row[0] = request;
            row[1] = d.getId();
            row[2] = d.getFirstName() + " " + d.getLastName();
            row[3] = p.getId();
            row[4] = p.getFirstName() + " " + p.getLastName();
            row[5] = request.getStatus();
            
            model.addRow(row);              
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPerformTest = new javax.swing.JTable();
        btnAssign = new javax.swing.JButton();
        btnConductTest = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnViewPatientProfile = new javax.swing.JButton();
        btnThreat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPerformTest.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        tblPerformTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request", "Doctor Id", "Doctor Name", "Patient Id", "Patient Name", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblPerformTest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 526, 215));

        btnAssign.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 142, 46));

        btnConductTest.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnConductTest.setText("Conduct Test");
        btnConductTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConductTestActionPerformed(evt);
            }
        });
        add(btnConductTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 142, 46));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Lab Work Area");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        btnViewPatientProfile.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnViewPatientProfile.setText("View Profile");
        btnViewPatientProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPatientProfileActionPerformed(evt);
            }
        });
        add(btnViewPatientProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 164, 48));

        btnThreat.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnThreat.setText("Threat");
        btnThreat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThreatActionPerformed(evt);
            }
        });
        add(btnThreat, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPerformTest.getSelectedRow();
        
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PerformTestWorkRequest request = (PerformTestWorkRequest)tblPerformTest.getValueAt(selectedRow, 0);
        if(request.getStatus().equals("Sent")){
            request.setReceiver(labAccount);
            request.setStatus("Pending");
            labAccount.getWorkQueue().getWorkRequestList().add(request);
            populatePerformTest();
            logger.info("Request Assigned to :"+ request.getReceiver().getUserName());
            JOptionPane.showMessageDialog(null, "Request Assigned Successfully !", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Already under review", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnConductTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConductTestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPerformTest.getSelectedRow();
        Boolean flag=true;
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PerformTestWorkRequest request = (PerformTestWorkRequest)tblPerformTest.getValueAt(selectedRow, 0);
        
        if(request.getStatus().equals("Pending")|| request.getStatus().equals("Test Conducted") ||request.getStatus().equals("Completed")){
            for(WorkRequest r:labAccount.getWorkQueue().getWorkRequestList()){
                if(r.equals(request)){
                    flag=false;
                    break;
                }
            }
        }
        else{
               JOptionPane.showMessageDialog(null, "Test is not assigned to you", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        
        if(!flag){
            ConductTestJPanel conductTestJPanel = new ConductTestJPanel(userProcessContainer,enterprise,labAccount,request);
            userProcessContainer.add("conductTestJPanel",conductTestJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null, "Request not matching", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnConductTestActionPerformed

    private void btnViewPatientProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPatientProfileActionPerformed
        // TODO add your handling code here:
        logger.info(labAccount.getUserName()+" Viewed Profile");
        ViewProfileJPanel viewLabProfileJPanel = new ViewProfileJPanel(userProcessContainer,enterprise,labAccount);
        userProcessContainer.add("viewLabProfileJPanel",viewLabProfileJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewPatientProfileActionPerformed

    private void btnThreatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThreatActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        UnusualActivityWorkRequest workRequest = new UnusualActivityWorkRequest();
        workRequest.setWorkRequestId(system.getIv().getWorkRequestId());
        workRequest.setThreatUser(labAccount);
        workRequest.setMessage("Providing incorrect Test Results");
        workRequest.setRequestDate(date);
        workRequest.setStatus("Sent");
        logger.info(labAccount.getUserName()+" : User provided incorrect Test Results");

        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()){
            if(org instanceof SecurityOrganization){
                org.getWorkQueue().getWorkRequestList().add(workRequest);
                JOptionPane.showMessageDialog(null, "Threat detected !", "Warning", JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_btnThreatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnConductTest;
    private javax.swing.JButton btnThreat;
    private javax.swing.JButton btnViewPatientProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPerformTest;
    // End of variables declaration//GEN-END:variables
}
