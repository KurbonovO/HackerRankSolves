package leetcodeEasy;

import java.util.HashMap;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			
			if(map.containsKey(nums[i])) {

				map.remove(nums[i]);
			
			} else {
				
				map.put(nums[i], 1);
			}
		}
		return map.get(map.keySet().toArray()[0]);
	}
	
	public static void main(String[] args) {
		
		int[] nums = {2,1,2};
		
		SingleNumber singleNumber = new SingleNumber();
		System.out.println(singleNumber.singleNumber(nums));
	}
}
