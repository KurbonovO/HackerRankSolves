package leetcodeMedium;

public class ContainerWithMostWater {

	// Time Complexity: O(n)
	// Space Complexity: O(1)

	public int maxArea(int[] heights) {

		int result = 0;
		int left = 0;
		int right = heights.length - 1;

		while (left < right) {

			result = Math.max(result, Math.min(heights[left], heights[right]) * (right - left));

			if (heights[left] < heights[right]) {

				left++;
			
			} else {
				
				right--;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		System.out.println(containerWithMostWater.maxArea(arr));
	}

}
