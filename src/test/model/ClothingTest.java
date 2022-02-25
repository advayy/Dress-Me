package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClothingTest {

    @Test
    public void ClothingTest(){
       Clothing hat = new HeadWear("Red", "Formal", "Hat", "Top Hat");
       Clothing shirt = new UpperWear("Blue", "Sports", "Shirt","Nike Tee");
       Clothing pant = new LowerWear("Green", "Casual", "Shorts", "Levi's");
       Clothing shoe = new FootWear("Black", "Formal","Shoes","Amiri");

       // Tests for Hat
       assertEquals("Red", hat.getPieceColour());
       assertEquals("Formal", hat.getPieceGenre());
       assertEquals("Hat", hat.getPieceSubtype());
       assertEquals("Top Hat", hat.getPieceName());

       assertEquals("Blue", shirt.getPieceColour());
       assertEquals("Sports", shirt.getPieceGenre());
       assertEquals("Shirt", shirt.getPieceSubtype());
       assertEquals("Nike Tee", shirt.getPieceName());

       assertEquals("Green", pant.getPieceColour());
       assertEquals("Casual", pant.getPieceGenre());
       assertEquals("Shorts", pant.getPieceSubtype());
       assertEquals("Levi's", pant.getPieceName());

       assertEquals("Black", shoe.getPieceColour());
       assertEquals("Formal", shoe.getPieceGenre());
       assertEquals("Shoes", shoe.getPieceSubtype());
       assertEquals("Amiri", shoe.getPieceName());
    }
}