package model;

import org.json.JSONObject;
import persistence.Writable;

// Class to save Outfits from clothing objects
public class Outfit implements Writable {
    private HeadWear head;
    private UpperWear upper;
    private LowerWear lower;
    private FootWear foot;
    private int indexNo;
    private static int nextID = 1;

    // Requires: all 4 inputs
    // Modifies: this
    // Effects: constructor for an Outfit with head wear
    public Outfit(Clothing headWear, Clothing upperWear, Clothing lowerWear, Clothing footWear) {
        this.head = (HeadWear) headWear;
        this.upper = (UpperWear) upperWear;
        this.lower = (LowerWear) lowerWear;
        this.foot = (FootWear) footWear;
        this.indexNo = nextID++;
    }

    // Effects : returns the Index number
    public int getIndexNo() {
        return this.indexNo;
    }

    // Effects : returns the head wear
    public Clothing getHeadWear() {
        return this.head;
    }

    // Effects : returns the upper wear
    public Clothing getUpperWear() {
        return this.upper;
    }

    // Effects : returns the lower wear
    public Clothing getLowerWear() {
        return this.lower;
    }

    // Effects : returns the footwear
    public Clothing getFootWear() {
        return this.foot;
    }

    /*
     * Effects: writes a Clothing item into JSON and returns it.
     * */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("head", this.head.toJson());
        json.put("upper", this.upper.toJson());
        json.put("lower", this.lower.toJson());
        json.put("foot", this.foot.toJson());
        return json;
    }
}
