package leetcode_Easy;

import java.util.HashSet;

/*575 Given an integer array with even length, where different numbers in this array represent different
kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these
candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain*/

public class DistributeCandies {

	int maxkind = 0;

	public int distributeCandies(int[] nums) {
		permute(nums, 0);
		return maxkind;
	}

	public void permute(int[] nums, int l) {
		if (l == nums.length - 1) {
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < nums.length / 2; i++) {
				set.add(nums[i]);
			}
			maxkind = Math.max(maxkind, set.size());
		}
		
		for (int i = l; i < nums.length; i++) {
			swap(nums, i, l);
			permute(nums, l + 1);
			swap(nums, i, l);
		}
	}

	public void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}

/*Input: candies = [1,1,2,2,3,3]		Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind. Optimal distribution:
The sister has candies [1,2,3] and the brother has candies [1,2,3], too. The sister has three different kinds of candies. 
---------------------------------------------
Input: candies = [1,1,2,3]		Output: 2
Explanation: the sister has candies [2,3] and the brother has candies [1,1]. The sister has two different
kinds of candies, the brother has only one kind of candies*/