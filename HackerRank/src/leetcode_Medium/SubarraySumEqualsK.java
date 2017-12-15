package leetcode_Medium;

import java.util.HashMap;
import java.util.Map;

/*560 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
Input:nums = [1,1,1], k = 2		Output: 2*/

public class SubarraySumEqualsK {
	
	public int subarraySum(int[] nums, int k) {
		
		int sum = 0, result = 0;
		
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}
		return result;
	}
}