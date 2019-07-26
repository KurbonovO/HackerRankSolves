package leetcodeEasy;

public class HappyNumberBeck {

	private static boolean happyNumberLeetCode(int n) {

		if (n == 1 || n == 7) {

			return true;

		} else if (n < 10) {

			return false;
		}
		int m = 0;

		while (n != 0) {

			int tail = n % 10;

			m += tail * tail;

			n = n / 10;
		}
		return happyNumberLeetCode(m);
	}
	
	public static void main(String[] args) {
		
		System.out.println(HappyNumberBeck.happyNumberLeetCode(19));
	}
}
