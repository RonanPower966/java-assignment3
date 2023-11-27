public class ColourTable {
    private final int colourNum;
    byte[][] palette;
    int paletteIndex = 0;

    public ColourTable(int num) {
        if (num < 2 || num > 1024) {
            throw new InvalidPaletteNumberException("Number must be between 2 and 1024 inclusive");
        }
        int tempnum = num;
        while (tempnum > 1) {
            if (tempnum % 2 != 0) {
                throw new InvalidPaletteNumberException("Number must be a power of 2");
            }
            tempnum = tempnum/2;
        }
        this.colourNum = num;
        this.palette = new byte[num][3];

    }

    public void add(int r, int g, int b) {
        if(r>255 || g>255 || b>255 || r<0 || g<0 || b<0) {
            throw new InvalidRGBValueException("RBG values must be between 0 and 255 inclusive.");
        }

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
