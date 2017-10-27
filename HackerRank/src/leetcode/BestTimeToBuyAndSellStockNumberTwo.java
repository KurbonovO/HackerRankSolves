package leetcode;

/*Say you have an array for which the i^th element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
transactions at the same time (ie, you must sell the stock before you buy again)*/

public class BestTimeToBuyAndSellStockNumberTwo {

	public int maxProfit(int[] prices) {
		return calculate(prices, 0);
	}

	public int calculate(int prices[], int s) {

		if (s >= prices.length)
			return 0;

		int max = 0;
		for (int start = s; start < prices.length; start++) {
			
			int maxprofit = 0;
			
			for (int i = start + 1; i < prices.length; i++) {
				
				if (prices[start] < prices[i]) {
					int profit = calculate(prices, i + 1) + prices[i] - prices[start];
					
					if (profit > maxprofit)
						maxprofit = profit;
				}
			}
			if (maxprofit > max)
				max = maxprofit;
		}
		return max;
	}
}
