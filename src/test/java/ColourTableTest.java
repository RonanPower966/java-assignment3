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
}
