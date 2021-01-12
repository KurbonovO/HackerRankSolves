package leetcodeEasy;

public class BestTimeToBuyAndSellStocks1 {

	public int bestTimeToBuyAndSellStocks(int[] prices) {

		int currentMaxValue = 0;
		int maxValueFoundSoFar = 0;

		for (int i = 1; i < prices.length; i++) {

			currentMaxValue = Math.max(0, currentMaxValue += prices[i] - prices[i - 1]);
			maxValueFoundSoFar = Math.max(currentMaxValue, maxValueFoundSoFar);
		}
		return maxValueFoundSoFar;
	}
	
	/**
	 * Time Complexity: O(n) Only a single pass is needed
	 * Space Complexity: O(1) Only two variables are used
	 */
	public static void main(String[] args) {
		
		BestTimeToBuyAndSellStocks1 bestTimeToBuyAndSellStocks1 = new BestTimeToBuyAndSellStocks1();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(bestTimeToBuyAndSellStocks1.bestTimeToBuyAndSellStocks(prices));
		
		// Input: [7,1,5,3,6,4]
		// Output: 5
		// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
		// Not 7-1 = 6, as selling price needs to be larger than buying price.
	}

}
