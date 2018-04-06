/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesreport;
import java.io.BufferedReader;
import salesreport.Sales;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author danielcender
 */
public class EnterSalesThread implements Runnable {
    String threadName;
    Sales[] sale;
    int count = 0;
    //Overwrite constructor
    EnterSalesThread(Sales[] sale) {
        this.sale = sale;
    }
    
    //Overwrite run
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        synchronized (sale) {
            try {
            int entries = 0;
        int itemNum;
        String description;
        int quantity;
        float salesAmt;
        char ans;
        float percentSale;
            //  Loop until all items are entered properly
            do {
                
                //  Instantiate new Sales obj in the items array for each entry
                sale[count] = new Sales();
                System.out.println("Enter an item number:");
                sale[count].setItemNbr(Integer.parseInt(reader.readLine()));
                System.out.println("Enter the item's description: ");
                sale[count].setDescription(reader.readLine());
                System.out.println("Enter the quantity: ");
                sale[count].setQuantitiy(Integer.parseInt(reader.readLine()));
                System.out.println("Enter the sale amount: ");
                sale[count].setSalesAmt(Float.parseFloat(reader.readLine()));
                System.out.println();
                // Increment counter for next pass
                count++;
                
                
                //Zero out all values
                itemNum = 0;
                description = "";
                quantity = 0;
                salesAmt = 0;
                
                //  Prompt the user for another item entry
                System.out.println("Enter another item? Y or N.");
                ans = (char) reader.read();
                String full = reader.readLine();
            } while((ans == 'Y') & (count < 100));
        }
         catch (IOException exc) {
                System.out.println("You entered an invalid response. Please try again.");
            }
        catch (NumberFormatException e) {
                  System.out.println("Error occured here.");
                  e.printStackTrace();
            
        }
        }
    }
    
    /*// Method 
    public void getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int entries = 0;
        int itemNum;
        String description;
        int quantity;
        float salesAmt;
        char ans;
        float percentSale;
        synchronized (items) {
            //  Loop until all items are entered properly
            do {
                System.out.println("Enter an item number:");
                itemNum = Integer.parseInt(reader.readLine());
                System.out.println("Enter the item's description: ");
                description = reader.readLine();
                System.out.println("Enter the quantity: ");
                quantity = Integer.parseInt(reader.readLine());
                System.out.println("Enter the sale amount: ");
                salesAmt = Float.parseFloat(reader.readLine());
                System.out.println();
                
                //  Instantiate new Sales obj in the items array for each entry
                items[count] = new Sales(itemNum, description, quantity, salesAmt);
                count++;
                
                
                //Zero out all values
                itemNum = 0;
                description = "";
                quantity = 0;
                salesAmt = 0;
                
                //  Prompt the user for another item entry
                System.out.println("Enter another item? Y or N.");
                ans = (char) reader.read();
                String full = reader.readLine();
            } while((ans == 'Y') & (count < 100));
        }
        } catch (IOException exc) {
                System.out.println("You entered an invalid response. Please try again.");
            }
        catch (NumberFormatException e) {
                  System.out.println("Error occured here.");
                  e.printStackTrace();
              }
    }
*/
}

