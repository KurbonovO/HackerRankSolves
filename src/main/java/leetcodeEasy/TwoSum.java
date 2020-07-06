package leetcodeEasy;

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

}
