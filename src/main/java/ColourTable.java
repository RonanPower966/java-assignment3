import java.util.HashMap;

public class ColourTable {
    private final int colourNum;
    byte[][] palette;
    int paletteIndex = 0;

    HashMap<String, Integer> colourHashMap = new HashMap<>();

    public ColourTable(int num) {
        if (num < 2 || num > 1024) {
            throw new InvalidPaletteNumberException("Number must be between 2 and 1024 inclusive");
        }
        //Checks if num is a power of 2 by continuously dividing and getting the modulo of 2 until the number becomes 1.
        int tempnum = num;
        while (tempnum > 1) {
            if (tempnum % 2 != 0) {
                throw new InvalidPaletteNumberException("Number must be a power of 2");
            }
            tempnum = tempnum / 2;
        }
        this.colourNum = num;
        this.palette = new byte[num][3];

    }

    public void add(int r, int g, int b) {
        //If next index added would be out of bounds
        if (this.paletteIndex >= this.palette.length) {
            throw new ExceededPaletteMaximumException("Exceeded maximum palette capacity");
        }

        //RGB values can only be between 0 and 255
        if (r > 255 || g > 255 || b > 255 || r < 0 || g < 0 || b < 0) {
            throw new InvalidRGBValueException("RGB values must be between 0 and 255 inclusive.");
        }
        String colour_string = "" + r + g + b;
        if (this.colourHashMap.containsKey(colour_string)) {
            throw new ColourAlreadyExistsException("Colour already exists in palette");
        }
        this.colourHashMap.put(colour_string, 1);

        this.palette[this.paletteIndex][0] = (byte) r;
        this.palette[this.paletteIndex][1] = (byte) g;
        this.palette[this.paletteIndex][2] = (byte) b;
        this.paletteIndex = this.paletteIndex + 1;

    }

    public int getColourNum() {
        return this.colourNum;
    }

    public byte[][] getPalette() {
        return this.palette;
    }
}
