package model;

// Clothing object class
public class Clothing {
    private String pieceColour;
    private String apparelGenre;
    private String itemKind;
    private String itemName;

    public Clothing(String colour, String genre, String itemKind, String itemName) {
        this.apparelGenre = genre;
        this.pieceColour = colour;
        this.itemKind = itemKind;
        this.itemName = itemName;
    }

    public String getPieceColour() {
        return pieceColour;
    }

    public String getApparelGenre() {
        return apparelGenre;
    }

    public String getItemKind() {
        return itemKind;
    }

    public String getItemName() {
        return itemName;
    }
}
