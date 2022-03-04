package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClothingTest {
   private static final Colour RED = new Colour(255, 0, 0);
   private static final Colour BLUE = new Colour(0, 0, 255);
   private static final Colour GREEN = new Colour(0, 255, 0);
   private static final Colour BLACK = new Colour(0, 0, 0);

    @Test
    public void ClothingTest(){
       Clothing hat = new HeadWear(RED, "Formal", "Hat", "Top Hat");
       Clothing shirt = new UpperWear(BLUE, "Sports", "Shirt","Nike Tee");
       Clothing pant = new LowerWear(GREEN, "Casual", "Shorts", "Levi's");
       Clothing shoe = new FootWear(BLACK, "Formal","Shoes","Amiri");

       String[] acceptableItemsForHeadWear = {"GLASSES", "HAT", "HEADBAND"};
       String[] acceptableItemsForUpperWear = {"TEESHIRT", "SHIRT", "JACKET", "SWEATER"};
       String[] acceptableItemsForLowerWear = {"PANTS", "SHORTS", "JEANS"};
       String[] acceptableItemsForFootWear = {"SHOES", "SLIPPERS"};

       assertEquals(acceptableItemsForHeadWear[0], HeadWear.getAcceptableItems()[0]);
       assertEquals(acceptableItemsForHeadWear[1], HeadWear.getAcceptableItems()[1]);
       assertEquals(acceptableItemsForHeadWear[2], HeadWear.getAcceptableItems()[2]);

       assertEquals(acceptableItemsForUpperWear[0], UpperWear.getAcceptableItems()[0]);
       assertEquals(acceptableItemsForUpperWear[1], UpperWear.getAcceptableItems()[1]);
       assertEquals(acceptableItemsForUpperWear[2], UpperWear.getAcceptableItems()[2]);
       assertEquals(acceptableItemsForUpperWear[3], UpperWear.getAcceptableItems()[3]);

       assertEquals(acceptableItemsForLowerWear[0], LowerWear.getAcceptableItems()[0]);
       assertEquals(acceptableItemsForLowerWear[1], LowerWear.getAcceptableItems()[1]);
       assertEquals(acceptableItemsForLowerWear[2], LowerWear.getAcceptableItems()[2]);

       assertEquals(acceptableItemsForFootWear[0], FootWear.getAcceptableItems()[0]);
       assertEquals(acceptableItemsForFootWear[1], FootWear.getAcceptableItems()[1]);

       // Tests for Hat
       assertEquals(1, hat.getIndexNo());
       assertEquals(RED, hat.getPieceColour());
       assertEquals("Formal", hat.getPieceGenre());
       assertEquals("Hat", hat.getPieceSubtype());
       assertEquals("Top Hat", hat.getPieceName());

       assertEquals(2, shirt.getIndexNo());
       assertEquals(BLUE, shirt.getPieceColour());
       assertEquals("Sports", shirt.getPieceGenre());
       assertEquals("Shirt", shirt.getPieceSubtype());
       assertEquals("Nike Tee", shirt.getPieceName());

       assertEquals(3, pant.getIndexNo());
       assertEquals(GREEN, pant.getPieceColour());
       assertEquals("Casual", pant.getPieceGenre());
       assertEquals("Shorts", pant.getPieceSubtype());
       assertEquals("Levi's", pant.getPieceName());

       assertEquals(4, shoe.getIndexNo());
       assertEquals(BLACK, shoe.getPieceColour());
       assertEquals("Formal", shoe.getPieceGenre());
       assertEquals("Shoes", shoe.getPieceSubtype());
       assertEquals("Amiri", shoe.getPieceName());
    }
}