//  Program: WildcardArguments.java
//  Author: Gary R. Smith
//  Date Written: 2/15/2016

/*  Abstract: Demonstrated using wildcard arguments.
*/

package wildcardarguments;

public class WildcardArguments 
{
    //  Main method
    public static void main(String[] args) 
    {
        // Declarations
        NumberObject anInt = new NumberObject <Integer> (-333);
        NumberObject <Float> aFloat = new NumberObject (333.0f);

        //  See if the two values are equal.
        if (anInt.absEqual(aFloat)) 
        { System.out.println("They are equal."); }
        else 
        { System.out.println("They are not equal"); }

        System.out.println();   //  insert a blank line.
        
        //  Declarations
        NumberObject obj1 = new NumberObject ((byte) 120);
        NumberObject obj2 = new NumberObject (-120.0);
        
        //  See if the two values are equal.
        if (obj1.absEqual(obj2)) 
        { System.out.println("They are equal."); }
        else 
        { System.out.println("They are not equal"); }        
    }
}
