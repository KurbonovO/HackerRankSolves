package leetcodeEasy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (set.contains(nums[i])) {
				return true;
			}

			set.add(nums[i]);
		}
		return false;
	}
	
	/**
	 * Time Complexity: O(n) we are looping once
	 * Space Complexity: O(n) we are using hashset
	 */
	public static void main(String[] args) {
		
		ContainsDuplicate containsDuplicate = new ContainsDuplicate();
		
		int[] nums = {1,1,1,3,3,4,3,2,4,2};
		
		System.out.println(containsDuplicate.containsDuplicate(nums));
	}

}
