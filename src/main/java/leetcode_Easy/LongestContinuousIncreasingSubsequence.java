package leetcode_Easy;

/*674 Given an unsorted array of integers, find the length of longest
continuous increasing subsequence (subarray)
Input: [1,3,5,4,7]		Output: 3
The longest continuous increasing subsequence is [1,3,5], its length is 3. Even
though [1,3,5,7] is also an increasing subsequence, it's not a continuous one
where 5 and 7 are separated by 4. 
Input: [2,2,2,2,2]		Output: 1
The longest continuous increasing subsequence is [2], its length is 1		 */

public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {

		int output = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {

			if (i == 0 || nums[i - 1] < nums[i]) {
				output = Math.max(output, ++count);
			} else {
				count = 1;
			}
		}
		return output;
	}
}
