package leetcode_Easy;

/*258 Given a non-negative integer num, repeatedly add all its digits until the
result has only one digit.
Input: 38			Output: 2 
The process is like: 3 + 8 = 11, 1 + 1 = 2 Since 2 has only one digit, 
return it */

public class AddDigits {
	public int addDigits(int intNInput) {

		if (intNInput == 0) {
			return 0;
		}
		return intNInput % 9 == 0 ? 9 : intNInput % 9;
	}
}
