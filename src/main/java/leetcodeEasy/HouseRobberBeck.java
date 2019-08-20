package leetcodeEasy;

public class HouseRobberBeck {

	public static int robBeck(int[] nums) {

		if (nums.length == 2) {

			if (nums[0] > nums[1]) {

				return nums[0];

			} else if (nums[0] < nums[1]) {

				return nums[1];
			}
		}

		int total = 0;

		for (int i = 0; i < nums.length; i++) {

			total += nums[i];
			i++;
		}
		return total;
	}

	public static int robLeetCode(int nums[]) {

		int prev1 = 0;
		int prev2 = 0;

		for (int num : nums) {

			int temp = prev1;
			prev1 = Math.max(prev2 + num, prev1);
			prev2 = temp;
		}
		return prev1;
	}

	public static void main(String[] args) {

		int[] nums = { 2,7,9,3,1 };

		System.out.println(HouseRobberBeck.robBeck(nums));
		System.out.println(HouseRobberBeck.robLeetCode(nums));
	}

}
