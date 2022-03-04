package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LooksTest {
    private static final Colour RED = new Colour(255, 0, 0);
    private static final Colour BLUE = new Colour(0, 0, 255);
    private static final Colour GREEN = new Colour(0, 255, 0);
    private static final Colour BLACK = new Colour(0, 0, 0);


    @Test
    public void LooksTest() {
        Clothing hat = new HeadWear(RED, "Formal", "Hat", "Top Hat");
        Clothing shirt = new UpperWear(BLUE, "Sports", "Shirt","Nike Tee");
        Clothing pant = new LowerWear(GREEN, "Casual", "Shorts", "Levi's");
        Clothing shoe = new FootWear(BLACK, "Formal","Shoes","Amiri");
        Looks look1 = new Looks(hat, shirt, pant, shoe);
        Looks look2 = new Looks(hat, shirt, pant, shoe);

        assertEquals(1, look1.getIndexNo());
        assertEquals(2, look2.getIndexNo());
        assertEquals(hat, look1.getHeadWear());
        assertEquals(shirt, look1.getUpperWear());
        assertEquals(pant, look1.getLowerWear());
        assertEquals(shoe, look1.getFootWear());

    }
}
