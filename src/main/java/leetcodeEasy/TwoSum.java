package leetcodeEasy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			int difference = target - nums[i];

			if (map.containsKey(difference)) {

				return new int[] { map.get(i), i };
			}
			map.put(nums[i], i);

		}
		throw new IllegalArgumentException();
	}
}