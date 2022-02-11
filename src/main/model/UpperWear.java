package model;

// Create instances of Upper wear for Clothing
public class UpperWear extends Clothing {

    private static final String[] ACCEPTABLE_ITEMS = {"Teeshirt", "Shirt", "TankTop"};

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of UpperWear through its superclass
     * */
    public UpperWear(String colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    /*
    public String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }*/
}
