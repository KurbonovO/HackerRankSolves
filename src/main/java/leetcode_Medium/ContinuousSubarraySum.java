package leetcode_Medium;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*523 Given a list of non-negative numbers and a target integer k, write a
function to check if the array has a continuous subarray of size at least 2
that sums up to the multiple of k, that is, sums up to n*k where n is also an
integer.
Input: [23, 2, 4, 6, 7],  k=6		Output: True
Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Input: [23, 2, 6, 4, 7],  k=6		Output: True
Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42 */

public class ContinuousSubarraySum implements Serializable {
	
	private static final long serialVersionUID = -850488870182878711L;

	public boolean checkSubarraySum(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>() {

			private static final long serialVersionUID = 1L;

			{
				put(0, -1);
			}
		};;

		int runningSum = 0;

		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];

			if (k != 0)
				runningSum %= k;

			Integer prev = map.get(runningSum);

			if (prev != null) {
				if (i - prev > 1)
					return true;
			} else
				map.put(runningSum, i);
		}
		return false;
	}
}
