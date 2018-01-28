public class HelloNumbers {
	public static void main(String[] args) {
		int x = 0;
		int y = 1;
		while (y < 11) {
			System.out.println(x + " ");
			x = x + y;
			y = y + 1;
		}
		System.out.println();
	}
}

/* int x declares that x exists; and that it is an integer.
declare it before you use it.
in java variables have a specific type and that type CANNOT CHANGE.
this is a 'static type' language.
types are verified BEFORE THE CODE EVEN RUNS (not the same w/ python)
*/