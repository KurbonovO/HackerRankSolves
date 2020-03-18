package leetcodeEasy;

public class BestTimeToBuyAndSellStock {

	/**
	 * Time Complexity = O(n) only single pass needed. 
	 * Space Complexity = O(1) only two variables used.
	 */
	public int maxProfit(int[] prices) {

		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < minPrice) {

				minPrice = prices[i];

			} else if (prices[i] - minPrice > maxProfit) {

				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {

		BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

		int[] input = { 7, 1, 5, 3, 6, 4 };

		System.out.println(bestTimeToBuyAndSellStock.maxProfit(input));
	}
}
