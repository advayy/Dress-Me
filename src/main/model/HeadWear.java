package model;

// Create instances of Head garments for Clothing
public class HeadWear extends Clothing {

    private static final String[] ACCEPTABLE_ITEMS = {"Glasses", "Hat", "Headband"};

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of Headwear through its superclass
     * */
    public HeadWear(String colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    /*
    public String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }*/
}
