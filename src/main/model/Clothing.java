package model;


// Clothing object class
public class Clothing {
    private String pieceColour;
    private String pieceGenre;
    private String pieceSubtype;
    private String pieceName;
    private int indexNo;
    private static int nextID = 1;

    /* Requires: a color, genre, kind and name
     * Modifies: this
     * Effects: instantiates an instance of Clothing
     * */
    public Clothing(String pieceColour, String pieceGenre, String pieceSubtype, String pieceName) {
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
    public String getPieceColour() {
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
}