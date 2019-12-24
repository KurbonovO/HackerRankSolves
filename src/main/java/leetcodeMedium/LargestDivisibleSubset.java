package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	public List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums.length == 0) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);
		int[] groupIndex = new int[nums.length];
		int[] groupSize = new int[nums.length];
		int max = 0, index = 0;
		for (int i = 0; i < nums.length; i++) {
			groupIndex[i] = -1;
			groupSize[i] = 1;
			for (int j = getIndex(nums, i); j >= 0; j--) { // Bindary search to find maximum j where nums[j]<=nums[i]/2
				if (nums[i] % nums[j] == 0) {
					if (1 + groupSize[j] > groupSize[i]) {
						groupSize[i] = 1 + groupSize[j];
						groupIndex[i] = j;
					}
				}
				if (max < groupSize[i]) {
					max = groupSize[i];
					index = i;
				}
			}
		}
		List<Integer> group = new ArrayList<>();
		while (index != -1) {
			group.add(nums[index]);
			index = groupIndex[index];
		}
		return group;
	}

	private int getIndex(int[] nums, int idx) {
		if (idx == 0) {
			return -1;
		}
		int val = nums[idx] / 2;
		int start = 0, end = idx - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= val) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

}
