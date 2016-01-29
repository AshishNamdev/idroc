/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import comms.Query;
import dbcom.DbCom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public boolean isAlreadyAdded()
    {
        boolean ret = false;
        Connection connection = null;
        PreparedStatement prepSt = null;

        try
        {
            connection = DbCom.createConnection();
            prepSt = connection.prepareStatement(Query.INVENTORYCHECK);
            prepSt.setString(1,this.getInvId());

            if(prepSt.executeQuery().next())
                    ret = true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            DbCom.releaseResources(connection, prepSt, null);
        }
        return ret;
    }

    public boolean addInventory()
    {
        boolean ret = false;
        Connection connection = null;
        PreparedStatement prepSt = null;
        try
        {
            connection = DbCom.createConnection();
            prepSt = connection.prepareStatement(Query.INVENTORYINSERT);
            prepSt.setString(1, this.getInvId());
            prepSt.setString(2, this.getInvName());
            prepSt.setString(3, this.getInvDetail());
            prepSt.setString(4, this.getInvType());
            prepSt.setString(5, this.getInvLocation());

            if(prepSt.executeUpdate() > 0)
                ret = true;
            //connection.commit();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            DbCom.releaseResources(connection, prepSt, null);
        }
        return ret;
    }

    public boolean deleteInventory()
    {
        boolean ret = false;
        Connection connection = null;
        PreparedStatement prepSt = null;

        try
        {
            connection = DbCom.createConnection();
            prepSt = connection.prepareStatement(Query.INVENTORYDELETE);
            prepSt.setString(1, this.getInvId());
            if(prepSt.executeUpdate() > 0)
                    ret = true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            DbCom.releaseResources(connection, prepSt, null);
        }
        return ret;
    }
}