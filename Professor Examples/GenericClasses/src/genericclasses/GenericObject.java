//  Class: GenericObject.java
//  Author: Gary R. Smith
//  Date Written: 2/15/2016

/*  Abstract: This program creates a generic class.
*/

package genericclasses;

public class GenericObject <T>
{
    //  Instance variables
    T myObject; //  declares an object of type T
    
	//  Constructor.  Pass reference to object of type T
	GenericObject(T obj) 	{  myObject = obj;  }

	//  Return myObject
	public T getObject() 	{  return myObject;  }

	//  Show the object
	public void showType()  {
            System.out.println("Type of T is " + myObject.getClass().getName());
	}

}
