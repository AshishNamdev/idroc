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
public class User
{
    private String uid;
    private String email;
    private String password;
    private String userName;

    public User()
    {
        this.uid = null;
        this.email = null;
        this.password = null;
        this.userName = null;
    }

    public User(String uid, String email, String password, String userName)
    {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.userName = userName;
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

    public void addUSer()
    {
    }
    
    public void deleteUser()
    {
    }
}