//  Program: BoundedTypes.java
//  Author: Gary R. Smith
//  Date Written: 2/15/2016

/*  Abstract: Create bounded class type
*/

package boundedtypes;


public class BoundedTypes 
{
    //  Main method
    public static void main(String[] args) 
    {
        // Create a Float type
        NumObject <Float> aFloat = new NumObject (-12.33f);
        aFloat.showType();
        System.out.println(aFloat.getSquare());
        System.out.println(aFloat.getSquareRoot());
        System.out.println(aFloat.getAbsoluteValue());
        
        // Create an Integer type - note the missing <Integer>.
        NumObject anInteger = new NumObject(33);
        anInteger.showType();
        System.out.println(anInteger.getSquare());
        System.out.println(anInteger.getSquareRoot());
        System.out.println(anInteger.getAbsoluteValue()); 
        
        //  Try to create a String type
        NumObject <String> aString = new NumObject("Gary");
    }
}
