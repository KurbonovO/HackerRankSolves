package leetcode_Easy;

import java.util.Arrays;

public class SquaresOfASortedArrayBeck {
	public int[] squaresOfASortedArrayBeck(int[] array) {

		int[] arrayWithSquared = new int[array.length];

		for (int i = 0; i < array.length; i++) {

			arrayWithSquared[i] = array[i] * array[i];
		}
		Arrays.sort(arrayWithSquared);
		return arrayWithSquared;
	}
	public static void main(String[] args) {

		SquaresOfASortedArrayBeck squaresOfASortedArrayBeck = new SquaresOfASortedArrayBeck();
		int[] input = { -7, -3, 2, 3, 11 };
		System.out.println(Arrays.toString(squaresOfASortedArrayBeck.squaresOfASortedArrayBeck(input)));
	}
}
