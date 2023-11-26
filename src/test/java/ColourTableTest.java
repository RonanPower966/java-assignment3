import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColourTableTest {

    @Test
    void TestConstructorSavesVar(){
        ColourTable table = new ColourTable(4);
        assertEquals(4,table.getColourNum());
    }

    @Test
    void ThrowsExceptionOver1024(){
        assertThrows(InvalidPaletteNumberException.class,
                () -> new ColourTable(1025));
    }

    @Test
    void ThrowsExceptionBelow2(){
        assertThrows(InvalidPaletteNumberException.class,
                () -> new ColourTable(1));
    }

    @Test
    void ThrowsExceptionWhenNotPower2(){
        assertThrows(InvalidPaletteNumberException.class,
                () -> new ColourTable(7));
    }
}
