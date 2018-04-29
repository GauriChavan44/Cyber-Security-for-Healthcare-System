/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Gauri
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory(){
        organizationList=new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization =null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Patient.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Reception.getValue())){
            organization = new ReceptionOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Security.getValue())){
            organization = new SecurityOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    public String searchOrganizationType(Type type){
        for(Organization.Type t:Organization.Type.values()){
            if(t.getValue().equals(Organization.Type.Patient.getValue())){
                return "Patient";
            }
        }
        for(Organization o:organizationList){
            
        }
        
       return null;
    }
 /*   
    for (Organization.Type type : Organization.Type.values()){
            if (!type.getValue().equals(Organization.Type.Admin.getValue()))
                organizationJComboBox.addItem(type);
        }
    
    Type type = (Type) organizationJComboBox.getSelectedItem();
        directory.createOrganization(type);
        populateTable();
    
    public Customer searchSupplier(String keyword){
        for (Customer c : customerDirectory) {
            if(c.getCustomerName().equals(keyword)){
                return c;
            }
        }
        return null;
    }*/
}
