/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Gauri
 */
public class Person {
    
   // public static int count;
  //  private static int counter=100;
    private int id;
    private String firstName;
    private String lastName;
    private String IPAddress;
    private Address address;


    public Person(){
   //     counter++;
   //     id=counter;
        IPAddress=ThreadLocalRandom.current().nextInt(10, 11 + 1) +"."+ThreadLocalRandom.current().nextInt(100, 111 + 1) +"."+ThreadLocalRandom.current().nextInt(10, 13 + 1)+"."+ThreadLocalRandom.current().nextInt(10, 12 + 1);//+"."
    }   

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }
    

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
