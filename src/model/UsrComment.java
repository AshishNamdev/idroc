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
public class UsrComment
{
    private String userUID;
    private String commentsCmtID;

    public UsrComment()
    {
        this.userUID = null;
        this.commentsCmtID = null;
    }

    public UsrComment(String userUID, String commentsCmtID)
    {
        this.userUID = userUID;
        this.commentsCmtID = commentsCmtID;
    }

    public String getUserUID()
    {
        return userUID;
    }

    public void setUserUID(String userUID)
    {
        this.userUID = userUID;
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
