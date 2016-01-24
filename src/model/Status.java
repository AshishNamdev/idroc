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
public class Status
{
    private String inventoryInvID;
    private String status;

    public Status()
    {
        this.inventoryInvID = null;
        this.status = null;
    }

    public Status(String inventoryInvID, String status)
    {
        this.inventoryInvID = inventoryInvID;
        this.status = status;
    }

    public String getInventoryInvID()
    {
        return inventoryInvID;
    }

    public void setInventoryInvID(String inventoryInvID)
    {
        this.inventoryInvID = inventoryInvID;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
