/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcom;

/**
 *
 * @author anamdev
 */
public class Dbd
{
    public static final String DBUSER = "idroc";
    public static final String DBPWD = "idrocadmin";
    public static final String DATABASE = "idroc";
    public static String DBSERVER = "10.138.130.127:3306";
    //public static String DBSERVER = "localhost";
    public static final String DBURL = "jdbc:mysql://"+DBSERVER+"/";
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
}
