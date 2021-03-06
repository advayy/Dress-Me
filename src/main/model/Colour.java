package model;


import java.util.ArrayList;
import java.util.Dictionary;

// Colour transformation formulae accessed from https://www.rapidtables.com/convert/color/rgb-to-hsv.html
public class Colour {
    //RGB must be between 0-255
    private int red;
    private int green;
    private int blue;
    private float hue; // from 0 to 360 degrees
    private float saturation; // from [0-1]
    private float value; //  from [0-1] - also called Brightness
    private int hueRounded;
    private int saturationPercent;
    private int valuePercent;

    // Builtin Static Colours
    public static final Colour WHITE = new Colour(255,255,255);
    public static final Colour BLACK = new Colour(0,0,0);
    public static final Colour RED = new Colour(255,0,0);
    public static final Colour GREEN = new Colour(0,255,0);
    public static final Colour BLUE = new Colour(0,0,255);
    public static final Colour PURPLE = new Colour(102,0,153);
    public static final Colour YELLOW = new Colour(255,255,0);
    public static final Colour ORANGE = new Colour(255,102,0);
    public static final Colour BROWN = new Colour(102,51,0);
    public static final Colour GREY = new Colour(153,153,153);
    public static final Colour CYAN = new Colour(0, 255, 255);
    public static final Colour MAROON = new Colour(128, 0, 0);
    public static final Colour SILVER = new Colour(191,191,191);

    // Requires: An integer between 0-255
    // Modifies: this
    // Effects : Instantiates all private class variables
    public Colour(int r, int  g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
        rgbToHSV();
    }

    // Effects : Returns the Red value
    public int getRed() {
        return this.red;
    }

    // Effects : Returns the Green value
    public int getGreen() {
        return this.green;
    }

    // Effects : Returns the Blue value
    public int getBlue() {
        return this.blue;
    }

    // Effects : Returns the Hue value
    public float getHue() {
        return  this.hue;
    }

    // Effects : Returns the Saturation value
    public float getSaturation() {
        return  this.saturation;
    }

    // Effects : Returns the Value/Brightness
    public float getValue() {
        return  this.value;
    }

    // Effects : Returns the Hue value rounded
    public int getHueRounded() {
        return  this.hueRounded;
    }

    // Requires: A colour
    // Effects: returns true if the colours red, green and blue values are equal
    public boolean colourEquals(Colour c) {
        return ((this.red == c.getRed()) && (this.green == c.getGreen())) && (this.blue == c.getBlue());
    }

    // Effects: returns the saturation percentage
    public float getSaturationPercent() {
        return  this.saturationPercent;
    }

    // Effects: returns the value/brightness percentage
    public float getValuePercent() {
        return  this.valuePercent;
    }

    // Requires : already instantiated object of colour
    // Modifies : this -> hue, saturation and value
    // Effects : Converts RGB representation to HSV and initialises HSV to percent
    private void rgbToHSV() {
        float base = 255;
        float redPrime = this.red / base;
        float greenPrime = this.green / base;
        float bluePrime = this.blue / base;
        float chromaMax = Math.max(Math.max(redPrime, greenPrime), bluePrime);
        float chromaMin = Math.min(Math.min(redPrime, greenPrime), bluePrime);
        float delta = chromaMax - chromaMin;
        this.value = chromaMax;// sets value
        if (chromaMax == 0) { // sets saturation
            this.saturation = 0;
        } else {
            this.saturation = delta / chromaMax;
        }
        if (delta == 0) { // sets hue on colour wheel
            this.hue = 0;
        } else if (chromaMax == redPrime) {
            this.hue = 60 * (((greenPrime - bluePrime) / delta) % 6);
        } else if (chromaMax == greenPrime) {
            this.hue = 60 * (((bluePrime - redPrime) / delta) + 2);
        } else {
            this.hue = 60 * (((redPrime - greenPrime) / delta) + 4);
        }
        initializeHSVpercent();
    }

    // Effects: creates rounded and percent values for HSV
    private void initializeHSVpercent() {
        this.hueRounded = Math.round(this.hue);
        this.saturationPercent = Math.round(this.saturation * 100);
        this.valuePercent = Math.round(this.value * 100);
    }
}
