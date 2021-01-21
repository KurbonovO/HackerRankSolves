package leetcodeMedium;

public class HouseRobber {

	public int houseRobber(int[] nums) {

		int previousMax = 0;
		int currentMax = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			int temp = currentMax;
			
			currentMax = Math.max(previousMax + nums[i], currentMax);
			
			previousMax = temp;
		}
		return currentMax;
	}
	
	/**
	 * Time Complexity: O(n). We traverse the list containing n elements only once.
	 * Space Complexity: O(1)
	 */
	public static void main(String[] args) {
		
		int nums[] = {2,7,9,3,1};
		
		HouseRobber houseRobber = new HouseRobber();
		
		System.out.println(houseRobber.houseRobber(nums));
	}

}
