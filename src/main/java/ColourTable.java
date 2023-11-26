public class ColourTable {
    private final int colourNum;

    public ColourTable(int num) {
        this.colourNum = num;

    }

    public int getColourNum() {
        return this.colourNum;
    }

    private void checkColourNum() {
        if (this.colourNum < 2 || this.colourNum > 1024) {

        }
    }
}
