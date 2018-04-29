/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Encryption.AESCrypt;
import Business.Person.Person;
import Business.Role.Role;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gauri
 */
public class UserAccountDirectory {
    
    public ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory(){
        userAccountList=new ArrayList<>();
    }
    
    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
  /*  public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUserName().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }*/
    int counter = 0;
    public UserAccount authenticateUser(String username, String password) throws Exception{
        
        
        
        for (UserAccount ua : userAccountList){
            
            if (ua.getUserName().equalsIgnoreCase(username) ){//{&& ua.getPassword().equals(password)){
                if(ua.getPassword().equals(password)){
                    ua.setCounter(0);
                    return ua;
                }
                else{
                    int counter = ua.getCounter();
                    counter++;
                    ua.setCounter(counter);
                    if(counter==3){
                        JOptionPane.showMessageDialog(null, "Incorrect Password Entered 3 times !", "Error", JOptionPane.ERROR_MESSAGE);
                        return ua;
                    }
                }
            }
        }
            
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Person person, Role role, Boolean isActive){
        
        for(UserAccount ua:userAccountList){
            if(ua.getUserName().equalsIgnoreCase(username)){
                JOptionPane.showMessageDialog(null, "UserName Already Exists ! Enter Another UserName", "Warning", JOptionPane.WARNING_MESSAGE);
                return null;
            }
        }
        
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
      //  userAccount.setPatient(patient);
        userAccount.setRole(role);
        userAccount.setIsActive(true);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUserName().equals(username))
                return false;
        }
        return true;
    }
    
    public void deleteUserAccount(UserAccount ua){
        userAccountList.remove(ua);
    }
}
