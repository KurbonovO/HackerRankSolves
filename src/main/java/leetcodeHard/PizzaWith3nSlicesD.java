package leetcodeHard;

import java.util.Arrays;

public class PizzaWith3nSlicesD {

	public int maxSizeSlices(int[] slices) {
		int m = slices.length, n = m / 3;
		int[] slices1 = Arrays.copyOfRange(slices, 0, m - 1);
		int[] slices2 = Arrays.copyOfRange(slices, 1, m);
		return Math.max(maxSum(slices1, n), maxSum(slices2, n));
	}

	int maxSum(int[] arr, int n) { // max sum when pick `n` non-adjacent elements from `arr`
		
		int m = arr.length;
		int[][] dp = new int[m + 1][n + 1]; // dp[i][j] is maximum sum which we pick `j` elements from linear array `i`
		
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i == 1) { // array has only 1 element
					dp[i][j] = arr[0]; // pick that element
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], // don't pick element `ith`
							dp[i - 2][j - 1] + arr[i - 1] // pick element `ith` -> dp[i-2][j-1] means choose `j-1`
															// elements from array `i-2` elements
					);
				}
			}
		}
		return dp[m][n];
	}

}
