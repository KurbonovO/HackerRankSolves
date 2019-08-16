package leetcodeMedium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroesBeck {

	public static int[][] setZeroesLeetCode(int[][] matrix) {

		int column = matrix.length;
		int row = matrix[0].length;

		Set<Integer> collumnsSet = new HashSet<>();
		Set<Integer> rowSet = new HashSet<>();

		for (int i = 0; i < column; i++) {

			for (int j = 0; j < row; j++) {

				if (matrix[i][j] == 0) {
					rowSet.add(i);
					collumnsSet.add(j);
				}
			}
		}
		for (int i = 0; i < column; i++) {

			for (int j = 0; j < row; j++) {

				if (rowSet.contains(i) || collumnsSet.contains(j)) {

					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3,}, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(Arrays.deepToString(SetMatrixZeroesBeck.setZeroesLeetCode(arr)));
	}
}
