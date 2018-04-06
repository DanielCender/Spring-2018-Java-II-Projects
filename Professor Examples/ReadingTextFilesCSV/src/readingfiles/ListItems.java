// Program: ListItems.java
// Author: Gary R. Smith
// Date Written: 3/31/2011

/* Abstract: This program reads the items file and displays the data 
   on the monitor.  
*/

package readingfiles;

//  Imports
import java.io.IOException;

public class ListItems
{
    //  Fields
    private static FileItem fileItem = new FileItem();

    //  Main method.
    public static void main(String[] args) throws IOException
    {
        startUp();
        processing();
        shutDown();
    }

    //  Start up processing
    public static void startUp() throws IOException
    {
        //  Open the file.
        fileItem.openRead();
        
        //  If the file did not open, close the program.
        if(!fileItem.isOpen)
        {
            shutDown();
        }

        //  Read the first record.
        fileItem.readRecord();
    }

    //  Main record processing method
    public static void processing() throws IOException
    {
        //  Loops until no more records are present.
        while(!fileItem.isEOF)
        {
            //  Display the items data.
            displayItemLine();
            
            //  Read another record.
            fileItem.readRecord();
        }
    }

    //  Shut down processing
    public static void shutDown() throws IOException
    {
        //  Close files.
        if (fileItem.isOpen)
        {
            fileItem.close();
        }
        
        //  Exit the program.
        System.exit(0);
    }
    
    //  Display the item data.
    public static void displayItemLine()
    {
        //  Display the data.
        System.out.printf("%5d  ", fileItem.data.getItemNumber());
        System.out.printf("%c  ", fileItem.data.getStatus());
        System.out.printf("%-40s  ", fileItem.data.getDescription());
        System.out.printf("%3d  ", fileItem.data.getCategory());
        System.out.printf("%8.2f  ", fileItem.data.getPrice());
        System.out.printf("%8.2f  ", fileItem.data.getCost());
        System.out.printf("%7d  ", fileItem.data.getYtdSalesQty());
        System.out.printf("%10.2f\n", fileItem.data.getYtdSalesAmt());
    }
}