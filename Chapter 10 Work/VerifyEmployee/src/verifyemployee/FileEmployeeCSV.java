/** Name: File Employee CSV
 *Date: Jan 24, 2018
 *
 * @author danielcender Abstract: This is the file control class for the
 * Employee data CSV file.
 */
package verifyemployee;

import java.io.*;
import javax.swing.JOptionPane;

public class FileEmployeeCSV {

    //Data
    private String fileName = "data//employee.csv";
    public Employee data = new Employee();

    //file control vars
    // Byte input stream
    private BufferedReader reader;
    // Byte Output Stream
    private PrintWriter writer;
    private File file = new File(fileName);
    public boolean isEOF = false;
    public boolean isOpen = false;

    // Default Constructor
    public FileEmployeeCSV() {
    }

    // Constructor - allows user supplied filename
    public FileEmployeeCSV(String filename) {
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

    //Open the file for output (append)
    public boolean openAppend() throws IOException {
        // Local vars
        boolean succeeded = false;
        isOpen = false;
        if (file.exists()) {
            try {
                //  Open the file.
                writer = new PrintWriter(new FileWriter(file, true));
                isOpen = true;
                succeeded = true;
            } catch (IOException exc) {
                javax.swing.JOptionPane.showMessageDialog(null, exc.getMessage(),
                        "File System Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //  Display message and ask if user wants to open the file as output.
            if (javax.swing.JOptionPane.showConfirmDialog(null,
                    fileName + " does not exist.\nDo you want to open as output?",
                    "File not found error.",
                    javax.swing.JOptionPane.ERROR_MESSAGE) == javax.swing.JOptionPane.YES_OPTION) {
                openOutput();
            }
        }
        return succeeded;
    }

    // Opens the file for output (write over)
    public boolean openOutput() throws IOException {
        // Local variables
        boolean succeeded = false;
        isOpen = false;

        //Check to see if the file exists. If it doesn't, open the file.
        if (!file.exists()) {
            try {
                //Open the file
                writer = new PrintWriter(new FileWriter(file, false));
                isOpen = true;
                succeeded = true;
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(null, exc.getMessage(),
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
        return succeeded;
    }

    // Close files.
    public boolean close() {
        // Local variables
        boolean succeeded = false;

        // If the file is open, close the file.
        if (isOpen) {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                succeeded = true;
                isOpen = false;
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(null, exc.getMessage(), "File Close Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return succeeded;
    }

    //  Read routine.
    public boolean readRecord() throws IOException {
        //  Local variable.
        boolean succeeded = false;
        try {
            //  Read a line from the file. Automatically parsed in constructor
            String inputLine = reader.readLine();

            if (inputLine != null) {
                //  If the input line is null, then there are no more records to read.
                data = new Employee(inputLine);
                succeeded = true;
            } else {
                //  Set the end of the file true
                isEOF = true;
            }

        } catch (IOException err) {
            //  Set end of file to true
            isEOF = true;
        }
        return succeeded;
    }

    //  Writes data as a text file.
    public boolean writeRecord() {
        //  Local variable.
        boolean succeeded = false;

        try {
            writer.println(
                    data.getEmployeeNbr() + ","
                    + data.getDepartmentNbr() + ","
                    + data.getLastName() + ","
                    + data.getFirstName() + ","
                    + data.getPayType() + ","
                    + data.getHourlyRate() + ","
                    + data.getTaxMaritalStatus() + ","
                    + data.getNbrExemptions() + ","
                    + data.getStateWithholdingPercentage() + ","
                    + data.getYtdGrossEarnings() + ","
                    + data.getYtdFederalTaxes() + ","
                    + data.getYtdSocialSecurityTaxes() + ","
                    + data.getYtdMedicareTaxes() + ","
                    + data.getYtdStateTaxes() + ","
                    + data.getYtdDeductions() + ","
                    + data.getDeductionCode(0) + ","
                    + data.getDeductionValue(0) + ","
                    + data.getDeductionCode(1) + ","
                    + data.getDeductionValue(1) + ","
                    + data.getDeductionCode(2) + ","
                    + data.getDeductionValue(2)
            );
            data = new Employee();
            succeeded = true;
        } catch (Exception err) {
            javax.swing.JOptionPane.showMessageDialog(null, err.getMessage(),
                    "File Write Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return succeeded;
    }

}
