package leetcodeMedium;

import java.util.Arrays;

public class ProductOfArrayExceptSelfBeck {

	//Do not understand at all.
	public static int[] productExceptSelf(int[] inputArr) {

		int inputArrLength = inputArr.length;

		int[] outputArr = new int[inputArrLength];

		// Calculate lefts and store in res.
		int left = 1;

		for (int i = 0; i < inputArrLength; i++) {

			if (i > 0) {

				left = left * inputArr[i - 1];
			}
			outputArr[i] = left;
		}

		// Calculate rights and the product from the end of the array.
		int right = 1;

		for (int i = inputArrLength - 1; i >= 0; i--) {

			if (i < inputArrLength - 1) {
				
				right = right * inputArr[i + 1];
			}
			outputArr[i] *= right;
		}
		return outputArr;
	}

	public static void main(String[] args) {

		int[] input = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(ProductOfArrayExceptSelfBeck.productExceptSelf(input)));
	}
}
