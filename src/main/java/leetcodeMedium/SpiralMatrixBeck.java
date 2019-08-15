package leetcodeMedium;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixBeck {

	public static List<Integer> spiralOrderLeetCode(int[][] matrix) {

		List<Integer> result = new LinkedList<>();

		int leftBound = 0;
		int rightBound = matrix[0].length - 1;
		int bottomBound = matrix.length - 1;
		int upperBound = 0;

		while (leftBound <= rightBound && upperBound <= bottomBound) {

			// Travel to the right.
			for (int col = leftBound; col <= rightBound; col++) {

				result.add(matrix[upperBound][col]);
			}

			// Increase the top row to one one bottom.
			upperBound++;

			// Travel to the bottom p.s. need to add 2 element only
			for (int row = upperBound; row <= bottomBound; row++) {

				result.add(matrix[row][rightBound]);
			}

			// Decrement the right side before traveling to left.
			rightBound--;

			// Travel to the left
			for (int col = rightBound; upperBound <= bottomBound && col >= leftBound; col--) {

				result.add(matrix[bottomBound][col]);
			}

			// bottomBound is two so decrease to get to middle level.
			bottomBound--;

			for (int row = bottomBound; leftBound <= rightBound && row >= upperBound; row--) {

				result.add(matrix[row][leftBound]);
			}
			
			leftBound++;
		}
		return result;
	}

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(SpiralMatrixBeck.spiralOrderLeetCode(arr));

	}

}
