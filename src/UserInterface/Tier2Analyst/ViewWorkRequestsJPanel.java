/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Tier2Analyst;

import Business.Enterprise.Enterprise;
import Business.Organization.SecurityOrganization;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.UnusualActivityWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class ViewWorkRequestsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private SecurityOrganization securityOrganization;
    private Enterprise enterprise;
    
    private static final Logger logger =Logger.getLogger(ViewWorkRequestsJPanel.class);
    /**
     * Creates new form Tier2WorkAreaJPanel
     */
    public ViewWorkRequestsJPanel(JPanel userProcessContainer, UserAccount userAccount, SecurityOrganization securityOrganization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.securityOrganization=securityOrganization;
        this.enterprise=enterprise;
        
        populateSecurityThreats();
        populateThreatsJComboBox();
    
    }
    
    public void populateThreatsJComboBox(){
        threatsJComboBox.removeAllItems();
        
        threatsJComboBox.addItem("Deactivate Account");
    }
    
    public void populateSecurityThreats(){
        DefaultTableModel dtm = (DefaultTableModel) tblSecurityThreats.getModel();
        dtm.setRowCount(0);
       
        for(WorkRequest work : userAccount.getWorkQueue().getWorkRequestList()){
            UnusualActivityWorkRequest unusualWorkRequest = (UnusualActivityWorkRequest) work;
            
            Object row[]=new Object[6];
            row[0]=work;
            row[1]=unusualWorkRequest.getThreatUser().getPerson().getId();
            row[2]=unusualWorkRequest.getThreatUser().getPerson().getFirstName();
            row[3]=unusualWorkRequest.getThreatUser().getPerson().getLastName();
            row[4]=unusualWorkRequest.getWorkRequestId();
            row[5]=unusualWorkRequest.getStatus();
            
            dtm.addRow(row);
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
        tblSecurityThreats = new javax.swing.JTable();
        btnSubmit = new javax.swing.JButton();
        btnViewLog = new javax.swing.JButton();
        threatsJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSecurityThreats.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        tblSecurityThreats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Id", "First Name", "Last Name", "Work Request id", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblSecurityThreats);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 522, 150));

        btnSubmit.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 163, 46));

        btnViewLog.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnViewLog.setText("View Log");
        btnViewLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLogActionPerformed(evt);
            }
        });
        add(btnViewLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 163, 46));

        threatsJComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        threatsJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(threatsJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 159, 49));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Perform Action");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        btnBack.setFont(new java.awt.Font("Al Bayan", 1, 15)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 523, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Work Request");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLogActionPerformed
        // TODO add your handling code here:
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("/Users/Gauri/NetBeansProjects/AEDFinalProject/log/example.log");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                //System.out.println("Could not opendddfd");
                // no application registered for PDFs
            }
        }
    }//GEN-LAST:event_btnViewLogActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblSecurityThreats.getSelectedRow();
        if(selectedRow <0){
            JOptionPane.showMessageDialog(null, "First Select A Request !", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String selectedItem =  (String) threatsJComboBox.getSelectedItem();
        if(selectedItem.isEmpty()){
            JOptionPane.showMessageDialog(null, "Select an Action First !", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(selectedItem.equals("Deactivate Account")){
            UnusualActivityWorkRequest request = (UnusualActivityWorkRequest) tblSecurityThreats.getValueAt(selectedRow, 0);
           // UnusualActivityWorkRequest r =(UnusualActivityWorkRequest) request;
            if(request.getStatus().equals("Request Escalated")){
                request.setSender(userAccount);
                request.getThreatUser().setIsActive(false);
                request.setReceiver(userAccount);
                request.setStatus("Action Performed by Tier2 Analyst");
                
                for(UserAccount ua :securityOrganization.getUserAccountDirectory().getUserAccountList()){
                    System.out.println("ua.getRole()"+ua.getRole());
                    System.out.println("Role.RoleType.SOCAnalysisTeam"+Role.RoleType.SOCAnalysisTeam);
                    if(String.valueOf(ua.getRole()).equals(RoleType.SOCAnalysisTeam.getValue())){
                        ua.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
                JOptionPane.showMessageDialog(null, "User Account Deactivated Successfully !", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            else{
                JOptionPane.showMessageDialog(null, "Request Already Handled !", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewLog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSecurityThreats;
    private javax.swing.JComboBox threatsJComboBox;
    // End of variables declaration//GEN-END:variables
}