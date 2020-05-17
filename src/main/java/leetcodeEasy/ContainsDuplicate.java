package leetcodeEasy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	// Time Complexity: O(n)
	// Space Complexity: O(n)

	public boolean containsDuplicate(int[] nums) {
		

		Set<Integer> distinct = new HashSet<>();
		
		for (int num : nums) {
			
			if (distinct.contains(num)) {
				
				return true;
			}
			distinct.add(num);
		}
		return false;
	}

	public static void main(String[] args) {

		ContainsDuplicate containsDuplicate = new ContainsDuplicate();

		int[] arr = { 1, 2, 3, 4 };

		System.out.println(containsDuplicate.containsDuplicate(arr));
	}
}
