package model;

// Create instances of footwear for Clothing
public class FootWear extends Clothing {

    private static final String[] ACCEPTABLE_ITEMS = {"SHOES", "SLIPPERS"};

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of Footwear through its superclass
     * */
    public FootWear(String colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    /*
    *  Effects : Returns the acceptable items of the given clothing type
    * */
    public static String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }
}
