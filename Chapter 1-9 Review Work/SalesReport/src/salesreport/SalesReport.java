/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesreport;

import salesreport.Sales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Name: Sales Report
 * @Date: 1/19/2018
 * @author danielcender 
 * @Description: This program will generate a report of sold
 * items based on user-inputted data.
 */
public class SalesReport {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int entries = 0;
        int totalItems = 0;
        float totalSales = 0;
        int count = 0;
        int itemNum;
        String description;
        int quantity;
        float salesAmt;
        char ans;
        int arrayMax = 0;
        float percentSale;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //  Instantiate array with max amount of slots
        Sales[] items = new Sales[100];

        
        //  Begin try block
        try {
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
                totalItems += items[count].getQuantity();
                count++;
                entries++;
                totalSales += salesAmt;
                
                
                //Zero out all values
                itemNum = 0;
                description = "";
                quantity = 0;
                salesAmt = 0;
                
                //  Prompt the user for another item entry
                System.out.println("Enter another item? Y or N. (" + entries + ") currently entered. ");
                ans = (char) reader.read();
                String full = reader.readLine();
            } while((ans == 'Y') & (count < 100));
        } catch (IOException exc) {
                System.out.println("You entered an invalid response. Please try again.");
            }
        catch (NumberFormatException e) {
                  System.out.println("Error occured here.");
                  e.printStackTrace();
              }

        // Display data after all info has been entered
        for(int i = 0; i < count; i++) {
            items[i].displayData();
            percentSale = ((items[i].getSalesAmt() / totalSales) * 100);
            System.out.println("This item is " + percentSale + "% of total sales.\n");
        }
        System.out.println("\nTotal Item entries: " + entries);
        System.out.println("Total Quantity: " + totalItems);
        System.out.println("Total sale: " + totalSales);
    }
}