/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Gauri
 */
public class PerformTestWorkRequest extends WorkRequest{

    private UserAccount patientAccount;
    private int requestId;
    private int respiratoryRate;
    private int heartRate;
    private int bloodPressure;
    private int weight;
    private Date timestamp;
    
    public PerformTestWorkRequest(UserAccount patientAccount,int workRequestId) {
        this.patientAccount=patientAccount;
        this.requestId=workRequestId;
    }

    
    public UserAccount getPatientAccount() {
        return patientAccount;
    }

    public void setPatientAccount(UserAccount patientAccount) {
        this.patientAccount = patientAccount;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getRequestId() {
        return requestId;
    }
    
}
