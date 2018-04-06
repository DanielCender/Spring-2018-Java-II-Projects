//  Program: FileItem.java
//  Author: Gary R Smith
//  Date Written: 10/31/2009

/*  Abstract: File control class for reading/writing item data.
 */
package writingfiles;

import java.io.*;
import javax.swing.JOptionPane;

public class FileItem {

    //  Data
    public Item data = new Item();

    //  File control variables
    private BufferedReader reader;
    private PrintWriter writer;
    private String fileName = "data\\items.csv";
    private File file = new File(fileName);
    public boolean isEOF = false;
    public boolean isOpen = false;

    //  Default Constructor
    public FileItem() {
    }

    //  Constructor - Allows user supplied filename.
    public FileItem(String filename) {
        fileName = filename;
        file = new File(fileName);
    }

    //  Opens the file for reading.
    public boolean openRead() throws IOException {
        //  Local variable.
        boolean success = false;
        isOpen = false;

        //  Check to see if file exists.  If so open the file.
        if (file.exists()) {
            try {
                //  Open the file.
                reader = new BufferedReader(new FileReader(file));
                isOpen = true;
                success = true;
            } catch (IOException err) {
                JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File System Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //  Display message and terminate.
            isOpen = false;
            throw new FileNotFoundException("File not found");
        }
        return success;
    }

    //  Opens the file for output (append).
    public boolean openAppend() throws IOException {
        //  Local variable.
        boolean success = false;
        isOpen = false;

        //  Check to see if file exists.  If so open the file.
        if (file.exists()) {
            try {
                //  Open the file.
                writer = new PrintWriter(new FileWriter(file, true));
                isOpen = true;
                success = true;
            } catch (IOException err) {
                JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File System Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //  Display message and ask if user wants to open the file as output.
            if (JOptionPane.showConfirmDialog(null,
                    fileName + " does not exist.\nDo you want to open as output?",
                    "File not found error.",
                    JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
                openOutput();
            }
        }
        return success;
    }

    //  Opens the file for output (write over).
    public boolean openOutput() throws IOException {
        //  Local variable.
        boolean success = false;
        isOpen = false;

        //  Check to see if file exists.  If it doesn't, open the file.
        if (!file.exists()) {
            try {
                //  Open the file.
                writer = new PrintWriter(new FileWriter(file, false));
                isOpen = true;
                success = true;
            } catch (IOException err) {
                JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File System Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //  Display message and ask the user if they want to append or 
            //  overwrite the file.
            String options[] = {"Append", "Overwrite", "Cancel"};
            Object selected = JOptionPane.showInputDialog(null,
                    "Output file does not exist.\nPlease select an option.", "C",
                    JOptionPane.DEFAULT_OPTION, null, options, "Cancel");
            if (selected != null) {
                String userSelection = selected.toString();
                switch (userSelection) {
                    case "Append":
                        openAppend();
                        break;
                    case "Overwrite":
                        file.delete();
                        openOutput();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Exiting the program",
                                "File System Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Exiting the program",
                        "File System Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return success;
    }

    //  Close files.
    public boolean close() {
        //  Local variable.
        boolean success = false;

        //  If the file is open, close the file.
        if (isOpen) {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                success = true;
                isOpen = false;
            } catch (IOException err) {
                JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File Close Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return success;
    }

    //  Read routine.
    public boolean readRecord() throws IOException {
        //  Local variable.
        boolean success = false;

        try {
            //  Read a line from the file.
            String inputLine = reader.readLine();

            //  In the input line is null, then there are no more records to read.
            if (inputLine != null) {
                //  Create an instance of the class and populate the class variables.
                data = new Item();
                data.parseCSV(inputLine);
                success = true;
            } else {
                //  Set end of file to true.
                isEOF = true;
            }
        } catch (Exception e) {
            //  Set end of file to true.
            isEOF = true;
        }
        return success;
    }

    //  Writes data as a text file.
    public boolean writeRecord() {
        //  Local variable.
        boolean success = false;

        try {
            writer.println(
                    data.getItemNumber() + ","
                    + data.getStatus() + ","
                    + data.getCategory() + ","
                    + data.getDescription() + ","
                    + data.getHasDiscount() + ","
                    + data.getPrice() + ","
                    + data.getCost() + ","
                    + data.getQtyOnHand() + ","
                    + data.getQtyOnOrder() + ","
                    + data.getYtdSalesQty() + ","
                    + data.getYtdSalesAmt()
            );
            data = new Item();  //  Creates a new data object.
            success = true;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err.getMessage(),
                    "File Write Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }
}
