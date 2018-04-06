//  Class: UselambdaExpressions1.java
//  Author: Gary R. Smith
//  Date Written: 2/24/2016 

/*  Abstract:  Creates a simple lambda expression.  */

package uselambdaexpressions1;

public class UselambdaExpressions1 
{
    //  main method.
    public static void main(String[] args) 
    {
        // Create some days of the week.
        DisplayDay today;
        
        today = (day) -> System.out.println("Today is " + day);
        today.showDay("Monday");
        today.showDay("Wednesday");
        
        today = day -> System.out.println("Today is " + day);
        today.showDay("Saturday");
    }
}

//  Functional interface
interface DisplayDay {
    void showDay(String message);
}
