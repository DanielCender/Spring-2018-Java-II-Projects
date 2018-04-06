/*
 * Name: DisplayElements
 * Author: Daniel Cender
 * Date: 2.12.2018
 * Abstract: This program allows a user to access an Elements enumeration and then outputs their selection to the console.
 */
package displayelements;
import displayelements.Elements;
import java.io.*;
/**
 *
 * @author danielcender
 */
public class DisplayElements {
    // Declare new input stream reader
    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Instantiate new enumeration of Elements
        Elements element;
        String answer = "";
        do {
        System.out.println("Please enter an element symbol to get properties.\n"
                + "Available elements are: Si, Ne, Sb, Cu, Ga, Ti, He, Kr, Fe, and Hg.\nInput “All” to see all elements.\nEnter 'exit' to quit program.");
        
        // Store user input
        answer = keyboard.readLine();
        // Space it out a bit
        System.out.println();
        // Switch to find matching case in Elements
        switch(answer) {
            case "Si": 
                displayElement(element = Elements.SILVER);
            break;
            case "Ne":
                displayElement(element = Elements.NEON);
            break;
            case "Sb":
                displayElement(element = Elements.ANTIMONY);
            break;
            case "Cu":
                displayElement(element = Elements.COPPER);
            break;
            case "Ga":
                displayElement(element = Elements.GALLIUM);
            break;
            case "Ti":
                displayElement(element = Elements.TITANIUM);
            break;
            case "He":
                displayElement(element = Elements.HELIUM);
            break;
            case "Kr":
                displayElement(element = Elements.KRYPTON);
            break;
            case "Fe":
                displayElement(element = Elements.IRON);
            break;
            case "Hg":
                displayElement(element = Elements.MERCURY);
            break;
            case "All":
                displayAll();
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("The value you inputted was not valid. Exiting program.");
                break;
        }
        } while(answer != "exit");
    }
    
    // Method to display element properties
    private static void displayElement(Elements e) {
        System.out.println("Name: " + e.getName());
        System.out.println("Atomic Number: " + e.getANumber());
        System.out.println("Atomic Weight: " + e.getWeight());
        System.out.println();
    }
    
    // Method to display all elements and their properties
    private static void displayAll() {
        for(Elements e : Elements.values()){
            displayElement(e);
    }
        
    }
}
