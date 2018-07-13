package leetcode_Medium;

import java.util.HashMap;
import java.util.Map;

/*525 Given a binary array, find the maximum length of a contiguous subarray
with equal number of 0 and 1.
Input: [0,1]		Output: 2
[0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Input: [0,1,0]		Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
number of 0 and 1															 */

public class ContiguousArray {
	public int findMaxLength(int[] intArrayInput) {

		for (int i = 0; i < intArrayInput.length; i++) {
			if (intArrayInput[i] == 0) {
				intArrayInput[i] = -1;
			}
		}

		Map<Integer, Integer> sumToIndex = new HashMap<>();
		sumToIndex.put(0, -1);
		int sum = 0, max = 0;

		for (int i = 0; i < intArrayInput.length; i++) {
			sum += intArrayInput[i];

			if (sumToIndex.containsKey(sum)) {
				max = Math.max(max, i - sumToIndex.get(sum));
			} else {
				sumToIndex.put(sum, i);
			}
		}
		return max;
	}
}
