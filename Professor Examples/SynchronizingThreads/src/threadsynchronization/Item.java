//  Class: Item.java
//  Author: Gary R. Smith
//  Date Written: 1/22/2016

/*  Abstract:  Defines an item class. */

package threadsynchronization;

public class Item
{
    //  Instance variables
    int itemNumber;
    String description;
    float price;
    
    //  Assessor/Mutator methods
    synchronized public int getItemNumber() { return itemNumber; }
    synchronized public void setItemNumber(int value) { itemNumber = value; }
    
    synchronized public String getDescription() { return description; }
    synchronized public void setDescription(String value) { description = value; }
    
    synchronized public float getPrice() { return price; }
    synchronized public void setPrice(float value) { price = value; }
    
    //  displayData method
    synchronized public void displayData()
    {
        System.out.println("Item number: " + getItemNumber());
        System.out.println("Description: " + getDescription());
        System.out.println("Price: " + getPrice());
        System.out.println();
    }
}