package leetcode_Easy;

/*796 We are given two strings, A and B. A shift on A consists of taking string
A and moving the leftmost character to the rightmost position. For example, 
if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and
only if A can become B after some number of shifts on A.
Input: A = 'abcde', B = 'cdeab'				Output: true
Input: A = 'abcde', B = 'abced'				Output: false                     */

public class RotateString {
	public boolean rotateString(String A, String B) {
		
		if (A.length() != B.length())
			return false;

		search : for (int s = 0; s < A.length(); ++s) {
			
			for (int i = 0; i < A.length(); ++i) {
				
				if (A.charAt((s + i) % A.length()) != B.charAt(i))
					continue search;
			}
			return true;
		}
		return false;
	}
}

/*More specifically, say we rotate A by s. Then, instead of A[0], A[1], A[2],
..., we have A[s], A[s+1], A[s+2], ...; and we should check that A[s] == B[0],
A[s+1] == B[1], A[s+2] == B[2], etc.										  */
