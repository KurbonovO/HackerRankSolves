package leetcodeMedium;

public class ContainerWithMostWater {

	/**
	 * Time Complexity: O(n^2) Space Complexity: O(1)
	 */
	public int bruteForce(int[] nums) {

		int maxArea = 0;

		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j < nums.length; j++) {

				maxArea = Math.max(maxArea, Math.min(nums[i], nums[j]) * (j - i));
			}
		}
		return maxArea;
	}

	/**
	 * Time Complexity: O(n) single pass
	 * Space Complexity: O(1) constant space is used
	 */
	public int twoPointerApproach(int[] nums) {

		int maxarea = 0;
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {

			maxarea = Math.max(maxarea, Math.min(nums[left], nums[right]) * (right - left));
			
			if (nums[left] < nums[right]) {
				
				left++;
			
			} else {
				
				right--;
			}
		}
		return maxarea;
	}

}
