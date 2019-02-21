package leetcode_Easy;

import java.util.Arrays; 
import java.util.Collections; 

public class MaximumSubarrayBeck {
	public int maximumSubarrayBeck(int[] array) {

		//Arrays.sort(array, Collections.reverseOrder());

		int output = 0;

		for (int i = 0; i < 3; i++) {

			output += array[i];
		}

		return output;
	}

	public static void main(String[] args) {

		MaximumSubarrayBeck maximumSubarrayBeck = new MaximumSubarrayBeck();
		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maximumSubarrayBeck.maximumSubarrayBeck(array));

	}

}
