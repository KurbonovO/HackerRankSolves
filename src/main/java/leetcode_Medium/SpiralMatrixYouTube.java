package leetcode_Medium;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixYouTube {
	public List<Integer> spiralMatrixYouTube(int[][] matrix) {

		List<Integer> result = new LinkedList<Integer>();

		if (matrix.length == 0 && matrix[0].length == 0) {
			return result;
		}

		// top horizontal row
		int topRow = 0;

		// bottom horizontal row
		int bottomRow = matrix.length - 1;

		// left vertical column
		int leftColumn = 0;

		// right vertical column
		int rightColumn = matrix[0].length - 1;

		while (topRow <= bottomRow && leftColumn <= rightColumn) {

			// | for the left column get one
			for (int i = leftColumn; i <= rightColumn; i++) {

				//for the top row add the i's
				result.add(matrix[topRow][i]);
			}
			//after for loop ended increment to move the top to second one
			topRow++;

			// - for the top to down do a loop
			for (int i = topRow; i <= bottomRow; i++) {

				//keep the right column but add rows
				result.add(matrix[i][rightColumn]);
			}
			rightColumn--;

			if (topRow <= bottomRow) {

				for (int i = rightColumn; i >= leftColumn; i--) {

					result.add(matrix[bottomRow][i]);
				}
				bottomRow--;
			}
			if (leftColumn <= rightColumn) {

				for (int i = bottomRow; i >= topRow; i--) {

					result.add(matrix[i][leftColumn]);
				}
				leftColumn++;
			}
		}
		return result;
	}
}
