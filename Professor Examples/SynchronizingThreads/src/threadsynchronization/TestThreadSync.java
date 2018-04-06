//  Class: TestThreadSync.java
//  Author: Gary R. Smith
//  Date Written: 1/22/2016

/*  Abstract:  This program demonstrates using synchronized blocks.  */

package threadsynchronization;

public class TestThreadSync 
{
    static Item item = new Item();
    
    //  main method.
    public static void main(String[] args) 
    {
        System.out.println("Starting main thread.");

        //  Create and start the threads.
        EnterItemNumberThread ei = new EnterItemNumberThread(item);
        EnterDescriptionThread ed = new EnterDescriptionThread(item);
        EnterPriceThread ep = new EnterPriceThread(item);
        DisplayData dd = new DisplayData(item);
        
        ei.start();
        ed.start();
        ep.start();
        
        //  Keep looping until the data entry threads are completed.
        while (ei.isAlive() || ed.isAlive() || ep.isAlive())
        {
            System.out.println("Threads still running.");
            try { Thread.sleep(1000); }
            catch (InterruptedException err){}
        }
        dd.start();     //  Start the display thread.
        
        //  Join the threads to the main() thread.
        try 
        {
            System.out.println("Joining threads to main.");
            ei.join();
            ed.join();
            ep.join();
            dd.join();
        }
        catch (InterruptedException err) {}

        System.out.println("End of program.");
    }
}
