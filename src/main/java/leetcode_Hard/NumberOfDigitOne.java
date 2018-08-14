package leetcode_Hard;

/*233 Given an integer n, count the total number of digit 1 appearing in all
non-negative integers less than or equal to n.
Input: 13			Output: 6 
Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13				 */

public class NumberOfDigitOne {
	public int countDigitOne(int intInput) {

		int ones = 0;

		for (long longA = 1; longA <= intInput; longA *= 10) {
			ones += (intInput / longA + 8) / 10 * longA + (
					intInput / longA % 10 == 1 ? 
							intInput % longA + 1 : 0);
		}
		return ones;
	}
}
