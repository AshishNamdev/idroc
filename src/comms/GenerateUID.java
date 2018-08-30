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
public class GenerateUID
{
    public static String UID(String email)
    {
        String UID = null;
        int MAXINDEX  = 6;
        //String[]  sepString = email.split(".");
        //System.out.println(sepString.length);
        String first = email.substring(0,email.indexOf("."));
        String second = email.substring(email.indexOf(".")+1,email.indexOf("@"));
        System.out.println(first);
        System.out.println(second);
        if (second.length() >= first.length() && second.length() > MAXINDEX)
            UID = first.charAt(0) + second.substring(0, MAXINDEX);
        else if (first.length() >= MAXINDEX)
            UID = first.substring(0, MAXINDEX) + second.charAt(0);
        else
            UID = first + second.charAt(0);
        return UID;
    }
}
