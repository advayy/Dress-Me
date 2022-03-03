package persistence;

import model.Clothing;
import model.Wardrobe;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Reference Code from: JsonSerialization Demo
 * URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 * */
public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Wardrobe wardrobe = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWardrobe() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWardrobe.json");
        try {
            Wardrobe wardrobe = reader.read();
            assertEquals(new ArrayList<Clothing>(), wardrobe.getInternalWardrobe());
            assertEquals(0, wardrobe.getInternalWardrobe().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderMultipleItemWardrobe() {
        JsonReader reader = new JsonReader("./data/testReaderMultipleItemWardrobe.json");
        try {
            Wardrobe wardrobe = reader.read();
            ArrayList<Clothing> clothesList = wardrobe.getInternalWardrobe();
            assertEquals(4, clothesList.size());
            checkClothing(clothesList.get(0),"Nike's", "sport", "SHOES", "green");
            checkClothing(clothesList.get(1),"Levi's", "casual", "JEANS", "blue");
            checkClothing(clothesList.get(2),"lululemon", "casual", "TEESHIRT", "pink");
            checkClothing(clothesList.get(3),"amiri", "fancy", "HAT", "black");
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
