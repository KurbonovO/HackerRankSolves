package leetcode_Medium;

/*518 You are given coins of different denominations and a total amount of
money. Write a function to compute the number of combinations that make up that
amount. You may assume that you have infinite number of each kind of coin.
Input: amount = 5, coins = [1, 2, 5]		Output: 4
there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Input: amount = 3, coins = [2]				Output: 0
the amount of 3 cannot be made up just with coins of 2.
Input: amount = 10, coins = [10]			Output: 1 						 */

public class CoinChangeTwo {
	public int change(int amount, int[] coins) {

		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int coin : coins) {

			for (int i = coin; i <= amount; i++) {

				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}
}
