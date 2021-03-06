/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SOCAnalysisTeam;

import Business.Enterprise.Enterprise;
import Business.Organization.SecurityOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.UnusualActivityWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Gauri
 */
public class SOCAnalysisTeamWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private SecurityOrganization securityOrganization;
    private Enterprise enterprise;
    
    private static final Logger logger =Logger.getLogger(SOCAnalysisTeamWorkAreaJPanel.class);
    /**
     * Creates new form SOCAnalysisTeamWorkAreaJPanel
     */
    public SOCAnalysisTeamWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, SecurityOrganization securityOrganization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=account;
        this.securityOrganization=securityOrganization;
        this.enterprise=enterprise;
        
        populateRequests();
    }
    
    public void populateRequests(){
        DefaultTableModel dtm = (DefaultTableModel) tblRequests.getModel();
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

        btnAnalyzeThreats = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequests = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAnalyzeThreats.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnAnalyzeThreats.setText("Analyze");
        btnAnalyzeThreats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalyzeThreatsActionPerformed(evt);
            }
        });
        add(btnAnalyzeThreats, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 130, 50));

        tblRequests.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        tblRequests.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRequests);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 522, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalyzeThreatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalyzeThreatsActionPerformed
        // TODO add your handling code here:
        int incorrectPassword=0;
        int differentIP=0;
        int differentCountry=0;
        int illegalDataAccess=0;
        int incorrectTestResults=0;
        
        for(WorkRequest request:userAccount.getWorkQueue().getWorkRequestList()){
            UnusualActivityWorkRequest unusualWorkRequest = (UnusualActivityWorkRequest) request;
                if(unusualWorkRequest.getMessage().equals("Incorrect password 3 times")){
                   incorrectPassword++;
                }
                if(unusualWorkRequest.getMessage().equals("User Logged In from different IP Address")){
                    differentIP++;
                }
                if(unusualWorkRequest.getMessage().equals("User Logged In from Country")){
                    differentCountry++;
                }
                if(unusualWorkRequest.getMessage().equals("Accessing illegal data")){
                    illegalDataAccess++;
                }
                if(unusualWorkRequest.getMessage().equals("Providing incorrect Test Results")){
                    incorrectTestResults++;
                }
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(incorrectPassword, "count", "Incorrect Password");
        dataset.setValue(differentIP, "count", "Different IP Address");
        dataset.setValue(differentCountry, "count", "Different Country");
        dataset.setValue(illegalDataAccess, "count", "Doctor Accessing illegal data");
        dataset.setValue(incorrectTestResults, "count", "Lab providing incorrect Test Results");
        
        JFreeChart chart = ChartFactory.createBarChart("Threat Analysis", "Threat Type", "No of occurrence", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartFrame frame = new ChartFrame("Threat Analysis Chart", chart);
        frame.setVisible(true);
        frame.setSize(1200,1200);
        
        /*AnalyzeThreatsJPanel analyzeThreatsJPanel = new AnalyzeThreatsJPanel(userProcessContainer,userAccount,securityOrganization,enterprise);
        userProcessContainer.add("analyzeThreatsJPanel",analyzeThreatsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);*/
    }//GEN-LAST:event_btnAnalyzeThreatsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalyzeThreats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRequests;
    // End of variables declaration//GEN-END:variables
}
