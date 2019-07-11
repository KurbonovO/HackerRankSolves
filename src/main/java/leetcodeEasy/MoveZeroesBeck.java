package leetcodeEasy;

import java.util.Arrays;

public class MoveZeroesBeck {

	public static int[] moveZeros(int[] input) {

		int insertPos = 0;

		// take the first digit
		for (int num : input) {

			// check that digit is not 0
			if (num != 0)

				// array insertPos starting from zero becomes that num
				input[insertPos++] = num;
		}

		// Check how many times we incremented the insertPos and if input.lenght is
		// greater than then insert to those zeros while increasing insertPos
		while (insertPos < input.length) {

			input[insertPos++] = 0;
		}
		return input;
	}

	public static void main(String[] args) {

		int[] input = { 0, 1, 0, 3, 12 };

		System.out.println(Arrays.toString(MoveZeroesBeck.moveZeros(input)));

	}

}
