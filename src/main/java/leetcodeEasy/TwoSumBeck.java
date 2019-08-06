package leetcodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumBeck {

	public static int[] twoSumBeck(int[] arr, int target) {

		int[] output = new int[2];

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] + arr[j] == target) {

					output[0] = i;
					output[1] = j;
				}
			}
		}
		return output;
	}

	public static int[] twoSumLeetCode(int[] numbers, int target) {

		int[] result = new int[2];

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {

			if (map.containsKey(target - numbers[i])) {

				result[1] = i + 1;
				result[0] = map.get(target - numbers[i]);

				return result;
			}
			map.put(numbers[i], i + 1);
		}
		return result;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 7, 11, 15 };
		int target = 9;

		System.out.println(Arrays.toString(TwoSumBeck.twoSumBeck(arr, target)));
		
		System.out.println(Arrays.toString(TwoSumBeck.twoSumLeetCode(arr, target)));
	}

}
