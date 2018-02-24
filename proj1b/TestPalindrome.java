import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /* You must use this palindrome, and not instantiate
    new Palindromes, or the autograder might be upset.*/

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindrome2() {
        assertFalse(palindrome.isPalindrome("Linda"));
    }

    @Test
    public void testIsPalindrome3() {
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testIsPalindrome4() {
        assertFalse(palindrome.isPalindrome("Aa"));
    }

    //TEST: OffByOne + isPalindrome
    @Test
    public void testOffByOnePalindrome() {
        CharacterComparator OffByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", OffByOne));
    }

    @Test
    public void testOffByOnePalindrome2() {
        CharacterComparator OffByOne = new OffByOne();
        assertFalse(palindrome.isPalindrome("bunny", OffByOne));
    }

    @Test
    public void testOffByOnePalindrome3() {
        CharacterComparator OffByOne = new OffByOne();
        assertFalse(palindrome.isPalindrome("racecar", OffByOne));
    }
}
