import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTest {

    ColourTable table = new ColourTable(4);
    @Test
    void TestConstructor(){
        assertEquals(4,table.getColourNum());
    }
}
