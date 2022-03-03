package model;

import org.json.JSONObject;
import persistence.Writable;

// Class to save "looks" from clothing objects
public class Looks implements Writable {
    private HeadWear head;
    private UpperWear upper;
    private LowerWear lower;
    private FootWear foot;
    private int indexNo;
    private static int nextID = 1;

    // Requires: all 4 inputs
    // Modifies: this
    // Effects: constructor for look with head wear
    public Looks(Clothing headWear, Clothing upperWear, Clothing lowerWear, Clothing footWear) {
        this.head = (HeadWear) headWear;
        this.upper = (UpperWear) upperWear;
        this.lower = (LowerWear) lowerWear;
        this.foot = (FootWear) footWear;
        this.indexNo = nextID++;
    }

    public int getIndexNo() {
        return this.indexNo;
    }

    public Clothing getHeadWear() {
        return this.head;
    }

    public Clothing getUpperWear() {
        return this.upper;
    }

    public Clothing getLowerWear() {
        return this.lower;
    }

    public Clothing getFootWear() {
        return this.foot;
    }

    /*
    // Requires: all 4 inputs
    // Modifies: this
    // Effects: constructor for look without head wear
    public Looks(Clothing upperWear, Clothing lowerWear, Clothing footWear) {
        this.head = null;
        this.upper = (UpperWear) upperWear;
        this.lower = (LowerWear) lowerWear;
        this.foot = (FootWear) footWear;
    }*/

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
