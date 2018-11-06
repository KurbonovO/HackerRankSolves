package leetcode_Medium;

import java.util.Stack;

/*907 Given an array of integers A, find the sum of min(B), where B ranges over
every (contiguous) subarray of A. Since the answer may be large, return the
answer modulo 10^9 + 7.
Input: [3,1,2,4]		Output: 17
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4],
[3,1,2,4]. Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17			 */

public class SumOfSubarrayMinimums {
	public int sumSubarrayMins(int[] A) {

		int result = 0;
		int n = A.length;
		int mod = (int) 1e9 + 7;
		int[] left = new int[n];
		int[] right = new int[n];
		Stack<int[]> stackOne = new Stack<>();
		Stack<int[]> stackTwo = new Stack<>();

		for (int i = 0; i < n; ++i) {

			int count = 1;

			while (!stackOne.isEmpty() && stackOne.peek()[0] > A[i]) {
				count += stackOne.pop()[1];
			}
			stackOne.push(new int[] { A[i], count });
			left[i] = count;
		}

		for (int i = n - 1; i >= 0; --i) {

			int count = 1;

			while (!stackTwo.isEmpty() && stackTwo.peek()[0] >= A[i]) {
				count += stackTwo.pop()[1];
			}
			stackTwo.push(new int[] { A[i], count });
			right[i] = count;
		}

		for (int i = 0; i < n; ++i) {
			result = (result + A[i] * left[i] * right[i]) % mod;
		}
		return result;
	}
}
