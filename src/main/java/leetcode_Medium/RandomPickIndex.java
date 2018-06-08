package leetcode_Medium;

import java.util.Random;

/*398 Given an array of integers with possible duplicates, randomly output the
index of a given target number. You can assume that the given target number
must exist in the array.
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);
// pick(3) should return either index 2, 3, or 4 randomly. Each index should
have equal probability of returning. solution.pick(3);
// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);															 */

public class RandomPickIndex {
	int[] integerArrayNums;
	Random random;

	public RandomPickIndex(int[] nums) {
		this.integerArrayNums = nums;
		this.random = new Random();
	}

	public int pick(int intTarget) {
		int count = 0;
		
		for (int i = 0; i < integerArrayNums.length; i++) {
			
			if (intTarget == integerArrayNums[i])
				count++;
		}
		
		int pickIndex = random.nextInt(count);
		
		for (int i = 0; i < integerArrayNums.length; i++) {
			
			if (intTarget == integerArrayNums[i]) {
				
				if (pickIndex-- == 0)
					return i;
			}
		}
		/* shouldn't come here */
		return 0;
	}
}
