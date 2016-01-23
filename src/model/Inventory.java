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
public class Inventory
{
    private String invId;
    private String invName;
    private String invDetail;
    private String invType;
    private String invLocation;

    public Inventory()
    {
        this.invId = null;
        this.invName = null;
        this.invDetail = null;
        this.invType = null;
        this.invLocation = null;
    }
        
    public Inventory(String invId, String invName, String invDetail, String invType, String invLocation)
    {
        this.invId = invId;
        this.invName = invName;
        this.invDetail = invDetail;
        this.invType = invType;
        this.invLocation = invLocation;
    }

    public String getInvId()
    {
        return invId;
    }

    public void setInvId(String invId)
    {
        this.invId = invId;
    }

    public String getInvName()
    {
        return invName;
    }

    public void setInvName(String invName)
    {
        this.invName = invName;
    }

    public String getInvDetail()
    {
        return invDetail;
    }

    public void setInvDetail(String invDetail)
    {
        this.invDetail = invDetail;
    }

    public String getInvType()
    {
        return invType;
    }

    public void setInvType(String invType)
    {
        this.invType = invType;
    }

    public String getInvLocation()
    {
        return invLocation;
    }

    public void setInvLocation(String invLocation)
    {
        this.invLocation = invLocation;
    }
}