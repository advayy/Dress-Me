package model;

import javax.swing.*;

// Create instances of lower wear for Clothing
public class LowerWear extends Clothing {

    ImageIcon pants = new ImageIcon("./assets/L0_pants.png");
    ImageIcon shorts = new ImageIcon("./assets/L1_shorts.png");
    ImageIcon jeans = new ImageIcon("./assets/L2_jeans.png");

    private static final String[] ACCEPTABLE_ITEMS = {"PANTS", "SHORTS", "JEANS"};

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of LowerWear through its superclass
     * */
    public LowerWear(Colour colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    /*
     *  Effects : Returns the acceptable items of the given clothing type
     * */
    public static String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }

    @Override
    public ImageIcon getImage(String subtype) {
        if (subtype.equalsIgnoreCase(ACCEPTABLE_ITEMS[0])) {
            return pants;
        } else if (subtype.equalsIgnoreCase(ACCEPTABLE_ITEMS[1])) {
            return shorts;
        } else {
            return jeans;
        }
    }
}
