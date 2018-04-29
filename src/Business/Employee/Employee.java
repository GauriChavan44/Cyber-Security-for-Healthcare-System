/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author Gauri
 */
public class Employee extends Person{


    public Employee(){
        super();
    }
    
     @Override
    public String toString() {
        return getFirstName();
    }


}
