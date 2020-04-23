package leetcodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] array, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {

			int complement = target - array[i];

			if (map.containsKey(complement)) {

				return new int[] { map.get(complement), i };
			}
			map.put(array[i], i);
		}
		throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int target = 9;
		
		TwoSum twoSum = new TwoSum();
		
		System.out.println(Arrays.toString(twoSum.twoSum(arr, target)));
	}
}
