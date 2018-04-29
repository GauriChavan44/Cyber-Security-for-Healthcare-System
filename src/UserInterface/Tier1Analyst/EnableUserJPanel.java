/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Tier1Analyst;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class EnableUserJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    
    private static final Logger logger =Logger.getLogger(EnableUserJPanel.class);
    /**
     * Creates new form EnableUserJPanel
     */
    public EnableUserJPanel(JPanel userProcessContainer,Enterprise enterprise,UserAccount userAccount) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.userAccount=userAccount;
        
        populateTable();
    }
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblEnableUser.getModel();
        dtm.setRowCount(0);
        
        for(Organization o:enterprise.getOrganizationDirectory().getOrganizationList()){
            for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList())
                if(ua.isIsActive()==false){
                    Object row[]=new Object[4];
                    row[0]=ua;
                    row[1]=ua.getUserName();
                    row[2]=ua.isIsActive();

                    dtm.addRow(row);
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

        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEnableUser = new javax.swing.JTable();
        btnActivate = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Tier 1 Analyst Work Area");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEnableUser.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        tblEnableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "User Name", "Account Status", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEnableUser);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 473, 191));

        btnActivate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnActivate.setText("Activate");
        btnActivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateActionPerformed(evt);
            }
        });
        add(btnActivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 125, 49));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Activate User Account");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        btnBack.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblEnableUser.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "First Select A Row !", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            UserAccount account = (UserAccount) tblEnableUser.getValueAt(selectedRow, 0);
            account.setIsActive(true);
            
            JOptionPane.showMessageDialog(null, "User Account Activated !", "Information", JOptionPane.INFORMATION_MESSAGE);
            populateTable();
        }
    }//GEN-LAST:event_btnActivateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        Tier1WorkAreaJPanel tier1 = (Tier1WorkAreaJPanel) component;
        tier1.populateSecurityThreatsTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivate;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEnableUser;
    // End of variables declaration//GEN-END:variables
}