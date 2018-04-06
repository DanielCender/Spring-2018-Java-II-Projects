//  Enumeration: Apartments.java
//  Author: Gary R. Smith
//  Date Written: 2/8/2016

/*  Abstract: THis defines the Apartrments enumeration.
*/

package enumerations;

public enum Apartments 
{
    STUDIO(650.00f, (short)750, 1, false), 
    ONE_BEDROOM(750.00f, (short)850, 1, true), 
    TWO_BEDROOM(850.00f, (short)1000, 2, true), 
    THREE_BEDROOM(1000.00f, (short)1200, 2, true);
    
    // Instance variables
    private final float price;
    private final short sqFootage;
    private final float nbrBaths;
    private final boolean hasFullKitchen;
    
    // Constructor
    Apartments(float price, short sqFootage, float nbrBaths, boolean hasFullKitchen)
    {
        this.price=price;
        this.sqFootage=sqFootage;
        this.nbrBaths=nbrBaths;
        this.hasFullKitchen=hasFullKitchen;
    }
    
    //  Assessor methods
    public float getPrice() { return price; }
    public short getSqFootage() { return sqFootage; }
    public float getNbrBaths() { return nbrBaths; }
    public boolean getHasFullKitchen() { return hasFullKitchen; }
}
