package leetcode_Medium;

/*869 Starting with a positive integer N, we reorder the digits in any order
(including the original order) such that the leading digit is not zero. Return
true if and only if we can do this in a way such that the resulting number is a
power of 2.
Input: 1		Output: true
Input: 10		Output: false
Input: 16		Output: true
Input: 24		Output: false
Input: 46		Output: true												 */

public class ReorderedPowerOfTwo {
	public boolean reorderedPowerOf2(int N) {

		long c = counter(N);

		for (int i = 0; i < 32; i++) {

			if (counter(1 << i) == c) {

				return true;
			}
		}
		return false;
	}

	public long counter(int N) {

		long result = 0;

		for (; N > 0; N /= 10) {
			result += (int) Math.pow(10, N % 10);
		}
		return result;
	}
}
