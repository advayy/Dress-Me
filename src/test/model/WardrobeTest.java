package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WardrobeTest {

    Clothing hat;
    Clothing shirt;
    Clothing pant;
    Clothing shoe;
    Wardrobe userTest;


    @BeforeEach
    public void before() {
        hat = new HeadWear("Red", "Formal", "Hat", "Top Hat");
        shirt = new UpperWear("Blue", "Sports", "Shirt","Nike Tee");
        pant = new LowerWear("Green", "Casual", "Shorts", "Levi's");
        shoe = new FootWear("Black", "Formal","Shoes","Amiri");
        userTest = new Wardrobe();
    }

    @Test
    void addItemTest() {
        assertTrue(userTest.addItem(hat));
        assertTrue(userTest.addItem(shirt));
        assertTrue(userTest.addItem(pant));
        assertTrue(userTest.addItem(shoe));
    }

    @Test
    void removeItemTest() {
        userTest.addItem(shoe);
        assertTrue(userTest.removeItem(0));
    }

    @Test
    void getClothesOfGenreTest() {
        userTest.addItem(hat);
        userTest.addItem(shirt);
        userTest.addItem(pant);
        userTest.addItem(shoe);

        ArrayList<Clothing> test = new ArrayList<Clothing>();
        test.add(hat);
        test.add(shoe);
        assertEquals(userTest.getClothesOfApparelGenre("Formal"), test);

        ArrayList<Clothing> test2 = new ArrayList<Clothing>();
        test2.add(shirt);
        assertEquals(userTest.getClothesOfApparelGenre("Sports"), test2);

        ArrayList<Clothing> test3 = new ArrayList<Clothing>();
        test3.add(pant);
        assertEquals(userTest.getClothesOfApparelGenre("Casual"), test3);


        assertTrue(userTest.getClothesOfApparelGenre("imaginary").isEmpty());
    }

    @Test
    void getClothesOfApparelColourTest() {
        userTest.addItem(hat);
        userTest.addItem(shirt);
        userTest.addItem(pant);
        userTest.addItem(shoe);

        ArrayList<Clothing> test = new ArrayList<Clothing>();
        test.add(hat);
        assertEquals(userTest.getClothesOfColour("Red"), test);

        ArrayList<Clothing> test2 = new ArrayList<Clothing>();
        test2.add(pant);
        assertEquals(userTest.getClothesOfColour("Green"), test2);

        ArrayList<Clothing> test3 = new ArrayList<Clothing>();
        test3.add(shoe);
        assertEquals(userTest.getClothesOfColour("Black"), test3);

        assertTrue(userTest.getClothesOfApparelGenre("imaginary").isEmpty());
    }
}