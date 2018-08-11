package leetcode_Medium;

/*738 Given a non-negative integer N, find the largest number that is less than
or equal to N with monotone increasing digits. (Recall that an integer has
monotone increasing digits if and only if each pair of adjacent digits x and y
satisfy x <= y.)
Input: N = 10		Output: 9
Input: N = 1234		Output: 1234
Input: N = 332		Output: 299												 */

public class MonotoneIncreasingDigits {
	public int monotoneIncreasingDigits(int intNInput) {

		char[] chars = Integer.toString(intNInput).toCharArray();

		int marker = chars.length;

		for (int i = chars.length - 1; i > 0; i--) {

			if (chars[i] - '0' < chars[i - 1] - '0') {
				marker = i;
				chars[i - 1] -= 1;
			}
		}

		for (int i = marker; i < chars.length; i++) {
			chars[i] = '9';
		}
		return Integer.valueOf(new String(chars));
	}
}
