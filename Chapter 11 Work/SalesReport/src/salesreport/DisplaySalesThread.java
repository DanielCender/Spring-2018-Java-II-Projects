/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesreport;

/**
 *
 * @author danielcender
 */
public class DisplaySalesThread implements Runnable {
    String threadName;
    Sales[] sale;
    int count;
    float percentSale;
    float totalSales;
    int totalItems;
    DisplaySalesThread(Sales[] sale) {
       this.sale = sale;
    }
    //Overwrite Run
    public void run() {
    synchronized (sale) {
        // Display data after all info has been entered
        for(int i = 0; i < sale.length; i++) {
            sale[i].displayData();
            percentSale = ((sale[i].getSalesAmt() / totalSales) * 100);
            System.out.println("This item is " + percentSale + "% of total sales.\n");
            totalItems += sale[i].getQuantity();
            totalSales += sale[i].getSalesAmt();
        }
        
        System.out.println("\nTotal Item entries: " + count);
        System.out.println("Total Quantity: " + totalItems);
        System.out.println("Total sale: " + totalSales);
    }
      /*
        for(Sales item : sale) {
          
            if(item.getItemNbr() != 0) {
            item.displayData();
            percentSale = ((item.getSalesAmt() / totalSales) * 100);
            System.out.println("This item is " + percentSale + " percent of total sales.\n");
            totalItems += item.getQuantity();
            count++;
            }
        }
        */
}
}
      
    