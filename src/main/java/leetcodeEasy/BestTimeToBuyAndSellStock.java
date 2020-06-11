package leetcodeEasy;

public class BestTimeToBuyAndSellStock {
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)

	public int bestTimeToBuyAndSellStock(int[] prices) {

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

		System.out.println(bestTimeToBuyAndSellStock.bestTimeToBuyAndSellStock(new int[] { 0, 6, -3, 7 }));
	}

}
