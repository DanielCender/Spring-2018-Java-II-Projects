//  Program: Item.java
//  Date Written: 10/31/2009
//  Author: Gary R. Smith

/*  This program defines a Item object.
 */
package readingfiles;

public class Item
{

    //  Instance Fields
    private int itemNumber;
    private char status;
    private int category;
    private String description;
    private boolean hasDiscount;
    private float price;
    private float cost;
    private int qtyOnHand;
    private int qtyOnOrder;
    private int ytdSalesQty;
    private double ytdSalesAmt;

    //  Default contstructor.
    public Item()
    {
        //  Set default values
        initialize();
    }

    //  Constructor that receives an iput line from a file read operation.
    public Item(String inputLine)
    {
        initialize();
        parseCSV(inputLine);
    }

    //  Assessor/Mutator Methods
    //  Item Number
    public void setItemNumber(int value)
    {
        itemNumber = value;
    }

    public int getItemNumber()
    {
        return itemNumber;
    }

    //  Status
    public void setStatus(char value)
    {
        status = value;
    }

    public char getStatus()
    {
        return status;
    }

    //  Category
    public void setCategory(int value)
    {
        category = value;
    }

    public int getCategory()
    {
        return category;
    }

    //  Description
    public void setDescription(String value)
    {
        description = value;
    }

    public String getDescription()
    {
        return description;
    }

    //  Has Discount
    public void setHasDiscount(boolean value)
    {
        hasDiscount = value;
    }

    public boolean getHasDiscount()
    {
        return hasDiscount;
    }

    //  Price
    public void setPrice(float value)
    {
        price = value;
    }

    public float getPrice()
    {
        return price;
    }

    //  Cost
    public void setCost(float value)
    {
        cost = value;
    }

    public float getCost()
    {
        return cost;
    }

    //  Year-to-Date Sales Quantity
    public void setYtdSalesQty(int value)
    {
        ytdSalesQty = value;
    }

    public int getYtdSalesQty()
    {
        return ytdSalesQty;
    }

    //  Quantity On Hand
    public void setQtyOnHand(int value)
    {
        qtyOnHand = value;
    }

    public int getQtyOnHand()
    {
        return qtyOnHand;
    }

    //  Quantity On Hand
    public void setQtyOnOrder(int value)
    {
        qtyOnOrder = value;
    }

    public int getQtyOnOrder()
    {
        return qtyOnOrder;
    }

    //  Year-to-Date Sales Amount
    public void setYtdSalesAmt(double value)
    {
        ytdSalesAmt = value;
    }

    public double getYtdSalesAmt()
    {
        return ytdSalesAmt;
    }

    //  Populate Items Record Fields from an input line.
    public boolean parseCSV(String inputLine)
    {
        //  Declare Variables.
        boolean success = false;
        String[] splitFields;
        splitFields = inputLine.split(",");

        //  Extract the fields from the input line.
        try
        {
            itemNumber = Integer.parseInt(splitFields[0]);
            status = splitFields[1].charAt(0);
            category = Integer.parseInt(splitFields[2]);
            description = splitFields[3];
            hasDiscount = Boolean.parseBoolean(splitFields[4]);
            price = Float.parseFloat(splitFields[5]);
            cost = Float.parseFloat(splitFields[6]);
            qtyOnHand = Integer.parseInt(splitFields[7]);
            qtyOnOrder = Integer.parseInt(splitFields[8]);
            ytdSalesQty = Integer.parseInt(splitFields[9]);
            ytdSalesAmt = Double.parseDouble(splitFields[10]);
            success = true;
        } catch (Exception err)
        {
            System.out.println("Error parsing data - Item.");
            System.out.println(err.getMessage());
            err.printStackTrace();
        }
        return success;
    }

    //  Display Data Method - displays all data in the class
    public void displayData()
    {
        System.out.println("Item number:   " + itemNumber);
        System.out.println("Status:        " + status);
        System.out.println("Category:      " + category);
        System.out.println("Description:   " + description);
        System.out.println("Has Discount:  " + hasDiscount);
        System.out.println("Price:         " + price);
        System.out.println("Cost:          " + cost);
        System.out.println("Qty on hand:   " + qtyOnHand);
        System.out.println("Qty on order:  " + qtyOnOrder);
        System.out.println("YTD Sales Qty: " + ytdSalesQty);
        System.out.println("YTD Sales Amt: " + ytdSalesAmt);
        System.out.println();
    }

    //  Initialized the instance fields.
    public void initialize()
    {
        //  Initialize all values.
        itemNumber = 0;
        status = 'A';
        category = 0;
        description = "";
        hasDiscount = false;
        price = 0.0f;
        cost = 0.0f;
        qtyOnHand = 0;
        qtyOnOrder = 0;
        ytdSalesQty = 0;
        ytdSalesAmt = 0.0;
    }
}
