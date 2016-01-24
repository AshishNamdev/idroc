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
public class Comments
{
    private String cmtId;
    private String comment;

    public Comments()
    {
        this.cmtId = null;
        this.comment = null;
    }

    public Comments(String cmtId, String comment)
    {
        this.cmtId = cmtId;
        this.comment = comment;
    }

    public String getCmtId()
    {
        return cmtId;
    }

    public void setCmtId(String cmtId)
    {
        this.cmtId = cmtId;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
}