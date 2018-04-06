//  Program: GenericClasses.java
//  Author: Gary R. Smith
//  Date Written: 2/15/2016

/*  Abstract: Createw different instances of a generic class.
*/

package genericclasses;


public class GenericClasses 
{
    //  Main method
    public static void main(String[] args) 
    {
        // Create a String object.
        GenericObject <String> myString = new GenericObject("Gary");
        System.out.println(myString.getObject());
        myString.showType();
        
        //  Create a Float object.
        GenericObject <Float> myFloat = new GenericObject(23.33f);
        System.out.println("\n" + myFloat.getObject());
        myFloat.showType();
        
        //  Create a Boolean object.
        GenericObject <Boolean> myBoolean = new GenericObject(true);
        System.out.println("\n" + myBoolean.getObject());
        myBoolean.showType();        
    }
}
