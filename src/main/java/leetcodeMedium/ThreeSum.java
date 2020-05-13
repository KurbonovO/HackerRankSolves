package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	// Time Complexity: O(n log n + n^2)
	// Space Complexity: O(log n)

	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length && 0 >= nums[i]; i++) {

			if (i == 0 || nums[i - 1] != nums[i]) {

				twoSum(nums, i, result);
			}
		}
		return result;
	}

	public void twoSum(int[] nums, int i, List<List<Integer>> result) {

		int low = i + 1;
		int high = nums.length - 1;

		while (low < high) {

			int sum = nums[i] + nums[low] + nums[high];

			if (sum < 0 || (low > i + 1 && nums[low] == nums[low - 1])) {

				low++;

			} else if (sum > 0 || (high < nums.length - 1 && nums[high] == nums[high + 1])) {

				high--;

			} else {

				result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
			}
		}
	}

	public static void main(String[] args) {

		ThreeSum threeSum = new ThreeSum();

		int nums[] = { -1, 0, 1, 2, -1, -4 };

		System.out.println(threeSum.threeSum(nums));

	}

}
