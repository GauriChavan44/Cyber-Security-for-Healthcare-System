/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package UserInferface.SystemAdminWorkArea;

import Business.Checks.CheckString;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Encryption.AESCrypt;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Person.Address;
import Business.Role.AdminRole;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author Gauri
 */
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private EcoSystem system;
    
    private static final Logger logger =Logger.getLogger(ManageEnterpriseAdminJPanel.class);
    /**
     * Creates new form ManageEnterpriseAdminJPanel
     */
    public ManageEnterpriseAdminJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        
        populateTable();
        populateCountryJComboBox();
        populateNetworkComboBox();
    }
    public void populateCountryJComboBox(){
        countryJComboBox.removeAllItems();;
        
        countryJComboBox.addItem("USA");
        countryJComboBox.addItem("Canada");
        countryJComboBox.addItem("India");
        countryJComboBox.addItem("China");
    }
    
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseJTable.getModel();
        
        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    Object[] row = new Object[3];
                    row[0] = enterprise.getName();
                    row[1] = network.getName();
                    row[2] = userAccount.getUserName();
                    
                    model.addRow(row);
                }
            }
        }
    }
    
    private void populateNetworkComboBox(){
        networkJComboBox.removeAllItems();
        
        for (Network network : system.getNetworkList()){
            networkJComboBox.addItem(network);
        }
    }
    
    private void populateEnterpriseComboBox(Network network){
        enterpriseJComboBox.removeAllItems();
        
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            enterpriseJComboBox.addItem(enterprise);
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

        passwordJPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        networkJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        enterpriseJComboBox = new javax.swing.JComboBox();
        submitJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseJTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtStreetNo = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        countryJComboBox = new javax.swing.JComboBox<>();
        txtPinCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1219, 552));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        passwordJPasswordField.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        add(passwordJPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 136, 27));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Network");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 136, 27));

        backJButton.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, -1, -1));

        networkJComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });
        add(networkJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 136, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Username");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 136, 27));

        usernameJTextField.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        add(usernameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 136, 27));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Enterprise");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 136, 27));

        enterpriseJComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseJComboBoxActionPerformed(evt);
            }
        });
        add(enterpriseJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 136, -1));

        submitJButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 136, 48));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Password");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 136, 27));

        nameJTextField.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 136, 27));

        enterpriseJTable.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "Network", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enterpriseJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 650, 150));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("First Name");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 136, 27));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Manage Enterprise Admin");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 30));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Last Name");
        jLabel9.setToolTipText("");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 130, 29));

        txtLastName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        txtLastName.setToolTipText("");
        txtLastName.setMaximumSize(null);
        add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 140, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setText("Pincode");
        jLabel10.setToolTipText("");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 130, 29));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("Country");
        jLabel8.setToolTipText("");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 130, 29));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setText("State");
        jLabel11.setToolTipText("");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 130, 29));

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel12.setText("City");
        jLabel12.setToolTipText("");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 130, 29));

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel13.setText("Street No.");
        jLabel13.setToolTipText("");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 130, 29));

        txtStreetNo.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        txtStreetNo.setToolTipText("");
        txtStreetNo.setMaximumSize(null);
        add(txtStreetNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 130, -1));

        txtCity.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        txtCity.setToolTipText("");
        txtCity.setMaximumSize(null);
        add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 130, -1));

        txtState.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        txtState.setToolTipText("");
        txtState.setMaximumSize(null);
        add(txtState, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 130, -1));

        countryJComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        countryJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        countryJComboBox.setMaximumSize(null);
        countryJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryJComboBoxActionPerformed(evt);
            }
        });
        add(countryJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 130, 29));

        txtPinCode.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        txtPinCode.setToolTipText("");
        txtPinCode.setMaximumSize(null);
        add(txtPinCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 130, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/4.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed
        
        Network network = (Network) networkJComboBox.getSelectedItem();
        if (network != null){
            populateEnterpriseComboBox(network);
        }

    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        
        Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
        String firstName=null;
        String lastName=null;
        String username=null;
        String password=null;
        String street =null;
        String city=null;
        String state=null;
        String country=null;
        int pinCode=0;
        
        try{
            username = usernameJTextField.getText();
            char[] passwordArray = passwordJPasswordField.getPassword();
            password = String.valueOf(passwordArray);
            String encryptedPassword = null;
            
            try {
                encryptedPassword = AESCrypt.encrypt(password);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(ManageEnterpriseAdminJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            firstName = nameJTextField.getText();
            lastName = txtLastName.getText();
            street = txtStreetNo.getText();
            city = txtCity.getText();
            state = txtState.getText();
            pinCode = Integer.parseInt(txtPinCode.getText());
            country = (String) countryJComboBox.getSelectedItem();
            
            
            Boolean check = CheckString.stringNumericValidation(username);
            Boolean check1 = CheckString.stringNumericValidation(password);
            Boolean check2 = CheckString.stringValidation(firstName);
            Boolean check3 = CheckString.stringValidation(lastName);
            Boolean check4 = CheckString.stringValidation(city);
            Boolean check5 = CheckString.stringValidation(state);
          //  Boolean check4 = CheckString.stringValidation(country);
            Boolean check6 = CheckString.IntValidation(pinCode);
            Boolean check7 = CheckString.stringNumericValidation(street);
            
            if(check == true && check1 == true && check2 == true&& check3 == true && check4 == true && check5 == true && check6 == true && check7 == true){
                
                Boolean checkIfAdminPresent=false;
                
                for(UserAccount ua:enterprise.getUserAccountDirectory().getUserAccountList()){
                    //    System.out.println("ua.getRole()"+ua.getRole());
                    //    System.out.println("RoleType.Admin"+RoleType.Admin);
                    
                    if(String.valueOf(ua.getRole()).equals(String.valueOf(RoleType.Admin))){
                        checkIfAdminPresent=true;
                        break;
                    }
                }
                if(!checkIfAdminPresent){
                    Boolean checkSameUserName=false;
                    
                    for(Network n :system.getNetworkList()){
                        for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                            for(UserAccount ua:e.getUserAccountDirectory().getUserAccountList()){
                                
                                //      System.out.println("ua.getUserName()"+ua.getUserName());
                                //      System.out.println("username"+username);
                                if(ua.getUserName().equalsIgnoreCase(username)){
                                    checkSameUserName=true;
                                    break;
                                }
                            }
                        }
                    }
                    
                    if(!checkSameUserName){
                        Employee employee = new Employee();
                        employee.setId(system.getIv().getPersonId());
                        employee.setFirstName(firstName);
                        employee.setLastName(lastName);
                        employee.setIPAddress("10.122.33.12");
                        Address a=new Address(street,city,state,country,pinCode);
                        employee.setAddress(a);
                        
                        enterprise.getUserAccountDirectory().createUserAccount(username, encryptedPassword, employee, new AdminRole(), Boolean.TRUE);
                        
                        //  UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new AdminRole());
                        
                        
                        
                        /*    Organization org=enterprise.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
                        
                        
                        org.getPersonDirectory().addPerson(employee);
                        // Person employee = enterprise.getPersonDirectory().createPerson(name, name);
                        
                        org.getUserAccountDirectory().createUserAccount(username, password, employee,new AdminRole(),Boolean.TRUE);
                        */ populateTable();
                        
                        JOptionPane.showMessageDialog(null, "User Account Created Succssfully !", "Information", JOptionPane.INFORMATION_MESSAGE);
                        usernameJTextField.setText("");
                        passwordJPasswordField.setText("");
                        nameJTextField.setText("");
                        txtLastName.setText("");
                        txtStreetNo.setText("");
                        txtCity.setText("");
                        txtState.setText("");
                        txtPinCode.setText("");
                        return;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "UserName Already Exists ! Enter Another UserName", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Enterprise Admin Already Created !", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                
                
                
                
                
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter correct data", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }
        
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void enterpriseJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseJComboBoxActionPerformed

    private void countryJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryJComboBoxActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox<String> countryJComboBox;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPinCode;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStreetNo;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}