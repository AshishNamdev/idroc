/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
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
        }
    }

    public static Connection createConnection() throws SQLException
    {
        Connection connection;
        String conURL = Dbd.DBURL+Dbd.DATABASE+"?user="+Dbd.DBUSER+"&password="+Dbd.DBPWD;
        DbCom.loadDbDriver();
        connection = DriverManager.getConnection(conURL);
        //connection = DriverManager.getConnection(Dbd.DBURL, Dbd.DBUSER, Dbd.DBPWD);
        System.out.println(conURL);
        if(connection==null)
            throw new NullPointerException();
        return connection;
    }

    public static java.sql.Date toSQLDate(String date) throws ParseException
    {
        java.sql.Date sqlDate;
        java.util.Date utilDate;
        long time;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        utilDate = sdf.parse(date);
        time = utilDate.getTime();
        sqlDate = new java.sql.Date(time);
        return sqlDate;
    }


    public static void releaseResources(Connection connection , PreparedStatement prepSt , ResultSet rset)
    {
        try
        {
            if (prepSt != null)
                prepSt.close();
            if (connection != null)
                connection.close();
            if  (rset != null)
                rset.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}