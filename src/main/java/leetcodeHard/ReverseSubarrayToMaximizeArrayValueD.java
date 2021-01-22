package leetcodeHard;

public class ReverseSubarrayToMaximizeArrayValueD {

	public int maxValueAfterReverse(int[] nums) {
		int n = nums.length;
		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			res += Math.abs(nums[i] - nums[i + 1]);
		}
		int topIntervalBottomLine = Integer.MIN_VALUE;
		int bottomIntervalTopLine = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			topIntervalBottomLine = Math.max(topIntervalBottomLine, Math.min(nums[i], nums[i + 1]));
			bottomIntervalTopLine = Math.min(bottomIntervalTopLine, Math.max(nums[i], nums[i + 1]));
		}
		int diff = Math.max(0, (topIntervalBottomLine - bottomIntervalTopLine) * 2);

		// Edge case 1: subarray starts at index 0
		for (int i = 1; i < n - 1; i++) {
			diff = Math.max(diff, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
		}
		// Edge case w: subarray ends at index n - 1
		for (int i = 0; i < n - 1; i++) {
			diff = Math.max(diff, Math.abs(nums[n - 1] - nums[i]) - Math.abs(nums[i + 1] - nums[i]));
		}
		return res + diff;
	}

}
