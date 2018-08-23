package leetcode_Medium;

/*377 Given an integer array with all positive numbers and no duplicates, find
the number of possible combinations that add up to a positive integer target.
nums = [1, 2, 3]		target = 4
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations. Therefore
the output is 7																 */

public class CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {

		if (target == 0) {
			return 1;
		}

		int intOutput = 0;

		for (int i = 0; i < nums.length; i++) {

			if (target >= nums[i]) {

				intOutput += combinationSum4(nums, target - nums[i]);
			}
		}
		return intOutput;
	}
}
