//  Program: Apartments.java
//  Author: Gary R. Smith
//  Date Written: 2/8/2016

/*  Abstract: This program allows a user to select which apartment they would
    like to see information on.
*/
package enumerations;

//  Imports
import java.io.*;

public class Enumerations 
{
    private static BufferedReader keyboard = 
            new BufferedReader(new InputStreamReader(System.in));
    //  Main method.
    public static void main(String[] args) throws IOException
    {
        //  Declarations
        Apartments apartment;
        String answer;
        
        //  Ask the use which apartment they would like to display.
        System.out.println("Select on of the following:");
        System.out.println("0 = Studio");
        System.out.println("1 = One Bedroom");
        System.out.println("2 = Two Bedroom");
        System.out.println("3 = Three Bedroom");
        System.out.println("9 = exit");
        answer = keyboard.readLine();
        
        //  We will assume our user is pretty bright and can enter a number.
        switch (answer)
        {
            case "0": displayApartment(apartment = Apartments.STUDIO);
                break;
            case "1": displayApartment(apartment = Apartments.ONE_BEDROOM);
                break;
            case "2": displayApartment(apartment = Apartments.TWO_BEDROOM);
                break;
            case "3": displayApartment(apartment = Apartments.THREE_BEDROOM);
            break; 
            case "9":
                break;
            default: System.out.println("Really!  You can't enter a simple number?");
        }
    }
    
    //  Displays the apartment selected.  NOTE: This method could also be in the
    //  enum object.
    private static void displayApartment(Apartments a)
    {
        System.out.println("\nYou selected a " + a.name() + " apartment.");
        System.out.println("Price: " + a.getPrice());
        System.out.println("Square footage: " + a.getSqFootage());
        System.out.println("Number of baths: " + a.getNbrBaths());
        System.out.println("Has a full kitchen: " + a.getHasFullKitchen());
    }
    
}
