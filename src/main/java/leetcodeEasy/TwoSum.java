package leetcodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(n)

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {

			int complement = target - numbers[i];

			if (map.containsKey(complement)) {

				return new int[] { map.get(complement), i };
			}
			map.put(numbers[i], i);
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {

		TwoSum twoSum = new TwoSum();

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 9;

		System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
	}

}
