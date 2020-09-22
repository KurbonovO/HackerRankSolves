package leetcodeEasy;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {

		Set<Integer> map = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (map.contains(nums[i])) {
				return true;
			}
			map.add(nums[i]);
		}
		return false;
	}

}
