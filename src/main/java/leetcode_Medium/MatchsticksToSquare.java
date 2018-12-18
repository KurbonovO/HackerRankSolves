package leetcode_Medium;

import java.util.Arrays;

/*473 Remember the story of Little Match Girl? By now, you know exactly what
matchsticks the little match girl has, please find out a way you can make one
square by using up all those matchsticks. You should not break any stick, but
you can link them up, and each matchstick must be used exactly one time. Your
input will be several matchsticks the girl has, represented with their stick
length. Your output will either be true or false, to represent whether you
could make one square using all the matchsticks the little match girl has.
Input: [1,1,2,2,2]	Output: true
You can form a square with length 2, one side of the square came two sticks
with length 1.
Input: [3,3,3,3,4]	Output: false
You cannot find a way to form a square with all the matchsticks				 */

public class MatchsticksToSquare {
	public boolean makesquare(int[] nums) {

		if (nums == null || nums.length < 4) {
			return false;
		}

		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum % 4 != 0) {
			return false;
		}
		Arrays.sort(nums);
		reverse(nums);

		return dfs(nums, new int[4], 0, sum / 4);
	}

	private boolean dfs(int[] nums, int[] sums, int index, int target) {

		if (index == nums.length) {

			if (sums[0] == target && sums[1] == target && sums[2] == target) {

				return true;
			}
			return false;
		}

		for (int i = 0; i < 4; i++) {

			if (sums[i] + nums[index] > target) {
				continue;
			}

			sums[i] += nums[index];

			if (dfs(nums, sums, index + 1, target)) {
				return true;
			}
			sums[i] -= nums[index];
		}
		return false;
	}

	private void reverse(int[] nums) {

		int i = 0;
		int j = nums.length - 1;

		while (i < j) {

			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
}
