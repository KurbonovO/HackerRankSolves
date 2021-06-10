package leetcodeEasy;

/**
 * Time Complexity: O(n) Only a single pass is needed.
 * Space Complexity: O(1) Only two variables are used.
 */

public class BestTimeToBuyAndSellStock {

	public int bestTimeToBuyAndSellStock(int[] prices) {

		int maxCurrent = 0;
		int maxSoFar = 0;

		for (int i = 1; i < prices.length; i++) {

			maxCurrent = Math.max(0, maxCurrent += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxCurrent, maxSoFar);

		}
		return maxSoFar;
	}

}
