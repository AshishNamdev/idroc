/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

/**
 *
 * @author anamdev
 */
public class Query
{
    public static final String USERINSERT = "INSERT INTO user(uid, email , password, f_name, m_name, l_name) values(?,?,?,?,?,?)";
    public static final String USERSELECT = "SELECT uid , f_name ,m_name , l_name from idroc.user where email = ? and password = ? ";
    public static final String USERCHECK  = "SELECT * FROM idroc.user where email = ? ";
    
    public static final String INVENTORYINSERT = "INSERT INTO inventory(inv_id, name , detail, type, location) values(?,?,?,?,?)";
    public static final String INVENTORYCHECK = "SELECT * FROM idroc.inventory where inv_id = ? ";
    public static final String INVENTORYDELETE = "DELETE FROM  idroc.inventory where inv_id = ? ";

    public static final String INVENTORYSEARCHBYLOCATION = "SELECT * FROM  idroc.inventory where location LIKE ? ";
    public static final String INVENTORYSEARCHBYNAME = "SELECT * FROM  idroc.inventory where name LIKE ? ";
    public static final String INVENTORYSEARCHBYTYPE = "SELECT * FROM  idroc.inventory where type LIKE ? ";
}
