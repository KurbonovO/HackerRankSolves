package leetcode_Easy;

/*283 Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements. For example,
given nums = [0, 1, 0, 3, 12], after calling your function, nums should be
[1, 3, 12, 0, 0]														     */

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		
		if (nums == null || nums.length == 0)
			return;

		int p1 = 0, p2 = 0;
		while (p1 < nums.length) {
			
			while (p2 < nums.length && nums[p2] != 0)
				p2++;
			
			while (p1 < nums.length && (nums[p1] == 0 || p1 < p2))
				p1++;
			
			if (p1 == nums.length)
				return;
			
			nums[p2] = nums[p1];
			nums[p1] = 0;
		}
	}
}