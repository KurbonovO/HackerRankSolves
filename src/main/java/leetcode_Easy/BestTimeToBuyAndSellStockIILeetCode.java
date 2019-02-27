package leetcode_Easy;

public class BestTimeToBuyAndSellStockIILeetCode {
	public int bestTimeToBuyAndSellStockIILeetCode(int[] arr) {

		int total = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i + 1] > arr[i]) {

				total += arr[i + 1] - arr[i];
			}
		}
		return total;
	}

	public static void main(String[] args) {

		BestTimeToBuyAndSellStockIILeetCode bestTimeToBuyAndSellStockIILeetCode = new BestTimeToBuyAndSellStockIILeetCode();

		int[] arr = { 7, 6, 5, 4, 3, 2, 1 };

		System.out.println(bestTimeToBuyAndSellStockIILeetCode.bestTimeToBuyAndSellStockIILeetCode(arr));

	}

}
