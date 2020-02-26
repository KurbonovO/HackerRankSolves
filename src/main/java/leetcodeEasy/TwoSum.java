package leetcodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] inputArr, int target) {

		int[] result = new int[2];

		for (int i = 0; i < inputArr.length; i++) {

			for (int j = i + 1; j < inputArr.length; j++) {

				if (inputArr[i] + inputArr[j] == target) {

					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	public int[] twoPassHashTable(int[] inputArr, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < inputArr.length; i++) {

			map.put(inputArr[i], i);
		}
		for (int i = 0; i < inputArr.length; i++) {

			int complement = target - inputArr[i];

			if (map.containsKey(complement) && map.get(complement) != i) {

				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException();
	}

	public int[] onePassHashTable(int[] inputArr, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < inputArr.length; i++) {

			int complement = target - inputArr[i];

			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(inputArr[i], i);
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {

		int[] inputArr = { 0, 1, 2, 3, 4, 5, 6, 7 };
		TwoSum twoSum = new TwoSum();
		System.out.println(Arrays.toString(twoSum.onePassHashTable(inputArr, 9)));
	}
}
