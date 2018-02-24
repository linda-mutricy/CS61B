public class OffByN implements CharacterComparator {
    /* Implements CharacterComparator such that equalChars returns true for characters that are
    /* different by exactly n.
     */

    /* The OffByN constructor should return an object whose equalChars method returns true
    /* for characters that are off by N.
     */

    public int difference;

    public OffByN(int N) {
        difference = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == -difference || diff == difference) {
            return true;
        }
        return false;
    }
}
