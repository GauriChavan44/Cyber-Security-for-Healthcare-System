/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeRole;

import Business.Checks.CheckString;
import Business.Doctor.Doctor;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Encryption.AESCrypt;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.SecurityOrganization;
import Business.Person.Person;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.logging.Level;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem system;
    
    private static final Logger logger =Logger.getLogger(ManageUserAccountJPanel.class);
    /**
     * Creates new form ManageUserAccountJPanel
     */
    public ManageUserAccountJPanel(JPanel userProcessContainer,Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.system=system;
        
        popOrganizationComboBox();
        popData();
    }

    
    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(organization instanceof PatientOrganization){
                continue;
            }
            else{
                organizationJComboBox.addItem(organization);
            }          
        }
    }
    
    public void populateEmployeeComboBox(Organization organization){
        employeeJComboBox.removeAllItems();
        
        for (Person person : organization.getPersonDirectory().getPersonList()){
            employeeJComboBox.addItem(person);
        }
    }
    
    private void populateRoleComboBox(Organization organization){
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            roleJComboBox.addItem(role);
        }
    }

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                if(!String.valueOf(ua.getRole()).equals(RoleType.Patient.getValue())){
                    Object row[] = new Object[3];
                    row[0] = ua;
                    row[1] = ua.getRole();
                    row[2] = ua.getPerson().getId();
                    ((DefaultTableModel) userJTable.getModel()).addRow(row);
                }
                
            }
        }
    }

    public void clearTextFileds(){
        txtUserName.setText("");
        txtPassword.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        createUserJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        txtUserName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeJComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employeeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeJComboBoxActionPerformed(evt);
            }
        });
        add(employeeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 146, 29));

        backjButton1.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 112, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Organization");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 146, 29));

        createUserJButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 110, 40));

        organizationJComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 146, 29));

        txtUserName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 146, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 146, 29));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("User Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 146, 29));

        roleJComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });
        add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 146, 29));

        userJTable.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 82, -1, 154));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 146, 29));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Employee");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 146, 29));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Manage User Account");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 32, -1, -1));
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 140, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/4.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        String userName = txtUserName.getText();
       // String password = txtPassword.getText();
        
        char[] passwordArray = txtPassword.getPassword();
        String password = String.valueOf(passwordArray);
        String encryptedPassword = null;
        
        try {
            encryptedPassword = AESCrypt.encrypt(password);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ManageUserAccountJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
     //   Person employee = (Person) employeeJComboBox.getSelectedItem();
        Role role = (Role) roleJComboBox.getSelectedItem();
        
        Boolean check = CheckString.stringNumericValidation(userName);
        Boolean check1 = CheckString.stringNumericValidation(password);
        
        if(check == true && check1==true){
            Boolean checkSameUserName=false;
                
                for(Network n :system.getNetworkList()){
                    for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                        for(UserAccount ua:e.getUserAccountDirectory().getUserAccountList()){
                    
                            if(ua.getUserName().equalsIgnoreCase(userName)){
                                checkSameUserName=true;
                                break;
                            }
                        }
                    }
                }
            
            if(checkSameUserName==false){
                if(organization instanceof DoctorOrganization){
                    Doctor employee = (Doctor) employeeJComboBox.getSelectedItem();
                    UserAccount u= organization.getUserAccountDirectory().createUserAccount(userName, encryptedPassword, employee, role, Boolean.TRUE);
                    if(u==null){
                        return;
                    }else{
                        logger.info("Doctor Created with UserName : "+userName +" and Role : "+role);
                        JOptionPane.showMessageDialog(null, "User Account Created Successfully !", "Information", JOptionPane.INFORMATION_MESSAGE);
                        clearTextFileds();
                    }
                    
                }
                else{
                     Employee employee = (Employee) employeeJComboBox.getSelectedItem();
                     UserAccount u=organization.getUserAccountDirectory().createUserAccount(userName, encryptedPassword, employee, role, Boolean.TRUE);
                     if(u==null){
                         return;
                     }
                     else{
                         logger.info("Employee Created with UserName : "+userName+" and Role : "+role);
                        JOptionPane.showMessageDialog(null, "User Accoutn Created Successfully !", "Information", JOptionPane.INFORMATION_MESSAGE);
                        clearTextFileds();
                     }
                     
                }
                popData();
            }
            else{
                    JOptionPane.showMessageDialog(null, "UserName Already Exists ! Enter Another UserName", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
            }
            
        }  
    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBoxActionPerformed

    private void employeeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
