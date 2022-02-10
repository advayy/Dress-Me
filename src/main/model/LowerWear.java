package model;

public class LowerWear extends Clothing {

    private static final String[] ACCEPTABLE_ITEMS = {"Pants", "Shorts", "Jeans"};

    public LowerWear(String colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    public String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }
}
