//  Class: VariableCapture.java
//  Author: Gary R. Smith
//  Date Written: 2/26/2016

/*  Abstract:  Demonstrates variable capture in lambda expressions.  */

package variablecapture;

public class VariableCapture 
{
    //  main method.
    public static void main(String[] args) 
    {
        // Define a local variable.
        int anInt = 25;
        
        //  Define a lambda expression.
        MyFunc timesTen = (n)-> n * 10 + anInt;
        
        //  Display the value
        System.out.println(timesTen.funct(13));
    }
}

//  Functional interface
interface MyFunc {
        int funct(int n);
}