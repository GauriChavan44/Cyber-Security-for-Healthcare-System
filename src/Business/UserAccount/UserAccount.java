/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Encryption.AESCrypt;
import Business.Person.Person;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.WorkQueue.WorkQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gauri
 */
public class UserAccount {

   // private static int count=10000;
    private int counter;
    private String password;
    private String userName;
    private Role role;
    private RoleType roleType;
    private boolean isActive;
    private Person person;
  //  private Patient patient;
    private WorkQueue workQueue;

    public UserAccount(){
        workQueue = new WorkQueue();
    }
    
    
    
    public String getPassword() {
        try {
            return AESCrypt.decrypt(password);
        } catch (Exception ex) {
            Logger.getLogger(UserAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }   
    
    

     @Override
    public String toString() {
        return userName;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    
    
}
