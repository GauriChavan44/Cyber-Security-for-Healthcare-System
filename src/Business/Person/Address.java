/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author Gauri
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private int pinCode;
    
    public Address(String street, String city,String state,String country,int pinCode){
        this.city=city;
        this.street=street;
        this.state=state;
        this.country = country;
        this.pinCode=pinCode;
    }
    
    

    public String getStreetNum() {
        return street;
    }

    public void setStreetNum(String streetNum) {
        this.street = streetNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
    
}
