package model;

import java.util.ArrayList;

// represents the user's wardrobe that holds Clothing items
public class Wardrobe {
    private ArrayList<Clothing> userWardrobe;

    public Wardrobe() {
        userWardrobe = new ArrayList<Clothing>();
    }


    /*
     * Effects: Returns the userWardrobe Arraylist
     * */
    public ArrayList<Clothing> getUserWardrobe() {
        return this.userWardrobe;
    }

    /*
     * Requires: a lowercase string colour
     * Effects: filters the userWardrobe for clothes that match the input color
     * */
    public ArrayList<Clothing> getClothesOfColour(String colour) {

        ArrayList<Clothing> filteredList = new ArrayList<Clothing>();

        for (Clothing c : this.userWardrobe) {
            if (c.getPieceColour().equals(colour)) {
                filteredList.add(c);
            }
        }
        return filteredList;
    }

    /*
     * Requires: a lowercase string genre
     * Effects: filters the userWardrobe for clothes that match the input genre
     * */
    public ArrayList<Clothing> getClothesOfApparelGenre(String genre) {

        ArrayList<Clothing> filteredList = new ArrayList<Clothing>();

        for (Clothing c : this.userWardrobe) {
            if (c.getPieceGenre().equals(genre)) {
                filteredList.add(c);
            }
        }
        return filteredList;
    }

    /* Requires: index of an item
     * Modifies: this
     * Effects: removes the item at that index from wardrobe
     * */
    public boolean removeItem(int index) {
        int initialSize = userWardrobe.size();
        this.userWardrobe.remove(index);
        int afterRemovalSize = userWardrobe.size();
        return (initialSize != afterRemovalSize);
    }

    /* Requires: the index number of the item
     * Modifies: this
     * Effects: returns the wardrobe list index of the item
     * */
    public boolean removeItemByIndex(int index) {
        boolean found = false;
        int listIndex = 0;
        for (Clothing item: this.userWardrobe) {
            if (item.getIndexNo() == index) {
                listIndex = this.userWardrobe.indexOf(item);
                found = true;
            }
        }
        if (found) {
            removeItem(listIndex);
        }
        return found;
    }

    /* Requires: a given item of Clothing type
     * Modifies: this
     * Effects: adds the given item to the userWardrobe
     * */
    public boolean addItem(Clothing c) {
        int initialSize = userWardrobe.size();
        this.userWardrobe.add(c);
        int afterAddSize = userWardrobe.size();
        return (initialSize != afterAddSize);
    }

}
