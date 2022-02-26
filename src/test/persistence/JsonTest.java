package persistence;

import model.Clothing;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkClothing(Clothing c, String name, String genre, String subType, String colour) {
        assertEquals(name, c.getPieceName());
        assertEquals(genre, c.getPieceGenre());
        assertEquals(subType, c.getPieceSubtype());
        assertEquals(colour, c.getPieceColour());
    }
}
