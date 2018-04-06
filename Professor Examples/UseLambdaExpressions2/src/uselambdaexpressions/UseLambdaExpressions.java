//  Class: UseLambdaExpressions.java
//  Author: Gary R. Smith
//  Date Written: 2/24/2016

/*  Abstract:  Demonstrates use of lambda expressions.  */

package uselambdaexpressions;

public class UseLambdaExpressions 
{
    //  main method.
    public static void main(String[] args) 
    {
        // Create Lambdas for each of the 4 math functions
        MathOperation addition = (a,  b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = ( a,  b) -> a * b;
        MathOperation division = (a,  b) -> a / b;
        
        //  Display the results of the 4 operations
        System.out.println("Addition: " + addition.fx(3, 10));
        System.out.println("Subtraction: " + subtraction.fx(4, 18));
        System.out.println("Multiplication: " + multiplication.fx(21,5));
        System.out.println("Division: " + division.fx(13,5));
    }
}

//  Functional Interface
interface MathOperation {
    double fx(double a, double b);
}

