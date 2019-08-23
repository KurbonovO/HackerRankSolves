package leetcodeMedium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumBeck {

	public static List<List<Integer>> ThreeSumLeetCode(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> res = new LinkedList<>();

		for (int i = 0; i < nums.length - 2; i++) {

			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

				int low = i + 1;
				int high = nums.length - 1;
				int sum = 0 - nums[i];

				while (low < high) {

					if (nums[low] + nums[high] == sum) {

						res.add(Arrays.asList(nums[i], nums[low], nums[high]));

						while (low < high && nums[low] == nums[low + 1]) {

							low++;
						}

						while (low < high && nums[high] == nums[high - 1]) {

							high--;
						}

						low++;
						high--;

					} else if (nums[low] + nums[high] < sum) {

						// improve: skip duplicates
						while (low < high && nums[low] == nums[low + 1]) {

							low++;
						}
						low++;

					} else {

						// improve: skip duplicates
						while (low < high && nums[high] == nums[high - 1]) {

							high--;
						}
						high--;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

		int[] nums = {};

		System.out.println(ThreeSumBeck.ThreeSumLeetCode(nums));
	}

}
