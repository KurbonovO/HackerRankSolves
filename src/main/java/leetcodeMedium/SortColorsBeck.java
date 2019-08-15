package leetcodeMedium;

import java.util.Arrays;

public class SortColorsBeck {

	public static int[] sortColorsBeck(int[] arr) {

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

		int[] arr = { 2, 0, 2, 1, 1, 0 };

		System.out.println(Arrays.toString(SortColorsBeck.sortColorsBeck(arr)));
	}

}
