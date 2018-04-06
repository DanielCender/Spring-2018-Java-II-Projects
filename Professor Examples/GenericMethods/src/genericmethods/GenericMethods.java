//  Program: GenericMethods.java
//  Author: Gary R. Smith
//  Date Written: 2/15/2016

/*  Abstract: Demonstrates use of generic methods.
*/

package genericmethods;

public class GenericMethods 
{
    //  Main method
    public static void main(String[] args) 
    {
        // Declarations
        byte abyte = 122;
        short aShort = 111;
        int anInt = 128;
        long aLong = 83838;
        float aFloat = 432.55f;
        double aDouble = 333.44;
        
        //  Do some tests.
        System.out.println(isLowEqualHigh(abyte, aLong));
        System.out.println(isLowEqualHigh(aShort, aDouble));
        System.out.println(isLowEqualHigh(aFloat, anInt));
        System.out.println(isLowEqualHigh(128.0, anInt));
        //  Why doesn't the next line work?
        System.out.println(isLowEqualHigh(aFloat, 432.55));
    }
    
    //  Generic method that accepts two values and determines 
    public static <T extends Number, V extends T> String isLowEqualHigh (T t, V v)
    {
       String str;
       if (("Double".equals(t.getClass().getSimpleName()) && "Float".equals(v.getClass().getSimpleName())) ||
               ("Double".equals(v.getClass().getSimpleName()) && "Float".equals(t.getClass().getSimpleName())))
       {   str = "Comparing Floats to Doubles for equality won't work";
           return str; }
       
       System.out.println(t.getClass().getSimpleName());
       System.out.println(v.getClass().getSimpleName());
       if (t.doubleValue() < v.doubleValue())
           str = t + " is less than " + v;
       else if (t.doubleValue() > v.doubleValue())
           str = t + " is greater than " + v;
       else str = t + " is equal to " + v;
       return str;
    }
}
