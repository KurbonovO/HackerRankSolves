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
	 * Time Complexity: O(n). We traverse the list containing n elements only once. 
	 * Each look up in the table costs only O(1) time.
	 * Space Complexity: O(n). The extra space required depends on the number of items
	 * stored in the hash table, which stores at most n elements.
	 */
	public static void main(String[] args) {

		TwoSum twoSum = new TwoSum();

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 9;

		System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
	}

}
