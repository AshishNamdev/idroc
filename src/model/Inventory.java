/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import comms.CommStrings;
import comms.Query;
import dbcom.DbCom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

     public ArrayList<Inventory> searchInventory(String option)
    {
        ArrayList<Inventory> inventoryList = null;
        Connection connection = null;
        PreparedStatement prepSt = null;
        ResultSet rst = null;
        String sql = null;
        String placeHolder = null;

        String[] selectedOptions = this.selectOptions(option);
        sql = selectedOptions[0];
        placeHolder = selectedOptions[1];

        try
        {
            connection = DbCom.createConnection();
            prepSt = connection.prepareStatement(sql);

            prepSt.setString(1, placeHolder);
            rst = prepSt.executeQuery();
            if (rst.next())
            {
                inventoryList = new ArrayList<Inventory>();
                rst.beforeFirst();
            }
            while(rst.next())
            {
                Inventory invItem = new Inventory();
                invItem.setInvId(rst.getString(CommStrings.INVID));
                invItem.setInvName(rst.getString(CommStrings.INVNAME));
                invItem.setInvDetail(rst.getString(CommStrings.INVDETAIL));
                invItem.setInvType(rst.getString(CommStrings.INVTYPE));
                invItem.setInvLocation(rst.getString(CommStrings.INVLOCATION));

                inventoryList.add(invItem);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            DbCom.releaseResources(connection, prepSt, null);
        }
        return inventoryList;
    }
     public String[] selectOptions(String option)
     {
        String [] retOption = new String [2];
        switch (option)
        {
            case "location":
                retOption[0] = Query.INVENTORYSEARCHBYLOCATION;
                retOption[1] = this.getInvLocation()+"%";
                break;
            case "name":
                retOption[0] = Query.INVENTORYSEARCHBYNAME;
                retOption[1] = this.getInvName()+"%";
                break;
            case "type":
                retOption[0] = Query.INVENTORYSEARCHBYTYPE;
                retOption[1] = this.getInvType()+"%";
                break;
            default :
                retOption[0] = Query.INVENTORYCHECK;
                retOption[1] = this.getInvId();
        }
        //System.out.println("sql = "+retOption[0]);
        //System.out.println("placeHolder = "+retOption[1]);
        return retOption;
     }
}