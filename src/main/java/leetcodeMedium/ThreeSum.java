package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length && nums[i] <= 0; ++i)

			if (i == 0 || nums[i - 1] != nums[i]) {

				twoSumII(nums, i, result);
			}
		return result;
	}

	void twoSumII(int[] nums, int i, List<List<Integer>> result) {

		int low = i + 1;
		int high = nums.length - 1;

		while (low < high) {

			int sum = nums[i] + nums[low] + nums[high];

			if (sum < 0) {

				++low;

			} else if (sum > 0) {

				--high;

			} else {

				result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));

				while (low < high && nums[low] == nums[low - 1]) {

					++low;
				}
			}
		}
	}

	/**
	 * Time Complexity: O(n^2) twoSumII is O(n), and we call it n times.
	 * Sorting the array takes O(n log n), so overall complexity is O(n log n + n^2).
	 * This is asymptotically equivalent to O(n^2).
	 * Space Complexity: O(n)
	 */
	public static void main(String[] args) {

		int[] nums = { -1, 0, 1, 2, -1, -4 };

		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.threeSum(nums));
	}

}
