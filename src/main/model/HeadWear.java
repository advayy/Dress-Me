package model;

import javax.swing.*;

// Create instances of Head garments for Clothing
public class HeadWear extends Clothing {

    ImageIcon glassesImage = new ImageIcon("./assets/H0_glasses.png");
    ImageIcon hatImage = new ImageIcon("./assets/H1_hat.png");
    ImageIcon headbandImage = new ImageIcon("./assets/H2_headband.png");


    private static final String[] ACCEPTABLE_ITEMS = {"GLASSES", "HAT", "HEADBAND"};

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of Head wear through its superclass
     * */
    public HeadWear(Colour colour, String genre, String itemKind, String itemName) {
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
            return glassesImage;
        } else if (this.getPieceGenre().equalsIgnoreCase(ACCEPTABLE_ITEMS[1])) {
            return hatImage;
        } else {
            return headbandImage;
        }
    }
}
