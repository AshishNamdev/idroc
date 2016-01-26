/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author anamdev
 */
public class DbCom
{
    public static void loadDbDriver()
    {
        try
        {
            Class.forName(Dbd.DBDRIVER);
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Can not load Driver class : "+cnfe.getMessage());
            cnfe.printStackTrace();
        }
    }

    public static Connection createConnection() throws SQLException
    {
        Connection connection = null;
        String conURL = Dbd.DBURL+Dbd.DATABASE+"?user="+Dbd.DBUSER+"&password="+Dbd.DBPWD;
        DbCom.loadDbDriver();
        connection = DriverManager.getConnection(conURL);
        //connection = DriverManager.getConnection(Dbd.DBURL, Dbd.DBUSER, Dbd.DBPWD);
        System.out.println(conURL);
        if(connection==null)
            throw new NullPointerException();
        return connection;
    }
}