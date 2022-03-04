package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import model.Colour;

/*
 * Reference Code from: JsonSerialization Demo
 * URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 * */

// Clothing object class
public class Clothing implements Writable {
    private Colour pieceColour;
    private String pieceGenre;
    private String pieceSubtype;
    private String pieceName;
    private int indexNo;
    private static int nextID = 1;

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of Clothing
     * */
    public Clothing(Colour pieceColour, String pieceGenre, String pieceSubtype, String pieceName) {
        this.pieceGenre = pieceGenre;
        this.pieceColour = pieceColour;
        this.pieceSubtype = pieceSubtype;
        this.pieceName = pieceName;
        this.indexNo = nextID++;
    }

    /*
     * Effects: Returns the index number of the piece
     * */
    public int getIndexNo() {
        return this.indexNo;
    }

    /*
     * Effects: Returns the colour of the piece
     * */
    public Colour getPieceColour() {
        return this.pieceColour;
    }

    /*
     * Effects: Returns the genre of the piece
     * */
    public String getPieceGenre() {
        return this.pieceGenre;
    }

    /*
     * Effects: Returns the kind/type of the piece
     * */
    public String getPieceSubtype() {
        return this.pieceSubtype;
    }

    /*
     * Effects: Returns the name of the piece
     * */
    public String getPieceName() {
        return this.pieceName;
    }

    /*
    * Effects: writes a Clothing item into JSON and returns it.
    * */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("index", this.indexNo);
        json.put("colour", colourToJson());
        json.put("genre", this.pieceGenre);
        json.put("subtype", this.pieceSubtype);
        json.put("name", this.pieceName);
        return json;
    }

    public JSONObject colourToJson() {
        JSONObject json = new JSONObject();
        json.put("red", this.pieceColour.getRed());
        json.put("green", this.pieceColour.getGreen());
        json.put("blue", this.pieceColour.getBlue());
        return json;
    }
}