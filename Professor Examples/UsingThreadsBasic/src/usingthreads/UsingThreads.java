//  Class: UsingThreads.java
//  Author: Gary R. Smith
//  Date Written: 1/20/2016

/*  Abstract:  This program create two concurrent threads.*/

package usingthreads;

public class UsingThreads 
{
    //  main method.
    public static void main(String[] args) 
    {
        //  Indicate the betinnign of the main thread.
        System.out.println("Beginning main thread.");
        
        //  Create an object from MyThread
        MyThread tA = new MyThread("Thread A",1000);
        MyThread tB = new MyThread("Thread B", 500);
        
        //  Create ab instance of a Thread
        Thread newThreadA = new Thread(tA);
        Thread newThreadB = new Thread(tB);
        
        //  Start the threads running
        newThreadA.start();
        newThreadB.start();
        
        //  Wait until both threads end.
        while(newThreadA.isAlive() || newThreadB.isAlive())
        {
            System.out.println("Waiting for the treads to end.");
            try
            {
                Thread.sleep(1000);     // Wait a second
            }
            catch (InterruptedException err)
            {
            }
        }
       
        //  Indicate the end of the main thread.
        System.out.println("End of main thread.");
    }

}
