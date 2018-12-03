package leetcode_Medium;

/*162 A peak element is an element that is greater than its neighbors. Given an
input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its
index. The array may contain multiple peaks, in that case return the index to
any one of the peaks is fine. You may imagine that nums[-1] = nums[n] = -∞.
Input: nums = [1,2,3,1]			Output: 2
3 is a peak element and your function should return the index number 2.
Input: nums = [1,2,1,3,5,6,4]	Output: 1 or 5 
Your function can return either index number 1 where the peak element is 2, or
index number 5 where the peak element is 6									 */

public class FindPeakElement {

	public int findPeakElement(int[] num) {
		return helper(num, 0, num.length - 1);
	}

	public int helper(int[] num, int start, int end) {

		if (start == end) {
			return start;
		} else if (start + 1 == end) {

			if (num[start] > num[end]) {
				return start;
			}
			return end;
		} else {

			int m = (start + end) / 2;

			if (num[m] > num[m - 1] && num[m] > num[m + 1]) {

				return m;

			} else if (num[m - 1] > num[m] && num[m] > num[m + 1]) {

				return helper(num, start, m - 1);

			} else {

				return helper(num, m + 1, end);
			}
		}
	}
}
