package leetcodeEasy;

import java.util.Arrays;

public class SortedSquaresBeck {

	public static int[] sortedSquares(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			arr[i] = arr[i] * arr[i];

		}

		for (int i = 0; i < arr.length; i++) {

			for (int a = i + 1; a < arr.length; a++) {

				if (arr[i] > arr[a]) {

					int temp = arr[i];
					arr[i] = arr[a];
					arr[a] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {

		int[] arr = { -4, -1, 0, 3, 10 };

		System.out.println(Arrays.toString(SortedSquaresBeck.sortedSquares(arr)));
	}
}
