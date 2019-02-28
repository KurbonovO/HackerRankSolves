package leetcode_Easy;

import java.util.Arrays;

public class MissingNumberBeck {
	public int missingNumberBeck(int[] arr) {

		// ordered from decreasing to higher number.
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] + 1 != arr[i + 1]) {
				return arr[i] + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		MissingNumberBeck missingNumberBeck = new MissingNumberBeck();
		int[] arr = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		System.out.println(missingNumberBeck.missingNumberBeck(arr));
	}
}
