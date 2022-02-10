package model;


// Clothing object class
public class Clothing {
    private String pieceColour;
    private String pieceGenre;
    private String pieceKind;
    private String pieceName;

    public Clothing(String pieceColour, String pieceGenre, String pieceKind, String pieceName) {
        this.pieceGenre = pieceGenre;
        this.pieceColour = pieceColour;
        this.pieceKind = pieceKind;
        this.pieceName = pieceName;
    }

    public String getPieceColour() {
        return this.pieceColour;
    }

    public String getPieceGenre() {
        return this.pieceGenre;
    }

    public String getPieceKind() {
        return this.pieceKind;
    }

    public String getPieceName() {
        return this.pieceName;
    }
}
