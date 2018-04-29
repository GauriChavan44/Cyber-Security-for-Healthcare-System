/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Person.PersonDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Gauri
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }
    
    public enum Type{
        Admin("Admin Organizaton"),
        Doctor("Doctor Organization"),
        Patient("Patient Organization"),
        Reception("Reception Organization"),
        Lab("LabOrganization"),
        Security("Security Organization");
        
        private String value;
        
        private Type(String value){
            this.value=value;
        }
        public String getValue(){
            return value;
        }
    }
    
    public Organization(String name){
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
     //   organizationID = ++counter;
    }
    
    public abstract ArrayList<Role> getSupportedRole();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int aCounter) {
        counter = aCounter;
    }

    

    @Override
    public String toString() {
        return this.getName();
    }
}
