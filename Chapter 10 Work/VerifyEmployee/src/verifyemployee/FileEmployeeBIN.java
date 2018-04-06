/**Name: File Employee BIN
 *Date: Jan 24, 2018
 * @author danielcender
 * Abstract: This is the file control class for the Employee binary file.
 */
package verifyemployee;

import java.io.*;
import javax.swing.JOptionPane;
import verifyemployee.Employee;

public class FileEmployeeBIN {
     //  Data
    public Employee data = new Employee();

    //  File control variables
    //  Binary Reader
    private DataInputStream reader;
    // Binary Writer
    private DataOutputStream writer;
    private String fileName = "data//employee.dat";
    private File file = new File(fileName);

    public boolean isEOF = false;
    public boolean isOpen = false;

    //  Default Constructor
    public FileEmployeeBIN()
    {
        
    }
    
    //  Constructor - Allows user supplied filename.
    public FileEmployeeBIN(String filename)
    {
        fileName = filename;
        file =  new File(fileName);
    }

    //  Opens the file for reading.
    public boolean openRead() throws IOException
    {
        //  Local variable.
        boolean succeeded = false;
        isOpen = false;

        //  Check to see if file exists.  If so open the file.
        if (file.exists())
        {
            try
            {
                //  Open the file.
                reader = new DataInputStream(new FileInputStream(file));
                isOpen = true;
                succeeded = true;
            } catch (IOException err)
            {
                javax.swing.JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File System Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } 
        else
        {
            //  Display message and terminate.
            throw new FileNotFoundException("File not found");
        }
        return succeeded;
    }

    //  Opens the file for output (append).
    public boolean openAppend() throws IOException
    {
        //  Local variable.
        boolean succeeded = false;
        isOpen = false;

        //  Check to see if file exists.  If so open the file.
        if (file.exists())
        {
            try
            {
                //  Open the file.
                writer = new DataOutputStream(new FileOutputStream(file, true));
                isOpen = true;
                succeeded = true;
            } 
            catch (IOException err)
            {
                javax.swing.JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File System Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } 
        else
        {
            //  Display message and ask if user wants to open the file as output.
            if (javax.swing.JOptionPane.showConfirmDialog(null, 
                    fileName + " does not exist.\nDo you want to open as output?",
                    "File not found error.",
                    javax.swing.JOptionPane.ERROR_MESSAGE) == javax.swing.JOptionPane.YES_OPTION)
            {
                openOutput();
            } 
        }
        return succeeded;
    }

    //  Opens the file for output (write over).
    public boolean openOutput() throws IOException
    {
        //  Local variable.
        boolean succeeded = false;
        isOpen = false;

        //  Check to see if file exists.  If it doesn't, open the file.
        if (!file.exists())
        {
            try
            {
                //  Open the file.
                writer = new DataOutputStream(new FileOutputStream(file, false));
                isOpen = true;
                succeeded = true;
            } 
            catch (IOException err)
            {
                javax.swing.JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File System Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } 
        else
        {
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

    //  Close files.
    public boolean close()
    {
        //  Local variable.
        boolean succeeded = false;

        //  If the file is open, close the file.
        if (isOpen)
        {
            try
            {
                if (reader != null)
                {
                    reader.close();
                }
                if (writer != null)
                {
                    writer.close();
                }
                succeeded = true;
                isOpen = false;
            } 
            catch (IOException err)
            {
                javax.swing.JOptionPane.showMessageDialog(null, err.getMessage(),
                        "File Close Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        return succeeded;
    }

    //  Read routine.
    public boolean readRecord() throws IOException
    {
        //  Local variable.
        boolean succeeded = false;
        data = new Employee();
        try {
            //  Read a Record from the Binary file
            data.setEmployeeNbr(reader.readInt());
            data.setDepartmentNbr(reader.readShort());
            data.setLastName(reader.readUTF());
            data.setFirstName(reader.readUTF());
            data.setPayType(reader.readChar());
            data.setHourlyRate(reader.readFloat());
            data.setTaxMaritalStatus(reader.readChar());
            data.setNbrExemptions(reader.readByte());
            data.setStateWithholdingPercentage(reader.readFloat());
            data.setYtdGrossEarnings(reader.readDouble());
            data.setYtdFederalTaxes(reader.readDouble());
            data.setYtdSocialSecurityTaxes(reader.readDouble());
            data.setYtdMedicareTaxes(reader.readDouble());
            data.setYtdStateTaxes(reader.readDouble());
            data.setYtdDeductions(reader.readDouble());
            data.setDedeductionCode(0, reader.readChar());
            data.setDeductionCode(0, reader.readFloat());
            data.setDedeductionCode(1, reader.readChar());
            data.setDeductionCode(1, reader.readFloat());
            data.setDedeductionCode(2, reader.readChar());
            data.setDeductionCode(2, reader.readFloat());
            succeeded = true;
        } 
        catch (Exception e)
        {
            //  Set end of file to true.
            isEOF = true;
            succeeded = false;
            e.printStackTrace();
        }
        return succeeded;
    }

    //  Writes data as a text file.
    public boolean writeRecord()
    {
        //  Local variable.
        boolean succeeded = false;
      
      try {
            writer.writeInt(data.getEmployeeNbr());
            writer.writeShort(data.getDepartmentNbr());
            writer.writeUTF(data.getLastName());
            writer.writeUTF(data.getFirstName());
            writer.writeChar(data.getPayType());
            writer.writeFloat(data.getHourlyRate());
            writer.writeChar(data.getTaxMaritalStatus());
            writer.writeByte(data.getNbrExemptions());
            writer.writeFloat(data.getStateWithholdingPercentage());
            writer.writeDouble(data.getYtdGrossEarnings());
            writer.writeDouble(data.getYtdFederalTaxes());
            writer.writeDouble(data.getYtdSocialSecurityTaxes());
            writer.writeDouble(data.getYtdMedicareTaxes());
            writer.writeDouble(data.getYtdStateTaxes());
            writer.writeDouble(data.getYtdDeductions());
            writer.writeChar(data.getDeductionCode(0));
            writer.writeFloat(data.getDeductionValue(0));
            writer.writeChar(data.getDeductionCode(1));
            writer.writeFloat(data.getDeductionValue(1));
            writer.writeChar(data.getDeductionCode(2));
            writer.writeFloat(data.getDeductionValue(2));
            succeeded = true;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err.getMessage(),
                    "File Write Error", JOptionPane.ERROR_MESSAGE);
        }
        return succeeded;
    }
    
    
    
}
