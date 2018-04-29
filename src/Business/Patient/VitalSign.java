/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gauri
 */
public class VitalSign {
   
    private int respiratoryRate;
    private int heartRate;
    private int bloodPressure;
    private int weight;
    private Date timestamp;

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

    @Override
    public String toString() {
        
        return String.valueOf(respiratoryRate);
        //SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mm:ss a");
        //return ft.format(timestamp);
    } 
}
