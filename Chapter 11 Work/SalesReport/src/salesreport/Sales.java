/*
 * Name: Sales
 * Author: Daniel Cender
 * Date: 2.5.2018
 * Abstract: Sales class for SalesReport program.
 */
package salesreport;

/**
 *
 * @author danielcender
 */
public class Sales {
    // Data Members
    private static int itemNbr;
    private static String description;
    private static int quantity;
    private static float salesAmt;
    
    public Sales() {
        //Default constructor
    }
    // Constructor
    public Sales(int nbr, String descript, int q, float amt) {
        itemNbr = nbr;
        description = descript;
        quantity = q;
        salesAmt = amt;
    }
    
    // Get / Set methods for all data members
    synchronized public void setItemNbr(int number) { itemNbr = number;}
    synchronized public int getItemNbr() { return itemNbr; }
    
    synchronized public void setDescription(String descript) { description = descript; }
    synchronized public String getDescription() { return description; }
    
    synchronized public void setQuantitiy(int q) { quantity = q; }
    synchronized public int getQuantity() { return quantity; }
    
    synchronized public void setSalesAmt(float sales) { salesAmt = sales; }
    synchronized public float getSalesAmt() { return salesAmt; }
    
    //  Method to display all data members to console
    synchronized public void displayData() {
        System.out.println("Item Number: " + getItemNbr());
        System.out.println("Description: " + getDescription());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Sales Amount: " + getSalesAmt());
    }
}
