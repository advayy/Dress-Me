package model;

import java.util.ArrayList;

// represents the user's wardrobe
public class Wardrobe {
    private ArrayList<Clothing> userWardrobe;

    public Wardrobe() {
        userWardrobe = new ArrayList<Clothing>();
    }

    public ArrayList<Clothing> getUserWardrobe() {
        return userWardrobe;
    }

    public ArrayList<Clothing> getClothesOfColour(String colour) {

        ArrayList<Clothing> filteredList = new ArrayList<Clothing>();

        for (Clothing c : this.userWardrobe) {
            if (c.getPieceColour() == colour) {
                filteredList.add(c);
            }
        }
        return filteredList;
    }

    public ArrayList<Clothing> getClothesOfApparelGenre(String genre) {

        ArrayList<Clothing> filteredList = new ArrayList<Clothing>();

        for (Clothing c : this.userWardrobe) {
            if (c.getApparelGenre() == genre) {
                filteredList.add(c);
            }
        }
        return filteredList;
    }

}
