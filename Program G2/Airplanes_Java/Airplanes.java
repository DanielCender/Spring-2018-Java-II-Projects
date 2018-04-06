//  Class: Airplanes.java
//  Author: Gary R. Smith
//  Date Written: 

/*  Abstract:  */

package airplanelist;

public class Airplanes
{

    //  Instance Fields
    private int lineNumber;
    private String manufacturer;
    private String itemNumber;
    private short scale;
    private String make;
    private String modelDesignation;
    private String model;
    private String tailNumber;
    private String fuselageCode;
    private String pilot;
    private String planeName;


    //  Default contstructor.
    public Airplanes() {
        //  Set default values
        initialize();
    }

    //  Constructor that receives an iput line from a file read operation.
    public Airplanes(String inputLine) {
        initialize();
        parseCSV(inputLine);
    }

    //  Assessor/Mutator Methods
    public void setLineNumber(int value) {
        lineNumber = value;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setManufacturer(String value) {
        manufacturer = value;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    //  ItemNumber
    public void setItemNumber(String value) {
        itemNumber = value;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    //  Scale
    public void setScale(short value) {
        scale = value;
    }

    public short getScale() {
        return scale;
    }
    
    public void setMake(String value) {
        tailNumber = value;
    }

    public String getMake() {
        return tailNumber;
    }

    public void setModelDesignation(String value) {
        modelDesignation = value;
    }

    public String getModelDesignation() {
        return modelDesignation;
    }

    public void setModel(String value) {
        tailNumber = value;
    }

    public String getModel() {
        return tailNumber;
    }
    public void setTailNumber(String value) {
        tailNumber = value;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setFuselageCode(String value) {
        fuselageCode = value;
    }

    public String getFuselageCode() {
        return fuselageCode;
    }

    public void setPilot(String value) {
        pilot = value;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPlaneName(String value) {
        planeName = value;
    }

    public String getPlaneName() {
        return planeName;
    }

    //  Populate Items Record Fields from an input line.
    public boolean  parseCSV(String inputLine) {
        
        System.out.println(inputLine);
        //  Declare Variables.
        boolean success = false;
        String[] splitFields;
        splitFields = inputLine.split(",");

        //  Extract the fields from the input line.
        try {
            if (splitFields.length == 11){
            lineNumber = Integer.parseInt(splitFields[0]);
            manufacturer = splitFields[1];
            itemNumber = splitFields[2];
            scale = Short.parseShort(splitFields[3]);
            make = splitFields[4];
            modelDesignation = splitFields[5];
            model = splitFields[6];
            tailNumber = splitFields[7];
            fuselageCode = splitFields[8];
            pilot = splitFields[9];
            planeName = splitFields[10];
            success = true;
            }
        } catch (Exception err) {
            System.out.println("Error parsing data - Airplanes.");
            System.out.println(err.getMessage());
            err.printStackTrace();
        }
        return success;
    }

    //  Display Data Method - displays all data in the class
    public void displayData() {
        System.out.println("Line number: " + lineNumber);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("ItemNumber: " + itemNumber);
        System.out.println("Scale: " + scale);
        System.out.println("Make: " + make);
        System.out.println("Model Designation: " + modelDesignation);
        System.out.println("Model: " + model);
        System.out.println("TailNumber: " + tailNumber);
        System.out.println("FuselageCode: " + fuselageCode);
        System.out.println("Pilog: " + pilot);        
        System.out.println("Plane Name: " + planeName);
        System.out.println();
    }

    //  Initialized the instance fields.
    public void initialize() {
        //  Initialize all values.
        lineNumber = 0;
        manufacturer = "";
        itemNumber = "";
        scale = 0;
        make = "";
        modelDesignation = "";
        model = "";
        tailNumber = "";
        fuselageCode = "";
        planeName = "";
        pilot = "";

    }
}
