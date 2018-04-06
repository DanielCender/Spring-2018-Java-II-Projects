//  Class: BlockLambdaExpressions.java
//  Author: Gary R. Smith
//  Date Written: 

/*  Abstract:  */

package blocklambdaexpressions;

public class BlockLambdaExpressions 
{

    //  main method.
    public static void main(String[] args) 
    {
        //  Define an array
        double[] values = {23.4, 54.7, 14.67, 33.25, 8.99, 12.54, 36.78};
        
        // Create a block lambda
        HighestValue hiVal = (double[] v) -> 
        {
            double hi = v[0];
            for(int x = 0; x < v.length - 1; x++)
            {
                hi = hi > v[x+1] ? hi: v[x+1];
            }
            return hi;
        };
        
        //  Display the highest value in the array.
        System.out.println("Highest value is: " + hiVal.highValue(values));
    }
}

//  Functional Interface
interface HighestValue {
    double highValue (double [] vals);
}