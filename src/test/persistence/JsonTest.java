package persistence;

import model.Clothing;
import model.Colour;
import model.Looks;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Reference Code from: JsonSerialization Demo
 * URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 * */
public class JsonTest {
    protected void checkClothing(Clothing c, String name, String genre, String subType, Colour colour) {
        assertEquals(name, c.getPieceName());
        assertEquals(genre, c.getPieceGenre());
        assertEquals(subType, c.getPieceSubtype());
        assertTrue(c.getPieceColour().equals(colour));
    }

    protected void checkTwoClothes(Clothing c, Clothing d) {
        assertEquals(d.getPieceName(), c.getPieceName());
        assertEquals(d.getPieceGenre(), c.getPieceGenre());
        assertEquals(d.getPieceSubtype(), c.getPieceSubtype());
        assertTrue(d.getPieceColour().equals(c.getPieceColour()));
    }

    protected void checkLook(Looks l, Clothing head, Clothing upper, Clothing lower, Clothing foot) {
        checkTwoClothes(head, l.getHeadWear());
        checkTwoClothes(upper, l.getUpperWear());
        checkTwoClothes(lower, l.getLowerWear());
        checkTwoClothes(foot, l.getFootWear());
    }
}
