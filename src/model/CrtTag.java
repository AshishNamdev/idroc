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
public class CrtTag
{
    private String userUID;
    private String tagsTagID;

    public CrtTag()
    {
        this.userUID = null;
        this.tagsTagID = null;
    }

    public CrtTag(String userUID, String tagTagID)
    {
        this.userUID = userUID;
        this.tagsTagID = tagTagID;
    }

    public String getUserUID()
    {
        return userUID;
    }

    public void setUserUID(String userUID)
    {
        this.userUID = userUID;
    }

    public String getTagsTagID()
    {
        return tagsTagID;
    }

    public void setTagsTagID(String tagsTagID)
    {
        this.tagsTagID = tagsTagID;
    }
}