/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import comms.CommStrings;
import dbcom.DbCom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anamdev
 */
public class User
{
    private String uid;
    private String email;
    private String password;
    private String userName;
    private String fName;
    private String mName;
    private String lName;

    public User()
    {
        this.uid = null;
        this.email = null;
        this.password = null;
        this.fName = null;
        this.mName = null;
        this.lName = null;
        this.userName = null;
    }

    public User(String uid, String email, String password, String fName, String mName , String lName)
    {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.userName = fName + mName + lName;
    }

    public String getUid()
    {
        return uid;}

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public void setmName(String mName)
    {
        this.mName = mName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }
    
    public String getfName()
    {
        return fName;
    }

    public String getmName()
    {
        return mName;
    }

    public String getlName()
    {
        return lName;
    }
    
    public boolean addUSer()
    {
        boolean ret = false;
        String query = null;
        Connection connection = null;
        PreparedStatement prepSt = null;
        try
        {
            connection = DbCom.createConnection();
            query = "insert into user(uid, email , password, f_name, m_name, l_name)"
                    + " values(?,?,?,?,?,?)";
            prepSt = connection.prepareStatement(query);
            prepSt.setString(1, this.getUid());
            prepSt.setString(2, this.getEmail());
            prepSt.setString(3, this.getPassword());
            prepSt.setString(4, this.getfName());
            prepSt.setString(5, this.getmName());
            prepSt.setString(6, this.getlName());
            
            if(prepSt.executeUpdate() > 0)
                ret = true;
            connection.commit();
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

    public boolean loginUser(boolean isLogin)
    {
        boolean ret = false;
        Connection connection = null;
        PreparedStatement prepSt = null;
        ResultSet rst = null;
        String sql = null;
        if (isLogin)
            sql = "Select uid , f_name ,m_name , l_name from idroc.user where email = ? and password = ? ";
        else
            sql = "Select * from idroc.user where email = ? ";

        try
        {
            connection = DbCom.createConnection();
            prepSt = connection.prepareStatement(sql);
            prepSt.setString(1,this.getEmail());

            if (isLogin)
            {
                prepSt.setString(2,this.getPassword());
                rst = prepSt.executeQuery();
                if(rst.next())
                {
                    this.setUid(rst.getString(CommStrings.UID));
                    this.setfName(rst.getString(CommStrings.FNAME));
                    this.setlName(rst.getString(CommStrings.LNAME));
                    
                    String mTemp = rst.getString(CommStrings.MNAME);
                    this.setmName( (mTemp == null ) ? " " : mTemp);
                    
                    this.setUserName(this.getfName()+" "+this.getmName()+" "+this.getlName());
                    ret = true;
                }
            }
            else
            {
                rst = prepSt.executeQuery();
                if(rst.next())
                    ret = true;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            DbCom.releaseResources(connection, prepSt, rst);
        }
        return ret;
    }
}