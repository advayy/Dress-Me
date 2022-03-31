package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Reference Code from: JsonSerialization Demo
 * URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 * */
public class JsonReaderTest extends JsonTest{
    private static final Colour RED = new Colour(255, 0, 0);
    private static final Colour BLUE = new Colour(0, 0, 255);
    private static final Colour GREEN = new Colour(0, 255, 0);
    private static final Colour BLACK = new Colour(0, 0, 0);

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader();
        try {
            Wardrobe wardrobe = reader.read("./data/noSuchFile.json");
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWardrobe() {
        JsonReader reader = new JsonReader();
        try {
            Wardrobe wardrobe = reader.read("./data/testReaderEmptyWardrobe.json");
            assertEquals(new ArrayList<Clothing>(), wardrobe.getInternalWardrobe());
            assertEquals(0, wardrobe.getInternalWardrobe().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderMultipleItemWardrobe() {
        JsonReader reader = new JsonReader();
        try {
            Wardrobe wardrobe = reader.read("./data/testReaderMultipleItemWardrobe.json");
            ArrayList<Clothing> clothesList = wardrobe.getInternalWardrobe();
            assertEquals(4, clothesList.size());
            checkClothing(clothesList.get(0),"Nike's", "sport", "SHOES", GREEN);
            checkClothing(clothesList.get(1),"Levi's", "casual", "JEANS", BLUE);
            checkClothing(clothesList.get(2),"lululemon", "casual", "TEESHIRT", RED);
            checkClothing(clothesList.get(3),"amiri", "fancy", "HAT", BLACK);


            Clothing foot = new FootWear(GREEN, "sport", "SHOES", "Nike's");
            Clothing lower = new LowerWear(BLUE, "casual", "JEANS", "Levi's");
            Clothing upper = new UpperWear(RED, "casual", "TEESHIRT", "lululemon");
            Clothing head = new HeadWear(BLACK, "fancy", "HAT", "amiri");


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
