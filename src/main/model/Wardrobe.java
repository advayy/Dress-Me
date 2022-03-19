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
    private ArrayList<Outfit> internalOutfits;
    private ArrayList<Clothing> allHeadWear;
    private ArrayList<Clothing> allUpperWear;
    private ArrayList<Clothing> allLowerWear;
    private ArrayList<Clothing> allFootwear;
    private String wardrobeName;

    // Effects: Constructor
    public Wardrobe() {
        internalWardrobe = new ArrayList<>();
        internalOutfits = new ArrayList<>();
        allHeadWear = new ArrayList<>();
        allUpperWear = new ArrayList<>();
        allLowerWear = new ArrayList<>();
        allFootwear = new ArrayList<>();
    }

    // Effects: returns internal head wear list
    public ArrayList<Clothing> getAllHeadWear() {
        return allHeadWear;
    }

    // Effects: returns internal upper wear list
    public ArrayList<Clothing> getAllUpperWear() {
        return allUpperWear;
    }

    // Effects: returns internal lower wear list
    public ArrayList<Clothing> getAllLowerWear() {
        return allLowerWear;
    }

    // Effects: returns internal footwear list
    public ArrayList<Clothing> getAllFootwear() {
        return allFootwear;
    }

    // Effects: generates all internal lists
    public void createTypeLists() {
        this.allHeadWear = getClothesByType(1);
        this.allUpperWear = getClothesByType(2);
        this.allLowerWear = getClothesByType(3);
        this.allFootwear = getClothesByType(4);
    }


    //Requires: name from user when saving
    //Modifies: this
    // Effects: sets the wardrobes name
    public void setName(String name) {
        this.wardrobeName = name;
    }

    //Effects: returns name if set
    public String getName() {
        return this.wardrobeName;
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
    public ArrayList<Clothing> getClothesOfColour(Colour colour) {
        ArrayList<Clothing> filteredList = new ArrayList<>();

        for (Clothing c : this.internalWardrobe) {
            if (c.getPieceColour().colourEquals(colour)) {
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

        ArrayList<Clothing> filteredList = new ArrayList<>();

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
        ArrayList<Clothing> filteredList = new ArrayList<>();

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


    /*
     * Requires : an integer between 1-4 from the user (encoding representing type of wear filtered for)
     * Effects  : creates a list of that type of wear
     * */
    public int getCodeByType(Clothing c) {
        if (c instanceof HeadWear) {
            return 1;
        } else if (c instanceof UpperWear) {
            return 2;
        } else if (c instanceof LowerWear) {
            return 3;
        } else {
            return 4;
        }
    }


    /* Requires: index of an item
     * Modifies: this
     * Effects: removes the item at that index from wardrobe
     * */
    public boolean removeItem(int index) {
        this.internalWardrobe.remove(index);
        createTypeLists();
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
     * Effects: removes the Outfit item at that index from wardrobe
     * */
    public boolean removeOutfit(int index) {
        this.internalOutfits.remove(index);
        return true;
    }

    /* Requires: the index number of the Outfit
     * Modifies: this
     * Effects: returns the wardrobe Outfits list index of the item
     * */
    public boolean removeOutfitByIndexNo(int index) {
        boolean found = false;
        int listIndex = 0;
        for (Outfit item: this.internalOutfits) {
            if (item.getIndexNo() == index) {
                listIndex = this.internalOutfits.indexOf(item);
                found = true;
            }
        }
        if (found) {
            removeOutfit(listIndex);
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

    // Requires: a clothing ID
    // Effects: returns internal list index of a given clothing ID
    public int getSubListIndex(int index) {
        int listIndex = -1;
        if (searchListForIndex(index, this.allHeadWear) != -1) {
            listIndex = searchListForIndex(index, this.allHeadWear);
        } else if (searchListForIndex(index, this.allUpperWear) != -1) {
            listIndex = searchListForIndex(index, this.allUpperWear);
        } else if (searchListForIndex(index, this.allLowerWear) != -1) {
            listIndex = searchListForIndex(index, this.allLowerWear);
        } else if (searchListForIndex(index, this.allFootwear) != -1) {
            listIndex = searchListForIndex(index, this.allFootwear);
        }
        return listIndex;
    }


    // Requires: a clothing ID and a list
    // Effects: looks for the ID in the list and returns its index if found, -1 if not found
    public int searchListForIndex(int index, ArrayList<Clothing> list) {
        int flag = -1;
        for (Clothing item: list) {
            if (item.getIndexNo() == index) {
                flag = list.indexOf(item);
            }
        }
        return flag;
    }

    /* Requires: a given item of Clothing type
     * Modifies: this
     * Effects: adds the given item to the internalWardrobe
     * */
    public boolean addItem(Clothing c) {
        this.internalWardrobe.add(c);
        if (c instanceof HeadWear) {
            this.allHeadWear.add(c);
        } else if (c instanceof UpperWear) {
            this.allUpperWear.add(c);
        } else if (c instanceof LowerWear) {
            this.allLowerWear.add(c);
        } else {
            this.allFootwear.add(c);
        }
        return true;
    }

    /* Requires : an Outfit object
    *  Modifies : this
    *  Effects  : adds Outfit to internalOutfits
    * */
    public void addOutfit(Outfit l) {
        this.internalOutfits.add(l);
    }

    /*
     *  Effects : returns wardrobe as JSON data
     * */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.wardrobeName);
        json.put("clothes", clothesToJson());
        json.put("outfits", outfitsToJson());
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

    // EFFECTS: returns arraylist of Outfits in this wardrobe as a JSON array
    private JSONArray outfitsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Outfit l : internalOutfits) {
            jsonArray.put(l.toJson());
        }

        return jsonArray;
    }

    //Effects: Returns the internalOutfits object
    public ArrayList<Outfit> getInternalOutfits() {
        return this.internalOutfits;
    }
}
