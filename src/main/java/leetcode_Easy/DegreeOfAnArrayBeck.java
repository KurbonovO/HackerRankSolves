package leetcode_Easy;

import java.util.HashMap;
import java.util.Map.Entry;

public class DegreeOfAnArrayBeck {
	public int degreeOfAnArrayBeck(int[] arr) {

		// first we need to pick the number with highest frequency
		// after determining that we need to start out loop.

		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {

			int key = arr[i];

			if (hashMap.containsKey(key)) {
				int value = hashMap.get(key);
				value++;
				hashMap.put(key, value);
			} else {
				hashMap.put(key, 1);
			}
		}

		int highestFrequency = 0;
		int highestValue = 0;

		for (Entry<Integer, Integer> hm : hashMap.entrySet()) {

			if (highestValue < hm.getValue()) {

				highestFrequency = hm.getKey();
				highestValue = hm.getValue();
			}
		}
		
		int count = 0;
		
		for (int j = 0; j < arr.length; j++) {
			
			if(arr[j] == highestFrequency) {
				
				count++;
			}
		}
		return count;
		
		//not finished.
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 5, 2, 1, 3, 2, 1, 2, 2, 2, 2}; 
		
		DegreeOfAnArrayBeck degreeOfAnArrayBeck = new DegreeOfAnArrayBeck();
		
		System.out.println(degreeOfAnArrayBeck.degreeOfAnArrayBeck(arr));
	}
}
