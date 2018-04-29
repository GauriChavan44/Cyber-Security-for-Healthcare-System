/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Encryption.AESCrypt;
import Business.Person.Address;
import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gauri
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        EcoSystem system = EcoSystem.getInstance();
       
        //Person person =system.getPersonDirectory().createPerson("Gauri", "Chavan");
        
        Employee employee = new Employee();
        employee.setFirstName("Gauri");
        employee.setLastName("Chavan");
        employee.setId(1);
        employee.setIPAddress("10.133.13.10");
        Address a = new Address("12C Horadan Way","Boston","MA","USA",02120);
        system.getPersonDirectory().addPerson(employee);
        try {
            //     Employee employee = system.getEmployeeDirectory().createEmployee("Gauri");//, "Chavan", "06/22/1992", 123412341);
            UserAccount userAccount = system.getUserAccountDirectory().createUserAccount("Admin", AESCrypt.encrypt("Admin"), employee, new SystemAdminRole(),Boolean.TRUE);
        } catch (Exception ex) {
            Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return system;
    }
}
