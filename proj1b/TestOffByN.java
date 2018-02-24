import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    OffByN OffBy5 = new OffByN(5);

    @Test
    public void TestOffBy5() {
        boolean actual = OffBy5.equalChars('a', 'f');
        assertTrue(actual);
    }

    @Test
    public void TestOffBy5A() {
        boolean actual1 = OffBy5.equalChars('f', 'a');
        assertTrue(actual1);
    }

    @Test
    public void TestOffBy5B() {
        boolean actual2 = OffBy5.equalChars('f', 'h');
        assertFalse(actual2);
    }
}
