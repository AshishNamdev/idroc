/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import comms.GenerateUID;
import java.util.ArrayList;
import model.Inventory;
import model.User;

/**
 *
 * @author anamdev
 */
public class Test
{
    public static void main(String[] args)
    {
        String UID = GenerateUID.UID("Mohammed-ismail.Zabiulla@amd.com");
        System.out.println(UID);
        //TestFeatures testFeature = new TestFeatures();
        
        //testFeature.testUserLogin();
    }
}

class TestFeatures
{
    public void testUser()
    {
        User usr = new User("SanGuru","sandeep.gururaj@amd.com","San123456","Sandeep","","gururaj");
        //User usr = new User("mzabiull","ismail.zabi@amd.com","zabiIsmail","Mohammed","Ismail","Zabiulla Rizvi");
        if(usr.loginUser(false))
            System.out.println("Alread a User");
        else
        {
            if (usr.addUSer())
                System.out.println("Added User");
            else
                System.out.println("user not added");
        }
            
        
    }
    public void testUserLogin()
    {
        User usr = new User();
        //User usr = new User("mzabiull","ismail.zabi@amd.com","zabiIsmail","Mohammed","Ismail","Zabiulla Rizvi");
        usr.setEmail("sandeep.gururaj@amd.com");
        usr.setPassword("San123456");
        if(usr.loginUser(true))
        {
            System.out.println("logged in");
            System.out.println(usr.getUid());
            System.out.println(usr.getEmail());
            System.out.println(usr.getfName());
            System.out.println(usr.getmName());
            System.out.println(usr.getlName());
            
        }
        
        else
            System.out.println("not logged in");
    }
    
    public void testAddInventory()
    {
        Inventory inv = new Inventory();
        inv.setInvId("DQA002");
        inv.setInvName("Toshiba SSD");
        inv.setInvDetail("SSD to test for LPM and DevSleep settings");
        inv.setInvType("HDD");
        inv.setInvLocation("Markham");
        
        if (inv.isAlreadyAdded())
            System.out.println("Already Added");
        else
        {
            if (inv.addInventory())
                System.out.println("added");
        }
    }
    
    public void testDeleteInventory()
    {
        Inventory inv = new Inventory();
        inv.setInvId("DQA001");
        if (inv.deleteInventory())
            System.out.println("deleted");
        else
            System.out.println("not deleted");
    }
    
    public void testSearchInventory()
    {
        Inventory inv = new Inventory();
        String pattern = "type: H%";
        String keyword = pattern.split(":")[1].trim();
        String option = pattern.split(":")[0].trim();
        //inv.setInvLocation(keyword);
        inv.setInvType(keyword);
        ArrayList<Inventory> invAll = inv.searchInventory(option);
        if (invAll != null)
        {
            for ( Inventory inven : invAll)
            {
                System.out.print(inven.getInvId()+"   ");
                System.out.print(inven.getInvName()+"   ");
                System.out.print(inven.getInvDetail()+"   ");
                System.out.print(inven.getInvType()+"   ");
                System.out.print(inven.getInvLocation()+"   \n");
            }
        }
        else
            System.out.println("No Record Found in data base with pattern '"+pattern+"'");
    }
}