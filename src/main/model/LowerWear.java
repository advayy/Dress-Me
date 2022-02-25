package model;

// Create instances of lower wear for Clothing
public class LowerWear extends Clothing {

    private static final String[] ACCEPTABLE_ITEMS = {"PANTS", "SHORTS", "JEANS"};

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of LowerWear through its superclass
     * */
    public LowerWear(String colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }


    public static String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }
}
