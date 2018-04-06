//  Class: NumberObject.java
//  Author: Gary R. Smith
//  Date Written: 2/15/2016

/*  Abstract: Creates a generic number class.
*/

package wildcardarguments;

public class NumberObject <T extends Number>
{
    //  Instance variables.
    T aNumber;
    
    //  Constructor
    NumberObject(T n)  
    {   aNumber = n; 
        getType();
    }
    
    //  See if the absolute vavlues are equal.
    public boolean absEqual(NumberObject <?> numObj)   // ? is a wildcard 
    {  
        if (Math.abs(aNumber.doubleValue()) == 
                Math.abs(numObj.aNumber.doubleValue()))
            {  return true; }
    return false;
    }
    
    
    //  Display the type
    public void getType()
    {
        System.out.println(aNumber.getClass().getTypeName());
    }
}
