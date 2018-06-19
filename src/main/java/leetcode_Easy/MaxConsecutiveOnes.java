package leetcode_Easy;

import java.util.Scanner;

/*485 Given a binary array, find the maximum number of consecutive 1s in this 
array.
Input: [1,1,0,1,1,1]			Output: 3
The first two digits or the last three digits are consecutive 1s.The maximum
number of consecutive 1s is 3												 */

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes() {

		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();

		scanner.close();

		int[] nums = new int[num];

		int max = 0;
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			/* reset sum to zero when encounters zeros */
			if (nums[i] == 0) {
				sum = 0;
			}
			/* keep update max */
			else {
				max = Math.max(max, sum);
			}
		}
		return max;
	}
}
