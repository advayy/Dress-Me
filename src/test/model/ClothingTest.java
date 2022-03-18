package model;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.image.ImagingOpException;

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

    @Test
   public void getImageTests() {
       Colour c = new Colour(0,0,0);
       Clothing h0 = new HeadWear(c, "x", "GLASSES", "x");
       Clothing h1 = new HeadWear(c, "x", "HAT", "x");
       Clothing h2 = new HeadWear(c, "x", "HEADBAND", "x");

       Clothing u0 = new UpperWear(c, "x", "TEESHIRT", "x");
       Clothing u1 = new UpperWear(c, "x", "SHIRT", "x");
       Clothing u2 = new UpperWear(c, "x", "JACKET", "x");
       Clothing u3 = new UpperWear(c, "x", "SWEATER", "x");

       Clothing l0 = new LowerWear(c, "x", "PANTS", "x");
       Clothing l1 = new LowerWear(c, "x", "SHORTS", "x");
       Clothing l2 = new LowerWear(c, "x", "JEANS", "x");

       Clothing f0 = new FootWear(c, "x", "SHOES", "x");
       Clothing f1 = new FootWear(c, "x", "SLIPPERS", "x");

       assertEquals(h0.getImage("GLASSES").getImage(),
               new ImageIcon("./assets/H0_glasses.png").getImage());
       assertEquals(h1.getImage(h1.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/H1_hat.png").getImage());
       assertEquals(h2.getImage(h2.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/H2_headband.png").getImage());

       assertEquals(u0.getImage(u0.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/U0_teeshirt.png").getImage());
       assertEquals(u1.getImage(u1.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/U1_shirt.png").getImage());
       assertEquals(u2.getImage(u2.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/U3_jacket.png").getImage());
       assertEquals(u3.getImage(u3.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/U4_sweater.png").getImage());

       assertEquals(l0.getImage(l0.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/L0_pants.png").getImage());
       assertEquals(l1.getImage(l1.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/L1_shorts.png").getImage());
       assertEquals(l2.getImage(l2.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/L2_jeans.png").getImage());

       assertEquals(f0.getImage(f0.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/F0_shoe.png").getImage());
       assertEquals(f1.getImage(f1.getPieceSubtype()).getImage(),
               new ImageIcon("./assets/F1_slippers.png").getImage());
    }
}