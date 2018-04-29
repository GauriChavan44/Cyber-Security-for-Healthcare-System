/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Person.Person;

/**
 *
 * @author Gauri
 */
public class Patient extends Person{
    
    private static int i = 100;
    private int patientId;
    
    VitalSignHistory vitalSignHistory;
    
    public Patient(){
        super();
        vitalSignHistory=new VitalSignHistory();
    }

    public VitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }
    
    
    @Override
    public String toString(){
        return getFirstName();
    }
    
    
}
