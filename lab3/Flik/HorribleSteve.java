public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; i+=1, j+=1) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}

/**
*This is actually an error with the Flik.isSameNumber(a,b) method as seen with
 * the tests for 127 and 128 in FlikTest.java.
 *
 */