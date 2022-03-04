package model;

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

    public Colour(int r, int  g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
        rgbToHSV();
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    public float getHue() {
        return  this.hue;
    }

    public float getSaturation() {
        return  this.saturation;
    }

    public float getValue() {
        return  this.value;
    }

    public float getHueRounded() {
        return  this.hueRounded;
    }

    public float getSaturationPercent() {
        return  this.saturationPercent;
    }

    public float getValuePercent() {
        return  this.valuePercent;
    }

    // Requires : already instantiated object of colour
    // Modifies : this -> hue, saturation and value
    // Effects : Converts RGB representation to HSV
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

    private void initializeHSVpercent() {
        this.hueRounded = Math.round(this.hue);
        this.saturationPercent = Math.round(this.saturation * 100);
        this.valuePercent = Math.round(this.value * 100);
    }
}
