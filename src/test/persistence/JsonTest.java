package persistence;

import model.Clothing;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Reference Code from: JsonSerialization Demo
 * URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 * */
public class JsonTest {
    protected void checkClothing(Clothing c, String name, String genre, String subType, String colour) {
        assertEquals(name, c.getPieceName());
        assertEquals(genre, c.getPieceGenre());
        assertEquals(subType, c.getPieceSubtype());
        assertEquals(colour, c.getPieceColour());
    }
}
