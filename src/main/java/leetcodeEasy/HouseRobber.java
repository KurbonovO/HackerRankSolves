package leetcodeEasy;

public class HouseRobber {

	public int houseRobber(int[] nums) {

		int total = 0;

		for (int i = 0; i < nums.length; i += 2) {

			total += nums[i];
		}
		return total;
	}

	/**
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public int houseRobberLeetCode(int[] nums) {

		int previousMax = 0;
		int currentMax = 0;

		for (int i : nums) {

			int temporary = currentMax;
			currentMax = Math.max(previousMax + i, currentMax);
			previousMax = temporary;
		}
		return currentMax;
	}

	public static void main(String[] args) {

		int[] nums = { 2, 7, 9, 3, 1 };

		HouseRobber houseRobber = new HouseRobber();
		System.out.println(houseRobber.houseRobber(nums));
		System.out.println(houseRobber.houseRobberLeetCode(nums));
	}
}
