package persistence;

import model.Wardrobe;
import model.Clothing;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWardrobe() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWardrobe.json");
            writer.open();
            writer.write(wardrobe);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWardrobe.json");
            wardrobe = reader.read();
            assertEquals(0, wardrobe.getUserWardrobe().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterMultipleItemWardrobe() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            wardrobe.addItem(new Clothing("green", "sport",
                    "SHOES", "Nike's"));
            wardrobe.addItem(new Clothing("blue", "casual",
                    "JEANS", "Levi's"));
            JsonWriter writer = new JsonWriter("./data/testWriterMultipleItemWardrobe.json");
            writer.open();
            writer.write(wardrobe);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterMultipleItemWardrobe.json");
            wardrobe = reader.read();
            ArrayList<Clothing> clothesList = wardrobe.getUserWardrobe();
            assertEquals(2, clothesList.size());
            checkClothing(clothesList.get(0),"Nike's", "sport", "SHOES", "green");
            checkClothing(clothesList.get(1),"Levi's", "casual", "JEANS", "blue");

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
