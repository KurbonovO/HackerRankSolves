package leetcode_Easy;

import java.util.Arrays;

public class TwoSumBeck {
	public int[] twoSum(int[] input, int target) {

		int[] output = new int[2];

		for (int i = 0; i < input.length; i++) {

			for (int j = i + 1; j < input.length; j++) {

				if (input[i] + input[j] == target) {

					output[0] = i;
					output[1] = j;
					return output;
				}
			}
		}
		return output;
	}

	public static void main(String[] args) {

		TwoSumBeck TwoSumBeck = new TwoSumBeck();
		int[] arr = new int[4];
		arr[0] = 2;
		arr[1] = 7;
		arr[2] = 11;
		arr[3] = 15;
		System.out.println(Arrays.toString(TwoSumBeck.twoSum(arr, 9)));
	}
}
