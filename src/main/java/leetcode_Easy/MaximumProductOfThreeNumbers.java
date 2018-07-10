package leetcode_Easy;

/*628 Given an integer array, find three numbers whose product is maximum and
output the maximum product.
Input: [1,2,3]			Output: 6
Input: [1,2,3,4]		Output: 24											 */

public class MaximumProductOfThreeNumbers {
	public int maximumProduct(int[] intArrayInput) {
		
		int max1 = Integer.MIN_VALUE, 
			max2 = Integer.MIN_VALUE, 
			max3 = Integer.MIN_VALUE, 
			min1 = Integer.MAX_VALUE,
			min2 = Integer.MAX_VALUE;
		
		for (int intN : intArrayInput) {
			
			if (intN > max1) {
				max3 = max2;
				max2 = max1;
				max1 = intN;
			} else if (intN > max2) {
				max3 = max2;
				max2 = intN;
			} else if (intN > max3) {
				max3 = intN;
			}
			if (intN < min1) {
				min2 = min1;
				min1 = intN;
			} else if (intN < min2) {
				min2 = intN;
			}
		}
		return Math.max(max1 * max2 * max3, max1 * min1 * min2);
	}
}
