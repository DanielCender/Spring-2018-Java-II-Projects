/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifyemployee;
import verifyemployee.FileEmployeeCSV;
import verifyemployee.FileEmployeeBIN;
import java.io.IOException;

/**Name: Verify Employee
 *Date: Jan 24, 2018
 * @author danielcender
 * Abstract: This program will read a binary file and display it back to the console in a byte format.
 */
public class VerifyEmployee {

//  Fields
private static FileEmployeeBIN fileInput = new FileEmployeeBIN();
private static FileEmployeeCSV fileOutput = new FileEmployeeCSV();
private boolean isEOF = false;
// Counters & Totals
private static int recordCount = 0;
private static float ytdGrossEarnTotal = 0;
private static float ytdFedTaxesTotal = 0;
private static float ytdSocSecTaxesTotal = 0;
private static float ytdMedicareTaxesTotal = 0;
private static float ytdStateTaxesTotal = 0;
private static float ytdDeductionsTotal = 0;
    // Main Method

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        startup();
        while (!fileInput.isEOF) {
        processing();
        }
        shutdown();
    }
    
    // Startup

    /**
     *
     * @throws IOException
     */
    public static void startup() throws IOException {
        //  Open the file.
        fileInput.openRead();
        fileOutput.openOutput();
        
        //  If the file did not open, close the program.
        if(!fileInput.isOpen & !fileOutput.isOpen)
        {
            shutdown();
        }

        //  Read the first record.
        displayHeading();
        fileInput.readRecord();
    }
    
    // Processing

    /**
     *
     * @throws IOException
     */
    public static void processing() throws IOException {
         //  Loops until no more records are present.
        while(!fileInput.isEOF)
        {
            // Point output to input object
            fileOutput.data = fileInput.data;
            fileOutput.writeRecord();
            //  Display the items data.
            displayEmployeeData();
            // Add to cound of file records read
            recordCount++;
            // Add data members of record to the totals variables
            addToTotals();
            //  Read another record.
            fileInput.readRecord();
        }
    }
    
    // Shutdown

    /**
     *
     * @throws IOException
     */
    public static void shutdown() throws IOException {
         //  Close files.
        if (fileInput.isOpen)
        {
            // Display Totals here and record counter
            displayTotals();
            fileInput.close();
            fileOutput.close();
        }
        
        //  Exit the program.
        System.exit(0);
    }
    
    /**
     *
     */
    public static void displayHeading() {
        System.out.println("Employee Nbr\tDepartment\tLast Name\tFirst Name\tPay Type\t Hourly Rate\tTax Marital Status\tNbr Exemptions\tState Withhold Percentage\tGross Earnings\tYTD Fed Taxes\tYTD Social Sec. Taxes\tYTD Medicare Taxes\tYTD State Taxes\tYTD Deductions\tDeduct Code 1\t Code 1 Value\tDeduct Code 2\tCode 2 Value\tDeduct Code 3\tCode 3 Value");
    }
    
    // Display the Employee's data

    /**
     *
     */
    public static void displayEmployeeData() {
            System.out.printf("%d\t", fileInput.data.getEmployeeNbr());
            System.out.printf("%d\t", fileInput.data.getDepartmentNbr());
            System.out.printf("%s\t", fileInput.data.getLastName());
            System.out.printf("%s\t", fileInput.data.getFirstName());
            System.out.printf("%c\t", fileInput.data.getPayType());
            System.out.printf("%f.2\t", fileInput.data.getHourlyRate());
            System.out.printf("%c\t", fileInput.data.getTaxMaritalStatus());
            System.out.printf("%d\t", fileInput.data.getNbrExemptions());
            System.out.printf("%.4f\t", fileInput.data.getStateWithholdingPercentage());
            System.out.printf("%.2f\t", fileInput.data.getYtdGrossEarnings());
            System.out.printf("%.2f\t", fileInput.data.getYtdFederalTaxes());
            System.out.printf("%.2f\t", fileInput.data.getYtdSocialSecurityTaxes());
            System.out.printf("%.2f\t", fileInput.data.getYtdMedicareTaxes());
            System.out.printf("%.2f\t", fileInput.data.getYtdStateTaxes());
            System.out.printf("%.2f\t", fileInput.data.getYtdDeductions());
            for(int x=0; x < 3; x++)
            {
                System.out.printf("Deduction %d code: %c\t", x, fileInput.data.getDeductionCode(x));
                System.out.printf("Deduction %d value: %.4f\t", x, fileInput.data.getDeductionValue(x));
            }
            System.out.println();
    }
    
    public static void addToTotals() {
        ytdGrossEarnTotal += fileInput.data.getYtdGrossEarnings();
        ytdFedTaxesTotal += fileInput.data.getYtdFederalTaxes();
        ytdSocSecTaxesTotal += fileInput.data.getYtdSocialSecurityTaxes();
        ytdMedicareTaxesTotal += fileInput.data.getYtdMedicareTaxes();
        ytdStateTaxesTotal += fileInput.data.getYtdStateTaxes();
        for(int x=0; x < 3; x++)
            {
              ytdDeductionsTotal += fileInput.data.getDeductionValue(x);
            }
    }
    
    public static void displayTotals() {
        System.out.println("YTD Gross Earnings Total: \t" + ytdGrossEarnTotal);
        System.out.println("YTD Federal Taxes Total: \t" + ytdFedTaxesTotal);
        System.out.println("YTD Social Security Taxes Total: \t" + ytdSocSecTaxesTotal);
        System.out.println("YTD Medicare Taxes Total: \t" + ytdMedicareTaxesTotal);
        System.out.println("YTD State Taxes Total: \t" + ytdStateTaxesTotal);
        System.out.println("YTD Deductions total: \t" + ytdDeductionsTotal + "\n");
        System.out.println("Total Records Read: \t" + recordCount);
    }
}
