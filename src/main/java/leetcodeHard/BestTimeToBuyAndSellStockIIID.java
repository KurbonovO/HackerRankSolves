package leetcodeHard;

public class BestTimeToBuyAndSellStockIIID {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int totalK = 2;
		int[][] dp = new int[totalK + 1][prices.length];
		for (int k = 1; k <= totalK; k++) {// profit = 0 when k = 0
			for (int i = 1; i < prices.length; i++) {
				int maxProfitSellOnDayI = Math.max(0, prices[i] - prices[0]);// buy on day 0, sell on day i
				for (int j = 1; j < i; j++) {// buy on day j, sell on day i
					maxProfitSellOnDayI = Math.max(maxProfitSellOnDayI, dp[k - 1][j - 1] + prices[i] - prices[j]);
				}
				dp[k][i] = Math.max(dp[k][i - 1], maxProfitSellOnDayI);// sell on day i OR not
			}
		}
		return dp[totalK][prices.length - 1];
	}

}
