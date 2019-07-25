package leetcodeEasy;

public class BestTimeToBuyAndSellStockIIBeck {

	private static int stockBeck(int[] prices) {

		int total = 0;

		for (int i = 0; i < prices.length; i++) {

			for (int j = i + 1; j < prices.length; j++) {

				if (prices[i] > prices[j]) {

					i++;

				} else if (prices[i] < prices[j]) {

					total = prices[j] - prices[i];
					i++;
					j++;
				}
			}
		}
		return total;
	}

	public static int stockLeetCode(int[] prices) {

		int total = 0;

		for (int i = 0; i < prices.length - 1; i++) {

			if (prices[i] < prices[i + 1]) {

				total += prices[i + 1] - prices[i];
			}
		}
		return total;
	}

	public static void main(String[] args) {

		int[] arr = { 7, 1, 5, 3, 6, 4 };

		System.out.println(BestTimeToBuyAndSellStockIIBeck.stockBeck(arr));
		System.out.println(BestTimeToBuyAndSellStockIIBeck.stockLeetCode(arr));
	}

}
