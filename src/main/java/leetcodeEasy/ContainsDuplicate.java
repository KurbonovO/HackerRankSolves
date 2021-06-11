package leetcodeEasy;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(n) We do search() and insert() for n times and each operation takes constant time.
 * Space Complexity: O(n) The space used by a hash table is linear with the number of elements in it.
 */
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {

		Set<Integer> unique = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (unique.contains(nums[i])) {

				return true;
			}
			unique.add(nums[i]);
		}
		return false;
	}
}
