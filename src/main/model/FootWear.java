package model;

public class FootWear extends Clothing {

    private static final String[] ACCEPTABLE_ITEMS = {"Shoes", "Sandals"};

    public FootWear(String colour, String genre, String itemKind, String itemName) {
        super(colour, genre, itemKind, itemName);
    }

    /*
    public String[] getAcceptableItems() {
        return ACCEPTABLE_ITEMS;
    }*/
}
