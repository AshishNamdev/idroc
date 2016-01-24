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
public class InvComment
{
    private String inventoryInvID;
    private String commentsCmtID;

    public InvComment()
    {
        this.inventoryInvID = null;
        this.commentsCmtID = null;
    }

    public InvComment(String inventoryInvID, String commentsCmtID)
    {
        this.inventoryInvID = inventoryInvID;
        this.commentsCmtID = commentsCmtID;
    }

    public String getInventoryInvID()
    {
        return inventoryInvID;
    }

    public void setInventoryInvID(String inventoryInvID)
    {
        this.inventoryInvID = inventoryInvID;
    }

    public String getCommentsCmtID()
    {
        return commentsCmtID;
    }

    public void setCommentsCmtID(String commentsCmtID)
    {
        this.commentsCmtID = commentsCmtID;
    }
}
