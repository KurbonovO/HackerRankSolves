package leetcodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			int compliment = target - nums[i];

			if (map.containsKey(compliment)) {

				return new int[] { map.get(compliment), i };
			}

			map.put(nums[i], i);
		}
		throw new IllegalArgumentException();
	}

	/**
	 * TODO!!!!!! 
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public static void main(String[] args) {

		TwoSum twoSum = new TwoSum();

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 9;

		System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
	}

}
