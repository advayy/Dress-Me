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
    private ArrayList<Clothing> internalWardrobe;
    private ArrayList<Looks> internalLooks;

    public Wardrobe() {
        internalWardrobe = new ArrayList<Clothing>();
        internalLooks = new ArrayList<Looks>();
    }


    /*
     * Effects: Returns the internalWardrobe Arraylist
     * */
    public ArrayList<Clothing> getInternalWardrobe() {
        return this.internalWardrobe;
    }

    /*
     * Requires: a lowercase string colour
     * Effects: filters the internalWardrobe for clothes that match the input color
     * */
    public ArrayList<Clothing> getClothesOfColour(String colour) {

        ArrayList<Clothing> filteredList = new ArrayList<Clothing>();

        for (Clothing c : this.internalWardrobe) {
            if (c.getPieceColour().equals(colour)) {
                filteredList.add(c);
            }
        }
        return filteredList;
    }

    /*
     * Requires: a lowercase string genre
     * Effects: filters the internalWardrobe for clothes that match the input genre
     * */
    public ArrayList<Clothing> getClothesOfApparelGenre(String genre) {

        ArrayList<Clothing> filteredList = new ArrayList<Clothing>();

        for (Clothing c : this.internalWardrobe) {
            if (c.getPieceGenre().equals(genre)) {
                filteredList.add(c);
            }
        }
        return filteredList;
    }

    /*
    * Requires : an integer between 1-4 from the user (encoding representing type of wear filtered for)
    * Effects  : creates a list of that type of wear
    * */
    public ArrayList<Clothing> getClothesByType(int code) {
        ArrayList<Clothing> filteredList = new ArrayList<Clothing>();

        for (Clothing c : this.internalWardrobe) {
            if (code == 1) {
                if (c instanceof HeadWear) {
                    filteredList.add(c);
                }
            } else if (code == 2) {
                if (c instanceof UpperWear) {
                    filteredList.add(c);
                }
            } else if (code == 3) {
                if (c instanceof LowerWear) {
                    filteredList.add(c);
                }
            } else {
                if (c instanceof FootWear) {
                    filteredList.add(c);
                }
            }
        }
        return filteredList;
    }

    /* Requires: index of an item
     * Modifies: this
     * Effects: removes the item at that index from wardrobe
     * */
    public boolean removeItem(int index) {
        this.internalWardrobe.remove(index);
        return true;
    }

    /* Requires: the index number of the item
     * Modifies: this
     * Effects: returns the wardrobe list index of the item
     * */
    public boolean removeItemByIndex(int index) {
        boolean found = false;
        int listIndex = 0;
        for (Clothing item: this.internalWardrobe) {
            if (item.getIndexNo() == index) {
                listIndex = this.internalWardrobe.indexOf(item);
                found = true;
            }
        }
        if (found) {
            return removeItem(listIndex);
        } else {
            return found;
        }
    }

    /* Requires: index of an item
     * Modifies: this
     * Effects: removes the Look item at that index from wardrobe
     * */
    public boolean removeLookItem(int index) {
        this.internalLooks.remove(index);
        return true;
    }

    /* Requires: the index number of the Look
     * Modifies: this
     * Effects: returns the wardrobe Look list index of the item
     * */
    public boolean removeLookItemByIndex(int index) {
        boolean found = false;
        int listIndex = 0;
        for (Looks item: this.internalLooks) {
            if (item.getIndexNo() == index) {
                listIndex = this.internalLooks.indexOf(item);
                found = true;
            }
        }
        if (found) {
            removeLookItem(listIndex);
        }
        return found;
    }

    //requires: an integer index of the clothing
    //effects: returns the clothing item with the corresponding index or null
    public Clothing getClothesByIndex(int index) {
        boolean found = false;
        int listIndex = 0;
        for (Clothing item: this.internalWardrobe) {
            if (item.getIndexNo() == index) {
                listIndex = this.internalWardrobe.indexOf(item);
                found = true;
            }
        }
        if (found) {
            return this.internalWardrobe.get(listIndex);
        } else {
            return null;
        }
    }

    /* Requires: a given item of Clothing type
     * Modifies: this
     * Effects: adds the given item to the internalWardrobe
     * */
    public boolean addItem(Clothing c) {
        this.internalWardrobe.add(c);
        return true;
    }

    /* Requires : a look object
    *  Modifies : this
    *  Effects  : adds look to internalLooks
    * */
    public boolean addLook(Looks l) {
        this.internalLooks.add(l);
        return true;
    }

    /*
     *  Effects : returns wardrobe as JSON data
     * */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("clothes", clothesToJson());
        json.put("looks", looksToJson());
        return json;
    }

    // EFFECTS: returns arraylist of Clothing in this wardrobe as a JSON array
    private JSONArray clothesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Clothing c : internalWardrobe) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns arraylist of Looks in this wardrobe as a JSON array
    private JSONArray looksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Looks l : internalLooks) {
            jsonArray.put(l.toJson());
        }

        return jsonArray;
    }

    //Effects: Returns the internalLooks object
    public ArrayList<Looks> getInternalLooks() {
        return this.internalLooks;
    }
}
