package leetcode_Medium;

import java.util.Arrays;

/*611 Given an array consists of non-negative integers, your task is to count
the number of triplets chosen from the array that can make triangles if we take
them as side lengths of a triangle.
Input: [2,2,3,4]		Output: 3
Valid combinations are: 
2, 3, 4 (using the first 2)
2, 3, 4 (using the second 2)
2, 2, 3																		 */

public class ValidTriangleNumber {
	public static int triangleNumber(int[] arrayIntA) {
		
		Arrays.sort(arrayIntA);
		int count = 0, n = arrayIntA.length;
		
		for (int i = n - 1; i >= 2; i--) {
			
			int l = 0, r = i - 1;
			
			while (l < r) {
				
				if (arrayIntA[l] + arrayIntA[r] > arrayIntA[i]) {
					count += r - l;
					r--;
				} else
					l++;
			}
		}
		return count;
	}
}
