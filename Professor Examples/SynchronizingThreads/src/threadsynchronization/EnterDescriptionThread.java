//  Class: EnterItemNumber.java
//  Author: Gary R. Smith
//  Date Written: 1/22/2016

/*  Abstract:  This thread an item number. */

package threadsynchronization;

// Imports
import javax.swing.JOptionPane;

public class EnterDescriptionThread extends Thread
{
    Item item;
    
    EnterDescriptionThread(Item item)
    {
        this.item = item;
    }
   
    public void run()
    {
        System.out.println(getName() + " starting.");
        item.setDescription(inputDescription());
        System.out.println(getName() + " ending.");
    }
        
    //  Input the description
    public String inputDescription()
    {
        //  Display an input dialog box.
        String value = JOptionPane.showInputDialog(null,
                "Enter a description.");
        return value;
    }
}
