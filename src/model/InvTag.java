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
public class InvTag
{
    private String inventoryInvID;
    private String tagsTagID;

    public InvTag()
    {
        this.inventoryInvID = null;
        this.tagsTagID = null;
    }

    public InvTag(String inventoryInvID, String tagsTagID)
    {
        this.inventoryInvID = inventoryInvID;
        this.tagsTagID = tagsTagID;
    }

    public String getInventoryInvID()
    {
        return inventoryInvID;
    }

    public void setInventoryInvID(String inventoryInvID)
    {
        this.inventoryInvID = inventoryInvID;
    }

    public String getTagsTagID()
    {
        return tagsTagID;
    }

    public void setTagsTagID(String tagsTagID)
    {
        this.tagsTagID = tagsTagID;
    }
}
