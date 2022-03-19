package model;

import javax.swing.*;

// Create instances of Upper wear for Clothing
public class UpperWear extends Clothing {

    ImageIcon teesImage = new ImageIcon("./assets/U0_teeshirt.png");
    ImageIcon shirtImage = new ImageIcon("./assets/U1_shirt.png");
    ImageIcon jacketImage = new ImageIcon("./assets/U3_jacket.png");
    ImageIcon sweaterImage = new ImageIcon("./assets/U4_sweater.png");

    private static final String[] ACCEPTABLE_ITEMS = {"TEESHIRT", "SHIRT", "JACKET", "SWEATER"};

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of UpperWear through its superclass
     * */
    public UpperWear(Colour colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    /*
     *  Effects : Returns the acceptable items of the given clothing type
     * */
    public static String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }

    // Effects: returns the subtype image to the UI
    @Override
    public ImageIcon getImage(String subtype) {
        if (subtype.equalsIgnoreCase(ACCEPTABLE_ITEMS[0])) {
            return teesImage;
        } else if (subtype.equalsIgnoreCase(ACCEPTABLE_ITEMS[1])) {
            return shirtImage;
        } else if (subtype.equalsIgnoreCase(ACCEPTABLE_ITEMS[2])) {
            return jacketImage;
        } else {
            return sweaterImage;
        }
    }
}
