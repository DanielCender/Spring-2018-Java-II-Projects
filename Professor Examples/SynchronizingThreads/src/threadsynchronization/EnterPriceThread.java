//  Class: EnterPrice.java
//  Author: Gary R. Smith
//  Date Written: 1/22/2016

/*  Abstract:  This thread an item number. */

package threadsynchronization;

// Imports
import javax.swing.JOptionPane;

public class EnterPriceThread extends Thread
{
    Item item;
    
    EnterPriceThread(Item item)
    {
        this.item = item;
    }
   
    public void run()
    {
        System.out.println(getName() + " starting.");
        item.setPrice(inputPrice());
        System.out.println(getName() + " ending.");
    }
    
        
    //  Input the price
    public float inputPrice()
    {
        //  Local variables
        float num = 0;
        
        //  Display an input dialog box.
        String value = JOptionPane.showInputDialog(null,
                "Enter a price - digits only.");

        //  Convert the input string to an integer.  If error, try again.
        try
        {
            num = Float.parseFloat(value);
        }
        catch (Exception err)
        {
            JOptionPane.showMessageDialog(null, "Error parsing data!\n" + 
                    err.getMessage());
            num = inputPrice();      //  This is a recursive call.
        }        
        return num;
    }
    
}
