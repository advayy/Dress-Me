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
public class JsonWriterTest extends JsonTest {

    private static final Colour RED = new Colour(255, 0, 0);
    private static final Colour BLUE = new Colour(0, 0, 255);
    private static final Colour GREEN = new Colour(0, 255, 0);
    private static final Colour BLACK = new Colour(0, 0, 0);

    @Test
    void testWriterInvalidFile() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            JsonWriter writer = new JsonWriter();
            writer.open("./data/my\0illegal:fileName.json");
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWardrobe() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            wardrobe.setName("testWriter");
            JsonWriter writer = new JsonWriter();
            writer.open("./data/testWriterEmptyWardrobe.json");
            writer.write(wardrobe);
            writer.close();

            JsonReader reader = new JsonReader();
            wardrobe = reader.read("./data/testWriterEmptyWardrobe.json");
            assertEquals(0, wardrobe.getInternalWardrobe().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterMultipleItemWardrobe() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            wardrobe.setName("testWriter");
            Clothing foot = new FootWear(GREEN, "sport", "SHOES", "Nike's");
            Clothing lower = new LowerWear(BLUE, "casual", "JEANS", "Levi's");
            Clothing upper = new UpperWear(RED, "casual", "TEESHIRT", "lululemon");
            Clothing head = new HeadWear(BLACK, "fancy", "HAT", "amiri");

            wardrobe.addItem(new Clothing(GREEN, "sport",
                    "SHOES", "Nike's"));
            wardrobe.addItem(new Clothing(BLUE, "casual",
                    "JEANS", "Levi's"));
            wardrobe.addItem(new Clothing(RED, "casual",
                    "TEESHIRT", "lululemon"));
            wardrobe.addItem(new Clothing(BLACK, "fancy",
                    "HAT", "amiri"));
            wardrobe.addOutfit(new Outfit(head, upper, lower, foot));

            JsonWriter writer = new JsonWriter();
            writer.open("./data/testWriterMultipleItemWardrobe.json");
            writer.write(wardrobe);
            writer.close();

            JsonReader reader = new JsonReader();
            wardrobe = reader.read("./data/testWriterMultipleItemWardrobe.json");
            ArrayList<Clothing> clothesList = wardrobe.getInternalWardrobe();
            ArrayList<Outfit> outfitList = wardrobe.getInternalOutfits();
            assertEquals(4, clothesList.size());
            checkClothing(clothesList.get(0),"Nike's", "sport", "SHOES", GREEN);
            checkClothing(clothesList.get(1),"Levi's", "casual", "JEANS", BLUE);
            checkClothing(clothesList.get(2),"lululemon", "casual", "TEESHIRT", RED);
            checkClothing(clothesList.get(3),"amiri", "fancy", "HAT", BLACK);

            assertEquals(1, outfitList.size());
            checkOutfit(outfitList.get(0), head, upper, lower, foot);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
