//  Class: NumObject.java
//  Author: Gary R. Smith
//  Date Written: 2/15/2016

/*  Abstract: Defines a generic number object
*/

package boundedtypes;

public class NumObject <T extends Number>
{
    //  Instance variables
    T num;
    
    // Constructor
    NumObject(T n)
    {  num = n;  }
    
    //  Returns the number squared
    public double getSquare()
    { return num.doubleValue() * num.doubleValue(); }
    
    //  Returns the square root of the number
    public double getSquareRoot()
    { return Math.sqrt(num.doubleValue());}
    
    //  Returns the absoute value of the number
    public double getAbsoluteValue()
    { return Math.abs(num.doubleValue()); }

    //  Show the object
    public void showType()  
    { System.out.println("\nType of T is " + num.getClass().getName()); }

}
