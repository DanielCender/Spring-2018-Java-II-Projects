//  Class: EnterItemNumber.java
//  Author: Gary R. Smith
//  Date Written: 1/22/2016

/*  Abstract:  This thread an item number. */

package threadsynchronization;

// Imports
import javax.swing.JOptionPane;

public class EnterItemNumberThread extends Thread
{
    Item item;
    
    EnterItemNumberThread(Item item)
    {
        this.item = item;
    }
   
    public void run()
    {
        System.out.println(getName() + " starting.");
        item.setItemNumber(inputItemNumber());
        System.out.println(getName() + " ending.");
    }
    
        //  Input item number
    public int inputItemNumber()
    {
        //  Local variables
        int num = 0;
        
        //  Display an input dialog box.
        String value = JOptionPane.showInputDialog(null,
                "Enter an item number - digits only.");
        
        //  Convert the input string to an integer.  If error, try again.
        try
        {
            num = Integer.parseInt(value);
        }
        catch (Exception err)
        {
            JOptionPane.showMessageDialog(null, "Error parsing data!\n" + 
                    err.getMessage());
            num = inputItemNumber();      //  This is a recursive call.
        }
        return num;             
    }
}