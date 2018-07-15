package leetcode_Medium;

/*713 Your are given an array of positive integers nums. Count and print the
number of (contiguous) subarrays where the product of all the elements in the
subarray is less than k.
Input: nums = [10, 5, 2, 6], k = 100		Output: 8
The 8 subarrays that have product less than 100 are: 
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less
than k																		 */

public class SubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] intArrayInput, int intInputK) {
		
		if (intInputK == 0) {
			return 0;
		}	
		
		int cnt = 0;
		int pro = 1;
		
		for (int i = 0, j = 0; j < intArrayInput.length; j++) {
			
			pro *= intArrayInput[j];
			
			while (i <= j && pro >= intInputK) {
				pro /= intArrayInput[i++];
			}
			cnt += j - i + 1;
		}
		return cnt;
	}
}
