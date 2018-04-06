//  Program: WriteReadBinaryFiles.java
//  Author: Gary R Smith
//  Date Written: 11/11/2014

/*  Abstract: This program demonstrates writing a binary file
 and then reading it back.
 */
package writereadbinaryfiles;

import java.io.*;

public class WriteReadBinaryFiles {

    private static final boolean aBoolean = true;
    private static final byte aByte = (byte) 127;
    private static final char aChar = 'J';
    private static final double aDouble = 98765.43;
    private static final float aFloat = 5678.90f;
    private static final int aInt = 345;
    private static final long aLong = 1928374675;
    private static final short aShort = (short) 475629;
    private static final String aString = "Binary file i/o example";

    //  Main method()
    public static void main(String[] args) {
        // First write the file.
        writeBinary();
        //  Then read back the file and display the variables.
        readBinary();
    }

    //  This method writes data in binary format.
    public static void writeBinary() {
        //  Using try-with-resources) structure.
        try (DataOutputStream outputFile
                = new DataOutputStream(new FileOutputStream("afile.dat"))) {
            //  Write the data to the file.
            outputFile.writeBoolean(aBoolean);
            outputFile.writeByte(aByte);
            outputFile.writeChar(aChar);
            outputFile.writeDouble(aDouble);
            outputFile.writeFloat(aFloat);
            outputFile.writeInt(aInt);
            outputFile.writeLong(aLong);
            outputFile.writeShort(aShort);
            outputFile.writeUTF(aString);
            //  Let's write it again so we have two records.
            outputFile.writeBoolean(aBoolean);
            outputFile.writeByte(aByte);
            outputFile.writeChar(aChar);
            outputFile.writeDouble(aDouble);
            outputFile.writeFloat(aFloat);
            outputFile.writeInt(aInt);
            outputFile.writeLong(aLong);
            outputFile.writeShort(aShort);
            outputFile.writeUTF(aString);
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
        //  No need to close the file.
    }

    //  This method reads the binary file.
    public static void readBinary() {
        //  Using try-with-resources) structure.
        try (DataInputStream inputFile
                = new DataInputStream(new FileInputStream("afile.dat"))) {
            //  Create a loop to read the data.
            while (true) {
                System.out.println(inputFile.readBoolean());
                System.out.println(inputFile.readByte());
                System.out.println(inputFile.readChar());
                System.out.println(inputFile.readDouble());
                System.out.println(inputFile.readFloat());
                System.out.println(inputFile.readInt());
                System.out.println(inputFile.readLong());
                System.out.println(inputFile.readShort());
                System.out.println(inputFile.readUTF());
                System.out.println("End of record\n");
            }
        } catch (EOFException err) {
            System.out.println("End of file encountered.");
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
        //  No need to close the file.
    }
}
