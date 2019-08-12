package leetcodeMedium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroesBeck {

	public static int[][] setZeroesLeetCode(int[][] matrix) {

		int rows = matrix.length;
		int collumns = matrix[0].length;

		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> collumnsSet = new HashSet<>();

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < collumns; j++) {

				if (matrix[i][j] == 0) {
					rowSet.add(i);
					collumnsSet.add(j);
				}
			}
		}
		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < collumns; j++) {

				if (rowSet.contains(i) || collumnsSet.contains(j)) {

					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

	public static void main(String[] args) {

		int arr[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

		Arrays.toString(SetMatrixZeroesBeck.setZeroesLeetCode(arr));
	}
}
