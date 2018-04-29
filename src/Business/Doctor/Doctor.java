/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import Business.Patient.Patient;
import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author Gauri
 */
public class Doctor extends Person {
    
    private String specialization;
    private ArrayList<Patient> patientList;
    
    public Doctor(){
        super();
        patientList = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    @Override
    public String toString() {
        return getFirstName();
    }
}
