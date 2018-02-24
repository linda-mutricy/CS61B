import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

   @Test
    public void testEqualChars() {
        boolean actual = offByOne.equalChars('b', 'b');
        assertFalse(actual);
    }

    @Test
    public void testEqualChars2() {
       boolean actual2 = offByOne.equalChars('z', 'a');
        assertFalse(actual2);
    }

    @Test
    public void testEqualChars3() {
        boolean actual3 = offByOne.equalChars('r', 'q');
        assertTrue(actual3);
    }
}