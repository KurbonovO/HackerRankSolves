package leetcodeEasy;

public class HouseRobber {

	public int houseRobber(int[] nums) {

		int[] dp = new int[nums.length + 1];
		dp[0] = 0;
		dp[1] = nums[0];

		for (int i = 1; i < nums.length; i++) {

			int value = nums[i];
			dp[i + 1] = Math.max(dp[i], dp[i - 1] + value);

		}
		return dp[nums.length];
	}

	public static void main(String[] args) {

		HouseRobber houseRobber = new HouseRobber();
		System.out.println(houseRobber.houseRobber(new int[] { 2, 7, 9, 3, 1 }));
	}

}
