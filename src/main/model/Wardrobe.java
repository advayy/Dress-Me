package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
/*
 * Reference Code from: JsonSerialization Demo
 * URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 * */

// represents the user's wardrobe that holds Clothing items
public class Wardrobe implements Writable {
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
        this.userWardrobe.remove(index);
        return true;
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
            return removeItem(listIndex);
        } else {
            return found;
        }
    }

    /* Requires: a given item of Clothing type
     * Modifies: this
     * Effects: adds the given item to the userWardrobe
     * */
    public boolean addItem(Clothing c) {
        this.userWardrobe.add(c);
        return true;
    }

    /*
     *  Effects : returns wardrobe as JSON data
     * */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("clothes", clothesToJson());
        return json;
    }

    // EFFECTS: returns Clothing in this wardrobe as a JSON array
    private JSONArray clothesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Clothing c : userWardrobe) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }
}
