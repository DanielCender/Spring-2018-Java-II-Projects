//  Class: GenericFunctionalInterfaces.java
//  Author: Gary R. Smith
//  Date Written: 2/24/2016

/*  Abstract:  Demonstrates using generic functional interfaces. */

package genericfunctionalinterfaces;

public class GenericFunctionalInterfaces 
{

    //  main method.
    public static void main(String[] args) 
    {
        // Create lambdas for different data types;
        TestVal <Integer> testInt = (a, b) -> a > b;
        TestVal <Double> testDouble = (a, b) -> a > b;
        TestVal <String> testString = (a, b) -> a.indexOf(b) != -1;
        
        //  Display results.
        System.out.println(testInt.isGreater(33,44));
        System.out.println(testDouble.isGreater(89.553, 22.73));
        System.out.println(testString.isGreater("Gary", "Bill"));
    }
}

//  Functional Interface
interface TestVal<T> {
    boolean isGreater(T a, T b);
}
