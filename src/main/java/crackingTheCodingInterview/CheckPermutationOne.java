package crackingTheCodingInterview;

import java.util.Arrays;

/**
 * Should ask if: case sensative. if whitespace is significant. fast way is if
 * two strings have different lenght.
 */

public class CheckPermutationOne {
	public boolean checkPermutationOne(String A, String B) {

		if (A.length() != B.length()) {
			return false;
		}

		char[] charsOfStringA = A.toCharArray();
		Arrays.sort(charsOfStringA);
		A = charsOfStringA.toString();

		char[] charsOfStringB = A.toCharArray();
		Arrays.sort(charsOfStringB);
		B = charsOfStringB.toString();

		return A.equals(B);
	}
}
