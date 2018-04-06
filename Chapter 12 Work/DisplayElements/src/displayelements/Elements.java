/*
 * Name: Elements
 * Author: Daniel Cender
 * Date: 2.12.2018
 * Abstract: This is the Elements enum, which holds constant values of 10 elements from the periodic table.
 */
package displayelements;

/**
 *
 * @author danielcender
 */
public enum Elements {
    // Define Constants
    SILVER("Silver", 14, 28.085f),
    NEON("Neon", 10, 20.1797f),
    ANTIMONY("Antimony", 51, 121.760f),
    COPPER("Copper", 29, 63.546f),
    GALLIUM("Gallium", 31, 69.723f),
    TITANIUM("Titanium", 22, 47.867f),
    HELIUM("Helium", 2, 4.002f),
    KRYPTON("Krypton", 36, 83.798f),
    IRON("Iron", 26, 55.845f),
    MERCURY("Mercury", 80, 200.592f);
    
    
    
    // Define final literals
    private final String name;
    private final int aNumber;
    private final float weight;

    // Define constructor
    Elements(String name, int aNumber, float weight) {
    this.name = name;
    this.aNumber = aNumber;
    this.weight = weight;
}

    // Accessor methods
    public String getName() { return name; }
    public int getANumber() { return aNumber; }
    public float getWeight() { return weight; }

}
