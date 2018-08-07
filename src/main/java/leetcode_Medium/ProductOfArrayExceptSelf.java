package leetcode_Medium;

/*238 Given an array nums of n integers where n > 1,  return an array output
such that output[i] is equal to the product of all the elements of nums except
nums[i].		Input:  [1,2,3,4]			Output: [24,12,8,6]				 */

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] intArrayInput) {

		int intN = intArrayInput.length;
		int[] intArrayOutput = new int[intN];

		/* Calculate lefts and store in res */
		int left = 1;

		for (int i = 0; i < intN; i++) {

			if (i > 0) {
				left = left * intArrayInput[i - 1];
			}
			intArrayOutput[i] = left;
		}

		/* Calculate rights and the product from the end of the array */
		int right = 1;

		for (int i = intN - 1; i >= 0; i--) {

			if (i < intN - 1) {
				right = right * intArrayInput[i + 1];
			}
			intArrayOutput[i] *= right;
		}
		return intArrayOutput;
	}
}
