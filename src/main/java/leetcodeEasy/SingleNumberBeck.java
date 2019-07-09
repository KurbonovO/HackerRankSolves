package leetcodeEasy;

public class SingleNumberBeck {

	// Was not able to solve. Need to learn bitwise
	public static int singleNumberBeck(int[] nums) {

		if (nums == null) {

			return -1;
		}

		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j < nums.length; j++) {

				if (nums[i] != nums[j]) {

				}
			}
		}
		return -1;
	}

	public static int singleNumberLeetCode(int[] nums) {

		int result = 0;

		for (int i = 0; i < nums.length; i++) {

			result ^= nums[i];
		}
		return result;
	}

	public static void main(String[] args) {

		int[] nums = { 4, 1, 2, 1, 2 };

		System.out.println(SingleNumberBeck.singleNumberLeetCode(nums));
	}

}
