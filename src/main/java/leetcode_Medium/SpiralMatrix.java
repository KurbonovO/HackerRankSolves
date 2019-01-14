package leetcode_Medium;

import java.util.ArrayList;
import java.util.List;

/*54 Given a matrix of m x n elements (m rows, n columns), return all elements
of the matrix in spiral order.	Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]										 */

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> list = new ArrayList<>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return list;
		}

		int rowMin = 0;
		int rowMax = matrix.length - 1;
		int colMin = 0;
		int colMax = matrix[0].length - 1;

		while (rowMin <= rowMax && colMin <= colMax) {

			for (int i = colMin; i <= colMax; i++) {

				list.add(matrix[rowMin][i]);
			}

			rowMin++;

			for (int i = rowMin; i <= rowMax; i++) {

				list.add(matrix[i][colMax]);
			}

			colMax--;

			if (rowMin > rowMax || colMin > colMax) {

				break;
			}

			for (int i = colMax; i >= colMin; i--) {

				list.add(matrix[rowMax][i]);
			}

			rowMax--;

			for (int i = rowMax; i >= rowMin; i--) {

				list.add(matrix[i][colMin]);
			}
			colMin++;
		}
		return list;
	}
}
