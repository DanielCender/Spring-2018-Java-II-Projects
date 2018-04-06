//  Class: MyThread.java
//  Author: Gary R. Smith
//  Date Written: 1/20/2016

/*  Abstract:  Create a thread that implements the Runnable interface and 
               outputs a series of values.  */

package usingthreads;

public class MyThread implements Runnable 
{
    //  Instance variables
    String threadName;
    int sleepTime;
    
    //  Constructor
    MyThread(String name, int time)
    {
        threadName = name;
        sleepTime = time;
    }
    
    // Thread entry point.
    public void run()
    {
        //  Inidicate the start of the thread.
        System.out.println("Starting " + threadName);
        
        //  Create a loop that outputs a number from 0 to 9.
        for (int x = 0; x < 10; x++) 
        {
            //  Pause the thread based on the value receiveed in the constructor.
            try
            {
                Thread.sleep(sleepTime);
                System.out.println(threadName + " # " + x);
            } 
            catch (InterruptedException err)
            {
                System.out.println("Oops.....");
                err.printStackTrace();
            }
        }
       
        //  Indicate the end of the thread.
        System.out.println("Ending " + threadName);
    }
    
}
