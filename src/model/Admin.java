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
public class Admin
{
    private String userUID;
    private String password;

    public Admin()
    {
        this.userUID = null;
        this.password = null;
    }

    public Admin(String userUID, String password)
    {
        this.userUID = userUID;
        this.password = password;
    }

    public String getUserUID()
    {
        return userUID;
    }

    public void setUserUID(String userUID)
    {
        this.userUID = userUID;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
