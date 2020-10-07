package leetcodeMedium;

public class ProductOfArrayExceptSelf {
	
	//Time complexity: O(n)

	public int[] productExceptSelf(int[] nums) {
		
		int n = nums.length;
		int[] result = new int[n];
		
		// Calculate lefts and store in res.
		int left = 1;
		for (int i = 0; i < n; i++) {
			
			if (i > 0) {
				
				left = left * nums[i - 1];
			}
			result[i] = left;
		}
		
		// Calculate rights and the product from the end of the array.
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			
			if (i < n - 1) {
				
				right = right * nums[i + 1];
			}
			result[i] = result[i] * right;
		}
		return result;
	}

}
