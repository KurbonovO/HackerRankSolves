package leetcode_Medium;

import java.util.Arrays;

/*698 Given an array of integers nums and a positive integer k, find whether
it's possible to divide this array into k non-empty subsets whose sums are all
equal.
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4			Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3),
(2,3) with equal sums														 */

public class PartitionToKEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {

		int sum = 0;
		
		for (int num : nums) {
			sum += num;
		}
		
		if (sum % k != 0) {
			return false;
		}
		
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		return canPartition(nums, visited, k, 0, 0, sum / k);
	}

	private boolean canPartition(int[] nums, boolean[] visited, int k, int start, int curSum, int target) {
		
		if (k == 1) {
			return true;
		}
		
		if (curSum == target) {
			return canPartition(nums, visited, k - 1, 0, 0, target);
		}
		
		for (int i = start; i < nums.length; i++) {
			
			if (visited[i]) {
				continue;
			}
			
			if (curSum + nums[i] > target) {
				break;
			}
			
			visited[i] = true;
			
			if (canPartition(nums, visited, k, i + 1, curSum + nums[i], target)) {
				return true;
			}
			visited[i] = false;
		}
		return false;
	}
}
