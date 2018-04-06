/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesreport;

/**@Name: Sales Class
 *@Date: 1/19/2018
 * @author danielcender
 * @Description: This is the class outlining the data members and methods of the Sales class for Sales Report.
 */
public class Sales {
    //  Declaring all data members needed
    private int itemNum;
    private String description = "";
    private int quantity;
    private float salesAmt;

    //  Constructor accepting all data fields
    Sales(int itemNum, String description, int quantity, float salesAmt) {
         this.itemNum = itemNum;
        this.description = description;
        this.quantity = quantity;
        this.salesAmt = salesAmt;
    }
    
    // Get/Set Item Num
    public int getItemNum() {
        return itemNum;
    }
    public void setItemNum(int num) {
        itemNum = num;
    }
    
    // Get/Set Item Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Get/Set Item Quantity
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int num) {
        quantity = num;
    }
    
    //  Get/Set Sales Amt
    public float getSalesAmt() {
        return salesAmt;
    }
    public void setSalesAmt(float sale) {
        salesAmt = sale;
    }
    
    //  Method to display all data members to console
    public void displayData() {
        System.out.println("Item Number: " + itemNum);
        System.out.println("Description: " + description);
        System.out.println("Quantity: " + quantity);
        System.out.println("Sales Amount: " + salesAmt);
    }
}
