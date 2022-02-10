package model;


import java.util.ArrayList;

// Class for any hats or glasses in the wardrobe
public class HeadWear extends Clothing {

    private static final String[] ACCEPTABLE_ITEMS = {"Glasses", "Hat", "Headband"};

    public HeadWear(String colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    public String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }

}
