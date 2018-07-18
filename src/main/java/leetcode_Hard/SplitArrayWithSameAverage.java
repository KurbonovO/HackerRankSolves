package leetcode_Hard;

import java.util.HashSet;

/*805 In a given integer array A, we must move every element of A to either
list B or list C. (B and C initially start empty.) Return true if and only if
after such a move, it is possible that the average value of B is equal to the
average value of C, and B and C are both non-empty.
Input: [1,2,3,4,5,6,7,8]		Output: true
We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the
average of 4.5																 */

public class SplitArrayWithSameAverage {

	public boolean splitArraySameAverage(int[] intArrayInput) {
		
		int sum = 0;
		for (int n : intArrayInput) {
			sum += n;
		}
		
		int lenA = intArrayInput.length, half = lenA / 2;
		HashSet<Integer>[] knap = new HashSet[half + 1];
		
		knap[0] = new HashSet<>();
		knap[0].add(0);
		
		for (int i = 1; i < knap.length; i++) {
			knap[i] = new HashSet<>();
		}
		
		for (int n : intArrayInput) {
			
			for (int i = half; i >= 1; i--) {
				
				for (Integer knapSum : knap[i - 1]) {
					
					int nextSum = knapSum + n;
					
					if (check(nextSum, sum - nextSum, i, lenA - i)) {
						return true;
					}	
					knap[i].add(nextSum);
				}
			}
		}
		return false;
	}
	boolean check(int sumB, int sumC, int lenB, int lenC) {
		// sumB / lenB = sumC / lenC => sumB * lenC = sumC * lenB
		return sumB * lenC == sumC * lenB;
	}
}
