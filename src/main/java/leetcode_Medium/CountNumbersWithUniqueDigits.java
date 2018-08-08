package leetcode_Medium;

/*357 Given a non-negative integer n, count all numbers with unique digits,
x, where 0 ≤ x < 10n.
Given n = 2, return 91. 
The answer should be the total numbers in the range of 0 ≤ x < 100, excluding
[11,22,33,44,55,66,77,88,99]												 */

public class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int intNInput) {

		if (intNInput == 0) {
			return 1;
		}

		int intAOutput = 10;
		int uniqueDigits = 9;
		int availableNumber = 9;

		while (intNInput-- > 1 && availableNumber > 0) {
			uniqueDigits = uniqueDigits * availableNumber;
			intAOutput += uniqueDigits;
			availableNumber--;
		}
		return intAOutput;
	}
}
