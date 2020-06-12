package leetcodeEasy;

public class BestTimeToBuyAndSellStock {

	// Time Complexity: O(n)
	// Space Complexity: O(1)

	public int bestTimeToBuyAndSellStock(int[] prices) {

		int currentMaximumValue = 0;
		int maximumValueFoundSoFar = 0;

		for (int i = 1; i < prices.length; i++) {

			currentMaximumValue = Math.max(0, currentMaximumValue += prices[i] - prices[i - 1]);
			maximumValueFoundSoFar = Math.max(currentMaximumValue, maximumValueFoundSoFar);
		}
		return maximumValueFoundSoFar;
	}

	public static void main(String[] args) {

		BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

		System.out.println(bestTimeToBuyAndSellStock.bestTimeToBuyAndSellStock(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

}
