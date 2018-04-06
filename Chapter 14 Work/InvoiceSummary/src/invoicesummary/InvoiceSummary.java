/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesummary;

import java.util.function.Function;
import java.util.function.Supplier;
import java.io.*;

/**
 *
 * @author danielcender
 */
public class InvoiceSummary {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Create new instance of Buffered Reader
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        // Input variables
        String customerName = "";
        int customerNbr = 0;
        float subTotal = 0;
        float discountTotal;
        float totalTax = 0;
        float total = 0;
        
        try {
        // Allow customers to input their name, nbr, and invoice total
        System.out.println("Please input a customer's name: ");
       customerName = keyboard.readLine();
        System.out.println("Please input a customer number: ");
        customerNbr = Integer.parseInt(keyboard.readLine());
        System.out.println("Please input an invoice subtotal: ");
        subTotal = Float.parseFloat(keyboard.readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Wrongly formatted input was detected. Exiting program.");
            e.printStackTrace();
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("User input was incorrect.");
            e.printStackTrace();
        }
        
        
        // 1st static Class Level lambda - Discount Limit
        Supplier<Float> discountLimit = () -> 500f;
        // 2nd static class level lambda - Discount Rate
        Supplier<Float> discountRate = () -> .05f;
        // 3rd static class level lambda - Tax Rate
        Supplier<Float> taxRate = () -> .0825f;
        
        // Calculate Amount of discount using class-level lambdas
        Function<Float, Float> calculateDiscount = (Float i) -> i >= discountLimit.get() ? i * discountRate.get(): 0;
        
        // Calculate tax using Function and class level lambda
        Function<Float, Float> calculateTax = (t) -> t * taxRate.get();
        
        // Create lambda that calculates total
        Calculate calculateTotal = (s, d, t) -> (s - d) + t;
        
        // Create lambda to display customer name, number, subtotal, discount, tax, and total
        Invoice displayData = (String n, Integer nbr, Float sub, Float dis, Float tax, Float t) -> {
            System.out.println("Customer Name: " + n);
            System.out.println("Customer Number: " + nbr);
            System.out.println("Invoice Subtotal: " + sub);
            System.out.println("Total Discount: " + dis);
            System.out.println("Tax: " + tax);
            System.out.println("Invoice Total: " + t);
        };
        
        
        // Call lambdas and do calculations
        
        // Get discount
        discountTotal = calculateDiscount.apply(subTotal);
        
        // Calculate Tax on Subtotal minus Discount
        totalTax = calculateTax.apply(subTotal - discountTotal);
        
        // Calculate Total
        total = calculateTotal.calculate(subTotal, discountTotal, totalTax);
        
        // Display Totals
        displayData.display(customerName, customerNbr, subTotal, discountTotal, totalTax, total);
    }
    
    // Functional interface for calculating total
    interface Calculate {
        float calculate(float s, float d, float t);
    }
    // Functional interface for displaying data values
    interface Invoice {
        void display(String n, Integer nbr, Float s, Float dis, Float tax, Float t);
    }
}

