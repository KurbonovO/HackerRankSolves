package leetcode_Medium;

/*264 Write a program to find the n-th ugly number. Ugly numbers are positive numbers whose prime factors only
include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers. Note
that 1 is typically treated as an ugly number, and n does not exceed 1690					*/

public class UglyNumberTwo {
	public int nthUglyNumber(int n) {
		
		int[] nums = new int[n];
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		
		nums[0] = 1;
		
		for (int i = 1; i < nums.length; i++) {
			nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
			
			if (nums[i] == nums[index2] * 2)
				index2++;
			
			if (nums[i] == nums[index3] * 3)
				index3++;
			
			if (nums[i] == nums[index5] * 5)
				index5++;
		}
		return nums[n - 1];
	}
}

/*The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to
three groups as below:
(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5. Then we use
similar merge method as merge sort, to get every ugly number from the three subsequence. Every step we choose the
smallest one, and move one step after,including nums with same value.			*/