//import java.util.LinkedList;

public class Palindrome {

    /* Given a String, wordToDeque should return a Deque where the characters appear in the same order as in the String.
    /* E.g., if the word is 'persiflage', then the returned Deque should have p at the front, followed by e...
     */
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> wtDLL = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            char j = word.charAt(i);
            wtDLL.addLast(j);
        }
        return wtDLL;
    }

    /* Should return true if the given word is a palindrome, and false otherwise.
    /*  Any word of length 1 or 0 is a palindrome.
     */
    public boolean isPalindrome(String word) {
        Deque<Character> iPDLL = wordToDeque(word);
        return isPalindromeHelper(iPDLL);
    }

    private boolean isPalindromeHelper(Deque word) {
        if (word.size() <= 1) {
            return true;
        }
        char first = (char) word.removeFirst();
        char last = (char) word.removeLast();

        if (first == last) {
            return isPalindromeHelper(word);
        }
        return false;
    }

    /* Returns true if the word is a palindrome acc. to the cc test.
    /* See CharacterComparator interface.
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> oBo = wordToDeque(word);
        return oBoHelper(oBo, cc);
    }

    private boolean oBoHelper(Deque word, CharacterComparator cc) {
        if (word.size() <= 1) {
            return true;
        }
        char first = (char) word.removeFirst();
        char last = (char) word.removeLast();

        if (cc.equalChars(first, last)) {
            return oBoHelper(word, cc);
        }
        return false;
    }
}
