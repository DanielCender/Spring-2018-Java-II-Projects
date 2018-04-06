//  Class: DisplayData.java
//  Author: Gary R. Smith
//  Date Written: 

/*  Abstract:  */

package threadsynchronization;

public class DisplayData extends Thread
{
    Item item;
    
    DisplayData(Item item)
    {
        this.item = item;
    }
        
    public void run()
    {
        System.out.println(getName() + " starting.");
        item.displayData();
        System.out.println(getName() + " ending.");
    }
}