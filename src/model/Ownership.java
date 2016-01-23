/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author anamdev
 */
public class Ownership
{
    private String userUID;
    private String inventoryInvID;

    public Ownership()
    {
        this.userUID = null;
        this.inventoryInvID = null;
    }

    public Ownership(String userUID, String inventoryInvID)
    {
        this.userUID = userUID;
        this.inventoryInvID = inventoryInvID;
    }

    public String getUserUID()
    {
        return userUID;
    }

    public void setUserUID(String userUID)
    {
        this.userUID = userUID;
    }

    public String getInventoryInvID()
    {
        return inventoryInvID;
    }

    public void setInventoryInvID(String inventoryInvID)
    {
        this.inventoryInvID = inventoryInvID;
    }
}