package leetcode_Hard;

import java.util.Arrays;

/*891 Given an array of integers A, consider all non-empty subsequences of A.
For any sequence S, let the width of S be the difference between the maximum
and minimum element of S. Return the sum of the widths of all subsequences of A
As the answer may be very large, return the answer modulo 10^9 + 7.
Input: [2,1,3]				Output: 6
Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2. The sum of these widths is 6
*/

public class SumOfSubsequenceWidths {
	public int sumSubseqWidths(int[] A) {

		Arrays.sort(A);
		long c = 1;
		long result = 0;
		long mod = (long) 1e9 + 7;

		for (int i = 0; i < A.length; ++i, c = (c << 1) % mod) {
			result = (result + A[i] * c - A[A.length - i - 1] * c) % mod;
		}
		return (int) ((result + mod) % mod);
	}
}
