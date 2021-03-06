/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PerformTestWorkRequest;
import Business.WorkQueue.RequestDoctorWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.PatientRole.ViewVitalSignJPanel;
import java.awt.CardLayout;
import java.awt.Component;
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
public class DiagnosePatientJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private DoctorOrganization doctorOrganization;
    private UserAccount doctorAccount;
    private RequestDoctorWorkRequest workRequest;
    private EcoSystem system;
    
    private static final Logger logger =Logger.getLogger(DiagnosePatientJPanel.class);
    /**
     * Creates new form DiagnosePatientJPanel
     */
    public DiagnosePatientJPanel(JPanel userProcessContainer,Enterprise enterprise,DoctorOrganization doctorOrganization,UserAccount doctorAccount,RequestDoctorWorkRequest workRequest,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.doctorOrganization=doctorOrganization;
        this.doctorAccount=doctorAccount;
        this.workRequest =workRequest;
        this.system=system;
    }

    public void populateViewResult(){
        DefaultTableModel dtm = (DefaultTableModel) tblResult.getModel();
        dtm.setRowCount(0);
        Boolean flag=true;
       /* for(WorkRequest work:doctorAccount.getWorkQueue().getWorkRequestList()){
            if(work instanceof PerformTestWorkRequest){
                if(((PerformTestWorkRequest) work).getPatientAccount().equals(workRequest.getSender())){
                    System.out.println("Patient Account : "+((PerformTestWorkRequest) work).getPatientAccount());
                    System.out.println("Work Request sender : "+workRequest.getSender());
                    System.out.println("Work Status : "+work.getStatus());
                    if(work.getStatus().equals("Test Conducted")){
                        Object row[]=new Object[5];
                        row[0]=((PerformTestWorkRequest) work).getRespiratoryRate() ;
                        row[1]=((PerformTestWorkRequest) work).getHeartRate();
                        row[2]=((PerformTestWorkRequest) work).getBloodPressure();
                        row[3]=((PerformTestWorkRequest) work).getWeight();
                        dtm.addRow(row);
                        break;
                    }
                    
                }
            }
        }*/
        Boolean flag1=true;
        
        for(WorkRequest work:doctorAccount.getWorkQueue().getWorkRequestList()){
            if(work instanceof PerformTestWorkRequest){
                if(((PerformTestWorkRequest) work).getRequestId()==workRequest.getWorkRequestId()){
                        Object row[]=new Object[5];
                        row[0]=((PerformTestWorkRequest) work).getRespiratoryRate() ;
                        row[1]=((PerformTestWorkRequest) work).getHeartRate();
                        row[2]=((PerformTestWorkRequest) work).getBloodPressure();
                        row[3]=((PerformTestWorkRequest) work).getWeight();
                        dtm.addRow(row);
                        flag1=false;
                }
            }
        }
        if(flag1==true){
            JOptionPane.showMessageDialog(null, "Test Results are not available", "Information", JOptionPane.INFORMATION_MESSAGE);  
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

        btnViewVitalSign = new javax.swing.JButton();
        btnPerformTest = new javax.swing.JButton();
        btnViewResult = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewVitalSign.setFont(new java.awt.Font("Al Bayan", 1, 13)); // NOI18N
        btnViewVitalSign.setText("View VitalSign");
        btnViewVitalSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVitalSignActionPerformed(evt);
            }
        });
        add(btnViewVitalSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 129, -1, 49));

        btnPerformTest.setFont(new java.awt.Font("Al Bayan", 1, 13)); // NOI18N
        btnPerformTest.setText("Perform Test");
        btnPerformTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerformTestActionPerformed(evt);
            }
        });
        add(btnPerformTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 129, 153, 49));

        btnViewResult.setFont(new java.awt.Font("Al Bayan", 1, 13)); // NOI18N
        btnViewResult.setText("View Result");
        btnViewResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewResultActionPerformed(evt);
            }
        });
        add(btnViewResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 196, 153, 49));

        tblResult.setFont(new java.awt.Font("Al Bayan", 1, 13)); // NOI18N
        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "Respiratory Rate", "Heart Rate", "Blood Pressure", "Weight"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 288, 522, 83));

        btnBack.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Diagnose Patient");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewVitalSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVitalSignActionPerformed
        // TODO add your handling code here:
        ViewVitalSignJPanel vVitalSignJPanel = new ViewVitalSignJPanel(userProcessContainer, workRequest.getSender(), enterprise);
        userProcessContainer.add("vVitalSignJPanel",vVitalSignJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewVitalSignActionPerformed

    private void btnPerformTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerformTestActionPerformed
        // TODO add your handling code here:
        if(workRequest.getStatus().equals("Pending")){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            workRequest.setStatus("In Process");
            PerformTestWorkRequest performRequest = new PerformTestWorkRequest(workRequest.getSender(),workRequest.getWorkRequestId());
            performRequest.setWorkRequestId(system.getIv().getWorkRequestId());
            performRequest.setSender(doctorAccount);
            performRequest.setStatus("Sent");
            performRequest.setMessage("Perform Tests");
            performRequest.setRequestDate(date);


            Organization org =null;
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                if(organization instanceof LabOrganization){
                    org = organization;
                    break;
                }
            }
            if(org!=null){
                org.getWorkQueue().getWorkRequestList().add(performRequest);
                doctorAccount.getWorkQueue().getWorkRequestList().add(performRequest);
                logger.info("Doctor sent request to Lab");
                JOptionPane.showMessageDialog(null, "Sent to Lab for Test", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(workRequest.getStatus().equals("Completed")){
            JOptionPane.showMessageDialog(null, "Request completed", "Information", JOptionPane.INFORMATION_MESSAGE);
        
        }
        else{
            JOptionPane.showMessageDialog(null, "Request already in Process", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnPerformTestActionPerformed

    private void btnViewResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewResultActionPerformed
        // TODO add your handling code here:
   /*  for(WorkRequest work:doctorAccount.getWorkQueue().getWorkRequestList()){
         if(work instanceof PerformTestWorkRequest){
             if(((PerformTestWorkRequest) work).getPatientAccount().equals(workRequest.getSender())){
                if(work.getStatus().equals("Test Conducted")){
                    System.out.println("inside test conductedddd");
                    populateViewResult();
                    work.setStatus("Completed");
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Test Results are not available", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
             }
         }
     }*/
   
        Boolean flag=true;
        if(workRequest.getStatus().equals("In Process") || workRequest.getStatus().equals("Completed")){  
            for(WorkRequest work:doctorAccount.getWorkQueue().getWorkRequestList()){
                if(work instanceof PerformTestWorkRequest){
                    if(((PerformTestWorkRequest) work).getRequestId()==workRequest.getWorkRequestId()){
                        if(work.getStatus().equals("Completed")){
                            populateViewResult();
                        }
                        
                        else if(work.getStatus().equals("Test Conducted")){
                                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                Date date = new Date();
                                populateViewResult();
                                work.setStatus("Completed");
                                work.setResolveDate(date);
                                workRequest.setStatus("Completed");
                                workRequest.setResolveDate(date);
                                flag=false;
                                break;
                            
                        }
                        else if(work.getStatus().equals("Pending") ||work.getStatus().equals("Sent")){
                            JOptionPane.showMessageDialog(null, "Test Result Not Yet Available !", "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
           /* if(flag==true){
            JOptionPane.showMessageDialog(null, "Test Results are not available", "Information", JOptionPane.INFORMATION_MESSAGE);
        }*/
        }
        else if(workRequest.getStatus().equals("Pending")){
            JOptionPane.showMessageDialog(null, "First Perform Test !", "Warning", JOptionPane.WARNING_MESSAGE);
        
        }
        
        
            
            
        
    }//GEN-LAST:event_btnViewResultActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorWorkAreaJPanel doctor = (DoctorWorkAreaJPanel) component;
        doctor.populateWorkRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPerformTest;
    private javax.swing.JButton btnViewResult;
    private javax.swing.JButton btnViewVitalSign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables
}
