/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author Gauri
 */
public class UnusualActivityWorkRequest extends WorkRequest {
    
    private UserAccount threatUser;
    private int severity;

    public UserAccount getThreatUser() {
        return threatUser;
    }

    public void setThreatUser(UserAccount threatUser) {
        this.threatUser = threatUser;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }
}
