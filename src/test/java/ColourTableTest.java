import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColourTableTest {

    @Test
    void testConstructorSavesVar(){
        ColourTable table = new ColourTable(4);
        assertEquals(4,table.getColourNum());
    }

    @Test
    void throwsExceptionOver1024(){
        assertThrows(InvalidPaletteNumberException.class,
                () -> new ColourTable(1025));
    }

    @Test
    void throwsExceptionBelow2(){
        assertThrows(InvalidPaletteNumberException.class,
                () -> new ColourTable(1));
    }

    @Test
    void throwsExceptionWhenNotPower2(){
        assertThrows(InvalidPaletteNumberException.class,
                () -> new ColourTable(7));
    }

    @Test
    void createsByteMatrixOfGivenLength(){
        ColourTable table = new ColourTable(8);
        assertEquals(8, table.getPalette().length);
    }

    @Test
    void eachElementOfMatrixShouldHaveSize3(){
        ColourTable table = new ColourTable(8);
        byte[][] palette = table.getPalette();
        assertEquals(3, palette[0].length);
    }

    @Test
    void addThrowsExceptionWhenValuesAbove255(){
        ColourTable table = new ColourTable(8);
        assertThrows(InvalidRGBValueException.class,
                () -> table.add(256,4,4));
        assertThrows(InvalidRGBValueException.class,
                () -> table.add(4,256,4));
        assertThrows(InvalidRGBValueException.class,
                () -> table.add(4,4,256));
    }

    @Test
    void addThrowsExceptionWhenValuesBelow0(){
        ColourTable table = new ColourTable(8);
        assertThrows(InvalidRGBValueException.class,
                () -> table.add(-5,4,4));
        assertThrows(InvalidRGBValueException.class,
                () -> table.add(4,-5,4));
        assertThrows(InvalidRGBValueException.class,
                () -> table.add(4,4,-5));
    }

    @Test
    void addIncreasesPaletteIndexBy1(){
        ColourTable table = new ColourTable(4);
        table.add(3,3,3);
        assertEquals(1, table.paletteIndex);
    }

    @Test
    void rgbByteValuesAddedToPalette(){
        ColourTable table = new ColourTable(8);
        table.add(142, 231, 9);
        assertEquals((byte) 142, table.palette[0][0]);
        assertEquals((byte) 231, table.palette[0][1]);
        assertEquals((byte) 9, table.palette[0][2]);
    }

    @Test
    void exceedingPaletteCapacityThrowsException(){
        ColourTable table = new ColourTable(2);
        table.add(1,2,3);
        table.add(4,5,6);
        assertThrows(ExceededPaletteMaximumException.class,
                () -> table.add(7,8,9));
    }
}
