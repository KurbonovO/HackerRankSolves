package leetcodeEasy;

public class ReverseInteger {

	/**
	 * Time Complexity: O(log(x))
	 * Space Complexity: O(1)
	 */
	public int reverseInteger(int input) {

		int reverse = 0;

		while (input != 0) {

			int pop = input % 10;
			input /= 10;

			if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) {

				return 0;
			}
			if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) {

				return 0;
			}
			reverse = reverse * 10 + pop;
		}
		return reverse;
	}

	public static void main(String[] args) {

		ReverseInteger reverseInteger = new ReverseInteger();

		System.out.println(reverseInteger.reverseInteger(321));
	}
}
