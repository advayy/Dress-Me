package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColourTest {
    private static final Colour RED = new Colour(255, 0, 0);
    private static final Colour RED2 = new Colour(255, 0, 0);
    private static final Colour BLUE = new Colour(0, 0, 255);
    private static final Colour GREEN = new Colour(0, 255, 0);
    private static final Colour WHITE = new Colour(255, 255, 255);
    private static final Colour BLACK = new Colour(0, 0, 0);

    @Test
    public void ColourTest() {
        assertEquals(255, RED.getRed());
        assertEquals(0, RED.getBlue());

        assertTrue(RED.colourEquals(RED2));
        assertFalse(RED.colourEquals(GREEN));

        assertEquals(0, RED.getHue());
        assertEquals(1, RED.getSaturation());
        assertEquals(1, RED.getValue());

        Colour cyan = new Colour(0, 255, 255);
        assertEquals(180, cyan.getHue());
        assertEquals(1, cyan.getSaturation());
        assertEquals(1, cyan.getValue());
        assertEquals(180, cyan.getHueRounded());
        assertEquals(100, cyan.getSaturationPercent());

        assertEquals(0, BLACK.getHue());
        assertEquals(0, BLACK.getSaturation());
        assertEquals(0, BLACK.getValue());

        assertEquals(0, WHITE.getHue());
        assertEquals(0, WHITE.getSaturation());
        assertEquals(1, WHITE.getValue());

        Colour maroon = new Colour(128, 0, 0);
        Colour silver = new Colour(191,191,191);
        assertEquals(0, maroon.getHue());
        assertEquals(1, maroon.getSaturation());
        assertEquals(0.501960813999176, maroon.getValue());
        assertEquals(50, maroon.getValuePercent());
        assertEquals(0, maroon.getHueRounded());
        assertEquals(100, maroon.getSaturationPercent());

        assertEquals(0, silver.getHue());
        assertEquals(0, silver.getSaturation());
        assertEquals(0.7490196228027344, silver.getValue());
        assertEquals(75, silver.getValuePercent());

        Colour RED1 = new Colour(254, 0, 0);
        Colour BLUE1 = new Colour(0, 224, 0);
        Colour GREEN1 = new Colour(0, 0, 224);

        assertFalse(RED.colourEquals(RED1));
        assertFalse(BLUE.colourEquals(BLUE1));
        assertFalse(GREEN.colourEquals(GREEN1));
    }


}
