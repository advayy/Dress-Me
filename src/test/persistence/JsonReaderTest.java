package persistence;

import model.Clothing;
import model.Wardrobe;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
            assertEquals(new ArrayList<Clothing>(), wardrobe.getUserWardrobe());
            assertEquals(0, wardrobe.getUserWardrobe().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderMultipleItemWardrobe() {
        JsonReader reader = new JsonReader("./data/testReaderMultipleItemWardrobe.json");
        try {
            Wardrobe wardrobe = reader.read();
            ArrayList<Clothing> clothesList = wardrobe.getUserWardrobe();
            assertEquals(2, clothesList.size());
            checkClothing(clothesList.get(0),"Nike's", "sport", "SHOES", "green");
            checkClothing(clothesList.get(1),"Levi's", "casual", "JEANS", "blue");
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
