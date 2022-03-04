package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LooksTest {

    @Test
    public void LooksTest() {
        Clothing hat = new HeadWear("Red", "Formal", "Hat", "Top Hat");
        Clothing shirt = new UpperWear("Blue", "Sports", "Shirt","Nike Tee");
        Clothing pant = new LowerWear("Green", "Casual", "Shorts", "Levi's");
        Clothing shoe = new FootWear("Black", "Formal","Shoes","Amiri");
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
