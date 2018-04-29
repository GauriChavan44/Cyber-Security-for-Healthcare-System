/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Gauri
 */
public class InitializeVariables {
    
    
    private int personId;
    private int workRequestId;
    private int organizationId;
    
    public InitializeVariables(){
        personId=1;
        workRequestId=1000;
        organizationId=2000;
    }

    public int getPersonId() {
        return personId++;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getWorkRequestId() {
        return workRequestId++;
    }

    public void setWorkRequestId(int workRequestId) {
        this.workRequestId = workRequestId;
    }

    public int getOrganizationId() {
        return organizationId++;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
