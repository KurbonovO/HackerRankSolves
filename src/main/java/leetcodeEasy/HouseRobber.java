package leetcodeEasy;

public class HouseRobber {

	public int houseRobber(int[] nums) {

		int total = 0;

		for (int i = 0; i < nums.length; i += 2) {

			total += nums[i];
		}
		return total;
	}

	public static void main(String[] args) {

		int[] nums = { 2, 7, 9, 3, 1 };

		HouseRobber houseRobber = new HouseRobber();
		System.out.println(houseRobber.houseRobber(nums));

	}

}
