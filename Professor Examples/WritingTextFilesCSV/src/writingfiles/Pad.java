//  Program: Pad.java
//  Author: Gary R. Smith
//  Date Written: 6/30/2005

/*  This program sets a string to a specific length  */
package writingfiles;

//  Class Pad
public class Pad
{

    //  Pad Right.  This overloaded method adds spaces to make all fields
    //              displayed the same size.
    //              string s = string to be filled
    //              int l = desired length
    //              Fill character is a space.
    public static String padRight(String s, int l)
    {
        int pad = l - s.length();
        //  Fill spaces to the right of the field.
        for (int i = 0; i <= pad; i++)
        {
            s += " ";
        }
        return s;
    }

    //  Pad Right.  This overloaded method adds spaces to make all fields
    //              displayed the same size.
    //		    string s = string to be filled
    //              int l = desired length
    //              char f = fill character
    public static String padRight(String s, int l, char f)
    {
        int pad = l - s.length();
        //  Fill spaces to the right of the field.
        for (int i = 0; i < pad; i++)
        {
            s += f;
        }
        return s;
    }

    //  Pad Left.  This overloaded method adds spaces to make all fields
    //              displayed the same size.
    //              string s = string to be filled
    //              int l = desired length
    //              Fill character is a space.
    public static String padLeft(String s, int l)
    {
        String work = "";
        int pad = l - s.length();
        //  Fill spaces to the left of the field.
        for (int i = 0; i <= pad; i++)
        {
            work += " ";
        }
        return work += s;
    }

    //  Pad Left.  This overloaded method adds spaces to make all fields
    //              displayed the same size.
    //              string s = string to be filled
    //              int l = desired length
    //              char f = fill character
    public static String padLeft(String s, int l, char f)
    {
        String work = "";
        int pad = (l - s.length()) - 1;
        //  Fill spaces to the left of the field.
        for (int i = 0; i <= pad; i++)
        {
            work += f;
        }
        return work += s;
    }
}
