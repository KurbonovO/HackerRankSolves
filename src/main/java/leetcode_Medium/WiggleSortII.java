package leetcode_Medium;

/*324 Given an unsorted array nums, reorder it such that 
nums[0] < nums[1] > nums[2] < nums[3]....
Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6]
Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2]							 */

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		
		//int median = findKthLargest(nums, (nums.length + 1) / 2);
		int n = nums.length;

		int left = 0, i = 0, right = n - 1;

		while (i <= right) {

			//if (nums[newIndex(i, n)] > median) {
				//swap(nums, newIndex(left++, n), newIndex(i++, n));
			//} else if (nums[newIndex(i, n)] < median) {
				//swap(nums, newIndex(right--, n), newIndex(i, n));
			//} else {
				i++;
			}
		}
	//}

	private int newIndex(int index, int n) {
		return (1 + 2 * index) % (n | 1);
	}
}
