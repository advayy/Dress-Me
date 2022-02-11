package model;

public class UpperWear extends Clothing {

    private static final String[] ACCEPTABLE_ITEMS = {"Teeshirt", "Shirt", "TankTop"};

    public UpperWear(String colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    /*
    public String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }*/
}
