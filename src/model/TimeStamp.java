/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Date;
/**
 *
 * @author anamdev
 */
public class TimeStamp
{
    private String tmpid;
    private Date create_time;
    private Date update_time;

    public TimeStamp()
    {
        this.tmpid = null;
        this.create_time = null;
        this.update_time = null;
    }

    public TimeStamp(String tmpid, Date create_time, Date update_time)
    {
        this.tmpid = tmpid;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public String getTmpid()
    {
        return tmpid;
    }

    public void setTmpid(String tmpid)
    {
        this.tmpid = tmpid;
    }

    public Date getCreate_time()
    {
        return create_time;
    }

    public void setCreate_time(Date create_time)
    {
        this.create_time = create_time;
    }

    public Date getUpdate_time()
    {
        return update_time;
    }

    public void setUpdate_time(Date update_time)
    {
        this.update_time = update_time;
    }
}