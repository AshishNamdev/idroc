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
public class Transition
{
    private String trid;
    private String dpid;
    private String prev;
    private String next;

    public Transition()
    {
        this.trid = null;
        this.dpid = null;
        this.prev = null;
        this.next = null;
    }

    public Transition(String trid, String dpid, String prev, String next)
    {
        this.trid = trid;
        this.dpid = dpid;
        this.prev = prev;
        this.next = next;
    }

    public String getTrid()
    {
        return trid;
    }

    public void setTrid(String trid)
    {
        this.trid = trid;
    }

    public String getDpid()
    {
        return dpid;
    }

    public void setDpid(String dpid)
    {
        this.dpid = dpid;
    }

    public String getPrev()
    {
        return prev;
    }

    public void setPrev(String prev)
    {
        this.prev = prev;
    }

    public String getNext()
    {
        return next;
    }

    public void setNext(String next)
    {
        this.next = next;
    }
}