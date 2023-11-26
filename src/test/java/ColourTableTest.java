import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColourTableTest {

    @Test
    void TestConstructor(){
        ColourTable table = new ColourTable(4);
        assertEquals(4,table.getColourNum());
    }

    @Test
    void TestColourNum(){
//        ColourTable table = new ColourTable(1026);
        assertThrows(InvalidPaletteNumberException.class,
                () -> {
                    ColourTable table = new ColourTable(1026);
                });
    }
}
