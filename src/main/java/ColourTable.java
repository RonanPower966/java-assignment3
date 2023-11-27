public class ColourTable {
    private final int colourNum;
    byte[][] palette;

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

    public int getColourNum() {
        return this.colourNum;
    }

    public byte[][] getPalette() {
        return this.palette;
    }
}
