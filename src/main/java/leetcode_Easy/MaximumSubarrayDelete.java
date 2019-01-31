package leetcode_Easy;

public class MaximumSubarrayDelete {
	public int maxSubArray(int[] A) {
		
		int n = A.length;
		// dp[i] means the maximum subarray ending with A[i];
		int[] dp = new int[n];
		dp[0] = A[0];
		int max = dp[0];

		for (int i = 1; i < n; i++) {
			dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
