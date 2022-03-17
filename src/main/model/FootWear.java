package model;

import javax.swing.*;

// Create instances of footwear for Clothing
public class FootWear extends Clothing {

    ImageIcon shoeImage = new ImageIcon("./assets/F0_shoe.png");
    ImageIcon slipperImage = new ImageIcon("./assets/F1_slippers.png");

    private static final String[] ACCEPTABLE_ITEMS = {"SHOES", "SLIPPERS"};

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of Footwear through its superclass
     * */
    public FootWear(Colour colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    /*
    *  Effects : Returns the acceptable items of the given clothing type
    * */
    public static String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }

    public ImageIcon getImage() {
        if (this.getPieceGenre().equalsIgnoreCase(ACCEPTABLE_ITEMS[0])) {
            return shoeImage;
        } else {
            return slipperImage;
        }
    }
}
