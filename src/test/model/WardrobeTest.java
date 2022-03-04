package model;

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
    private static final Colour RED = new Colour(255, 0, 0);
    private static final Colour BLUE = new Colour(0, 0, 255);
    private static final Colour GREEN = new Colour(0, 255, 0);
    private static final Colour BLACK = new Colour(0, 0, 0);

    @BeforeEach
    public void before() {
        hat = new HeadWear(RED, "Formal", "Hat", "Top Hat");
        shirt = new UpperWear(BLUE, "Sports", "Shirt","Nike Tee");
        pant = new LowerWear(GREEN, "Casual", "Shorts", "Levi's");
        shoe = new FootWear(BLACK, "Formal","Shoes","Amiri");
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
    public void getUserWardrobeTest() {
        userTest.addItem(hat);
        userTest.addItem(shirt);
        userTest.addItem(pant);
        userTest.addItem(shoe);
        ArrayList<Clothing> testList = new ArrayList<Clothing>();
        testList.add(hat);
        testList.add(shirt);
        testList.add(pant);
        testList.add(shoe);
        assertEquals(userTest.getInternalWardrobe(), testList);
    }

    @Test
    void removeLookItemTest() {
        userTest.addLook(new Looks(hat, shirt, pant, shoe));
        assertTrue(userTest.removeLookItem(0));
    }

    @Test
    void removeLookItemByIndexTest() {
        // clothes code
        Looks look1 = new Looks(hat, shirt, pant, shoe);
        Looks look2 = new Looks(hat, shirt, pant, shoe);

        userTest.addLook(look1);
        userTest.addLook(look2);

        assertTrue(userTest.removeLookItemByIndex(look2.getIndexNo()));
        assertTrue(userTest.removeLookItemByIndex(look1.getIndexNo()));
        assertFalse(userTest.removeItemByIndex(100));

        Wardrobe otherWardrobe = new Wardrobe();
        assertFalse(otherWardrobe.removeLookItemByIndex(look1.getIndexNo()));
        otherWardrobe.addLook(look1);
        assertTrue(otherWardrobe.removeLookItemByIndex(look1.getIndexNo()));
        assertFalse(otherWardrobe.removeItemByIndex(100));
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
        assertEquals(test, userTest.getClothesOfColour(RED));

        ArrayList<Clothing> test2 = new ArrayList<Clothing>();
        test2.add(pant);
        assertEquals(userTest.getClothesOfColour(GREEN), test2);

        ArrayList<Clothing> test3 = new ArrayList<Clothing>();
        test3.add(shoe);
        assertEquals(userTest.getClothesOfColour(BLACK), test3);

        assertTrue(userTest.getClothesOfApparelGenre("imaginary").isEmpty());
    }

    @Test
    public void removeItemByIndexTest() {
        userTest.addItem(hat);
        userTest.addItem(shirt);
        userTest.addItem(pant);
        userTest.addItem(shoe);
        Clothing c = new Clothing(BLACK,"word","word","word");

        assertTrue(userTest.removeItemByIndex(hat.getIndexNo()));
        assertTrue(userTest.removeItemByIndex(shoe.getIndexNo()));
        assertFalse(userTest.removeItemByIndex(c.getIndexNo()));

        userTest.addItem(hat);
        userTest.addItem(hat);
        assertEquals(userTest.removeItemByIndex(hat.getIndexNo()), userTest.removeItem(0));
    }

    @Test
    void getClothesByTypeTest() {
        userTest.addItem(hat);
        userTest.addItem(shirt);
        userTest.addItem(pant);
        userTest.addItem(shoe);

        ArrayList<Clothing> headList = new ArrayList<Clothing>();
        headList.add(hat);
        ArrayList<Clothing> upperList = new ArrayList<Clothing>();
        upperList.add(shirt);
        ArrayList<Clothing> lowerList = new ArrayList<Clothing>();
        lowerList.add(pant);
        ArrayList<Clothing> footList = new ArrayList<Clothing>();
        footList.add(shoe);

        assertEquals(userTest.getClothesByType(1), headList);
        assertEquals(userTest.getClothesByType(2), upperList);
        assertEquals(userTest.getClothesByType(3), lowerList);
        assertEquals(userTest.getClothesByType(4), footList);
    }

    @Test
    void getClothesByIndexTest() {
        userTest.addItem(hat); // 1
        userTest.addItem(shirt); // 2
        userTest.addItem(pant); // 3
        userTest.addItem(shoe); // 4

        assertEquals(hat, userTest.getClothesByIndex(hat.getIndexNo()));
        assertEquals(shirt, userTest.getClothesByIndex(shirt.getIndexNo()));
        assertEquals(pant, userTest.getClothesByIndex(pant.getIndexNo()));
        assertEquals(shoe, userTest.getClothesByIndex(shoe.getIndexNo()));

        assertNull(userTest.getClothesByIndex(100));
    }


}