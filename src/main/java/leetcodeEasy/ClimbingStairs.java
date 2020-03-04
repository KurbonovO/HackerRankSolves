package leetcodeEasy;

public class ClimbingStairs {

	public int climbingStairs(int n) {

		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}

		int oneStepBefore = 2;
		int twoStepBefore = 1;
		int allWay = 0;

		for (int i = 2; i < n; i++) {

			allWay = oneStepBefore + twoStepBefore;
			twoStepBefore = oneStepBefore;
			oneStepBefore = allWay;
		}
		return allWay;
	}

	public int climbStairsTimeOn(int n) {

		if (n == 1) {

			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {

		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println(climbingStairs.climbingStairs(4));
		System.out.println(climbingStairs.climbStairsTimeOn(4));
	}
}
