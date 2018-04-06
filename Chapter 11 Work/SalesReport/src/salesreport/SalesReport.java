/*
 * Name: Sales Report
 * Author: Daniel Cender
 * Date: 2.5.2018
 * Abstract: This is a program that utilizes multithreading capabilities to generate a sales report.
 */
package salesreport;

/**
 *
 * @author danielcender
 */
public class SalesReport {
    /**
     * @param args the command line arguments
     */
    static Sales[] sale = new Sales[100];
    public static void main(String[] args) {
        // Create and start the threads
        EnterSalesThread es = new EnterSalesThread(sale);
        DisplaySalesThread ds = new DisplaySalesThread(sale);
        Thread inputThread = new Thread(es);
        Thread displayThread = new Thread(ds);
        inputThread.start();
        
        while (inputThread.isAlive())  {
            try { Thread.sleep(1000); }
            catch (InterruptedException err){}
    }
        displayThread.start();
        try {
            //join threads to main
            inputThread.join();
            displayThread.join();
            
        } catch (InterruptedException err) {
            System.out.println("End of program.");
        }
}
}