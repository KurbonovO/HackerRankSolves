package leetcode_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//non leetcode

public class FindDuplicatesBeck {
	public int[] findDuplicatesBeck(int[] arr) {

		List<Integer> outcomeInList = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] == arr[j]) {

					outcomeInList.add(arr[i]);
				}
			}
		}
		int[] result = outcomeInList.stream().mapToInt(i -> i).toArray();
		return result;
	}

	public static void main(String[] args) {

		FindDuplicatesBeck findDuplicatesBeck = new FindDuplicatesBeck();
		int[] arr = { 1, 2, 3, 4, 5, 5, 6 };
		System.out.println(Arrays.toString(findDuplicatesBeck.findDuplicatesBeck(arr)));
	}
}
