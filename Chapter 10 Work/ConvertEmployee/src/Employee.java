//  Class: Employee.java
//  Author: Gary R. Smith
//  Date Written: 1/27/2015

/*  Abstract:  This class defines an Employee object. */

public class Employee
{
        //  Employee Master File Fields
        private int employeeNbr;
        private short departmenttNbr;
        private String lastName;
        private String firstName;
        private char payType;
        private float hourlyRate;
        private char taxMaritalStatus;
        private byte nbrExemptions;
        private float stateWithholdingPercentage;
        private double ytdGrossEarnings;
        private double ytdFederalTaxes;
        private double ytdSocialSecurityTaxes;
        private double ytdMedicareTaxes;
        private double ytdStateTaxes;
        private double ytdDeductions;
        private char[] deductionCodes = new char[3];
        private float[] deductionValues = new float[3];   //  amount or percent
        
        //  Constructor for file operations.
        public Employee(String inputLine)
        {
            parseCSV(inputLine);
        }
        
        //  Assessor/Mutator methods
        public int getEmployeeNbr()                 { return employeeNbr; }
        public void setEmployeeNbr(int value)       { employeeNbr = value; }
        
        public short getDepartmentNbr()             { return departmenttNbr; }
        public void setDepartmentNbr(short value)   { departmenttNbr = value; }
        
        public String getLastName()                 { return lastName; }
        public void setLastName(String value)       { lastName = value; }

        public String getFirstName()                { return firstName; }
        public void setFirstName(String value)      { firstName = value; }

        public char getPayType()                    { return payType; }
        public void setPayType(char value)          { payType = value; }

        public float getHourlyRate()                { return hourlyRate; }
        public void setHourlyRate(float value)      { hourlyRate = value; }

        public char getTaxMaritalStatus()           { return taxMaritalStatus; }
        public void setTaxMaritalStatus(char value) { taxMaritalStatus = value; }

        public byte getNbrExemptions()              { return nbrExemptions; }
        public void setNbrExemptions(byte value)    { nbrExemptions = value; }

        public float getStateWithholdingPercentage()
        { return stateWithholdingPercentage; }
        public void setStateWithholdingPercentage(float value)
        { stateWithholdingPercentage = value; }

        public double getYtdGrossEarnings()             { return ytdGrossEarnings; }
        public void setYtdGrossEarnings(double value)   { ytdGrossEarnings = value; }

        public double getYtdFederalTaxes()              { return ytdFederalTaxes; }
        public void setYtdFederalTaxes(double value)    { ytdFederalTaxes = value; }

        public double getYtdSocialSecurityTaxes()           { return ytdSocialSecurityTaxes; }
        public void setYtdSocialSecurityTaxes(double value) { ytdSocialSecurityTaxes = value; }

        public double getYtdMedicareTaxes()             { return ytdMedicareTaxes; }
        public void setYtdMedicareTaxes(double value)   { ytdMedicareTaxes = value; }

        public double getYtdStateTaxes()                { return ytdStateTaxes; }
        public void setYtdStateTaxes(double value)      { ytdStateTaxes = value; }

        public double getYtdDeductions()                { return ytdDeductions; }
        public void setYtdDeductions(double value)      { ytdDeductions = value; }
        
        public char getDeductionCode(int dedNbr)
        { return deductionCodes[dedNbr]; }
        public void setDedeductionCode(int dedNbr, char value)
        { deductionCodes[dedNbr] = value; }
        
        public float getDeductionValue(int dedNbr)
        { return deductionValues[dedNbr]; }
        public void setDeductionCode(int dedNbr, float value)
        { deductionValues[dedNbr] = value; }

        //  DisplayData method.  Displays all data
        public void displayData()
        {
            System.out.println("Dump of Employee class.\n");
            System.out.printf("Employee #: %d\n", getEmployeeNbr());
            System.out.printf("Department: %d\n", getDepartmentNbr());
            System.out.printf("Last name: %s\n", getLastName());
            System.out.printf("First name: %s\n", getFirstName());
            System.out.printf("Pay type: %c\n", getPayType());
            System.out.printf("Hourly rate: %f.2\n", getHourlyRate());
            System.out.printf("Tax marital status: %c\n", getTaxMaritalStatus());
            System.out.printf("Number exemptions: %d\n", getNbrExemptions());
            System.out.printf("State Withholding Percentage: %.4f\n", getStateWithholdingPercentage());
            System.out.printf("YTD Gross Earnings: %.2f\n", getYtdGrossEarnings());
            System.out.printf("YTD Federal Taxes: %.2f\n", getYtdFederalTaxes());
            System.out.printf("YTD Social Security Taxes: %.2f\n", getYtdSocialSecurityTaxes());
            System.out.printf("YTD Medicare Taxes: %.2f\n", getYtdMedicareTaxes());
            System.out.printf("YTD State Taxes: %.2f\n", getYtdStateTaxes());
            System.out.printf("YTD Deductions: %.2f\n", getYtdDeductions());
            for(int x=0; x < deductionCodes.length; x++)
            {
                System.out.printf("Deduction %d code: %c\n", x, getDeductionCode(x));
                System.out.printf("Deduction %d value: %.4f\n", x, getDeductionValue(x));
            }
        }
        
        //  Parse method.  Parses a record from a CSV text file.
        public boolean parseCSV(String inputLine)
        {
            //  Declarations
            boolean isSuccessful = false;
            String[] splitFields;
            
            //  Split the inputLine into array elements.
            splitFields = inputLine.split(",");
            
            //  Comvert each element to its respective instance variable.
            try
            {
                employeeNbr = Integer.parseInt(splitFields[0]);
                departmenttNbr = Short.parseShort(splitFields[1]);
                lastName = splitFields[2];
                firstName = splitFields[3];
                payType = splitFields[4].charAt(0);
                hourlyRate = Float.parseFloat(splitFields[5]);
                taxMaritalStatus = splitFields[6].charAt(0);
                nbrExemptions = Byte.parseByte(splitFields[7]);
                stateWithholdingPercentage = Float.parseFloat(splitFields[8]);
                ytdGrossEarnings = Double.parseDouble(splitFields[9]);
                ytdFederalTaxes = Double.parseDouble(splitFields[10]);
                ytdSocialSecurityTaxes = Double.parseDouble(splitFields[11]);
                ytdMedicareTaxes = Double.parseDouble(splitFields[12]);
                ytdStateTaxes = Double.parseDouble(splitFields[13]);
                ytdDeductions = Double.parseDouble(splitFields[14]);
                deductionCodes[0] = splitFields[15].charAt(0);
                deductionValues[0] = Float.parseFloat(splitFields[16]);
                deductionCodes[1] = splitFields[17].charAt(0);
                deductionValues[1] = Float.parseFloat(splitFields[18]);
                deductionCodes[2] = splitFields[19].charAt(0);
                deductionValues[2] = Float.parseFloat(splitFields[20]);  
                isSuccessful = true;
            }
            catch (Exception err)
            {
                System.out.println("Data parsing error");
                System.out.println(err.getMessage());
                err.printStackTrace();
            }
            return isSuccessful;
        }
}