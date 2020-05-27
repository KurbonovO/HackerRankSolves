package leetcodeMedium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public int[] productOfArrayExceptSelf(int[] nums) {

		int numsLenght = nums.length;

		int[] result = new int[numsLenght];
		result[0] = 1;

		for (int i = 1; i < numsLenght; i++) {

			result[i] = nums[i - 1] * result[i - 1];
		}

		int right = 1;
		for (int i = numsLenght - 1; i >= 0; i--) {

			result[i] = result[i] * right;
			right *= nums[i];
		}
		return result;
	}

	public static void main(String[] args) {

		ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();

		System.out
				.println(Arrays.toString(productOfArrayExceptSelf.productOfArrayExceptSelf(new int[] { 1, 2, 3, 4 })));
	}
	
}
