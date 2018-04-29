/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Gauri
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private InitializeVariables iv;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }
    
    public EcoSystem(){
       super(null);
       networkList=new ArrayList<>(); 
       iv = new InitializeVariables();
    }  
    
    public static EcoSystem getBusiness() {
        return business;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
      
    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    public InitializeVariables getIv() {
        return iv;
    }

    public void setIv(InitializeVariables iv) {
        this.iv = iv;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    

}
