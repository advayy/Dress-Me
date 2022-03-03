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
            assertEquals(0, wardrobe.getInternalWardrobe().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterMultipleItemWardrobe() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            Clothing foot = new FootWear("green", "sport", "SHOES", "Nike's");
            Clothing lower = new LowerWear("blue", "casual", "JEANS", "Levi's");
            Clothing upper = new UpperWear("pink", "casual", "TEESHIRT", "lululemon");
            Clothing head = new HeadWear("black", "fancy", "HAT", "amiri");

            wardrobe.addItem(new Clothing("green", "sport",
                    "SHOES", "Nike's"));
            wardrobe.addItem(new Clothing("blue", "casual",
                    "JEANS", "Levi's"));
            wardrobe.addItem(new Clothing("pink", "casual",
                    "TEESHIRT", "lululemon"));
            wardrobe.addItem(new Clothing("black", "fancy",
                    "HAT", "amiri"));
            wardrobe.addLook(new Looks(head, upper, lower, foot));

            JsonWriter writer = new JsonWriter("./data/testWriterMultipleItemWardrobe.json");
            writer.open();
            writer.write(wardrobe);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterMultipleItemWardrobe.json");
            wardrobe = reader.read();
            ArrayList<Clothing> clothesList = wardrobe.getInternalWardrobe();
            ArrayList<Looks> looksList = wardrobe.getInternalLooks();
            assertEquals(4, clothesList.size());
            checkClothing(clothesList.get(0),"Nike's", "sport", "SHOES", "green");
            checkClothing(clothesList.get(1),"Levi's", "casual", "JEANS", "blue");
            checkClothing(clothesList.get(2),"lululemon", "casual", "TEESHIRT", "pink");
            checkClothing(clothesList.get(3),"amiri", "fancy", "HAT", "black");

            assertEquals(1, looksList.size());
            checkLook(looksList.get(0), head, upper, lower, foot);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
