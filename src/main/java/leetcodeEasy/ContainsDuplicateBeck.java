package leetcodeEasy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateBeck {

	public static Boolean containsDuplicateBeck(int[] nums) {

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (set.contains(nums[i])) {

				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };

		System.out.println(ContainsDuplicateBeck.containsDuplicateBeck(arr));
	}
}
