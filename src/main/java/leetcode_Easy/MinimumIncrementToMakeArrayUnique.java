package leetcode_Easy;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
	public int minimumIncrementToMakeArrayUnique(int[] arr) {
		
		Arrays.sort(arr);

		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i - 1] - arr[i] == 1) {
				
			}
			
		}
		
		
		
		
		
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		MinimumIncrementToMakeArrayUnique minimumIncrementToMakeArrayUnique = new MinimumIncrementToMakeArrayUnique();
		int[] arr = {1,2,2};
		System.out.println(minimumIncrementToMakeArrayUnique.minimumIncrementToMakeArrayUnique(arr));
		
	}
}
