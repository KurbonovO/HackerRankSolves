package leetcodeMedium;

import java.util.HashMap;

public class FindTwoNonOverlappingSubArraysEachWithTargetSumD {

	public int minSumOfLengths(int[] arr, int target) {
		HashMap<Integer, Integer> hmap = new HashMap<>();
		int sum = 0, lsize = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
		hmap.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			hmap.put(sum, i); // stores key as sum upto index i, and value as i.
		}
		sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (hmap.get(sum - target) != null) {
				lsize = Math.min(lsize, i - hmap.get(sum - target)); // stores minimum length of sub-array ending with
																		// index<= i with sum target. This ensures non-
																		// overlapping property.
			}
			// hmap.get(sum+target) searches for any sub-array starting with index i+1 with
			// sum target.
			if (hmap.get(sum + target) != null && lsize < Integer.MAX_VALUE) {
				result = Math.min(result, hmap.get(sum + target) - i + lsize); // updates the result only if both left
																				// and right sub-array exists.
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

}
