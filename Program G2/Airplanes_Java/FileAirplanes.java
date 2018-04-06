//  Class: FileAirplanes.java
//  Author: Gary R. Smith
//  Date Written: 

/*  Abstract:  */

package airplanelist;
import java.io.*;
import javax.swing.JOptionPane;

public class FileAirplanes
{

    //  File control variables
    public BufferedReader reader;
    public PrintWriter writer;
    private final String fileName = "data\\airplanes.csv";
    public File file = new File(fileName);
    public boolean isEOF = false;
    public boolean isOpen = false;

    //  Data
    public Airplanes data;

    //  Opens the file for reading.
    public boolean open() throws IOException {
        //  Local variable.
        boolean success = false;
        
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
                isOpen = false;
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
                isOpen = false;
            }
        } else {
            //  Display message and terminate.
            isOpen = false;
            throw new FileNotFoundException("File not found");
        }
        return success;
    }   

    //  Opens the file for output (write over).
    public boolean openOutput() throws IOException {
        //  Local variable.
        boolean success = false;
        
        //  Check to see if file exists.  If so open the file.
        if (file.exists()) {
            //  You may want to display a message here because you are about to
            //  overwite an existing file.
            try {
                //  Open the file.
                writer = new PrintWriter(new FileWriter(file, false));
                isOpen = true;
                success = true;
            } catch (IOException err) {
                JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File System Error", JOptionPane.ERROR_MESSAGE);
                isOpen = false;
            }
        } else {
            //  Display message and terminate.
            isOpen = false;
            throw new FileNotFoundException("File not found");
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
                data = new Airplanes(inputLine);
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
            writer.print(
                data.getLineNumber() + ","
                + data.getManufacturer() + ","
                + data.getItemNumber() + ","
                + data.getScale() + ","
                + data.getMake() + ","
                + data.getModelDesignation() + ","
                + data.getModel() + ","
                + data.getTailNumber() + ","
                + data.getFuselageCode() + ","
                + data.getPilot() + ","

            );
            writer.println();
            success = true;
        }
        catch (Exception err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File Write Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }
}
