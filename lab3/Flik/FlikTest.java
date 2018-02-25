import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void testFlik1() {
        boolean actual = Flik.isSameNumber(127,127);
        assertEquals(true, actual);
    }
    @Test
    public void testFlik() {
        boolean actual = Flik.isSameNumber(128,128);
        assertEquals(true, actual);
    }
}
