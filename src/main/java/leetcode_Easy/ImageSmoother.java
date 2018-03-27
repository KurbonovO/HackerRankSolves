package leetcode_Easy;

/*661 Given a 2D integer matrix M representing the gray scale of an image, you
need to design a smoother to make the gray scale of each cell becomes the
average gray scale (rounding down) of all the 8 surrounding cells and itself.
If a cell has less than 8 surrounding cells, then use as many as you can.
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0					     */

public class ImageSmoother {
	public int[][] imageSmoother(int[][] M) {
		
		int m = M.length;
		
		if (m == 0)
			return M;
		
		int n = M[0].length;
		int[][] result = new int[m][n];
		int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, 0 },
			{ 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };
		
			for (int i = 0; i < m; i++) {
			
			for (int j = 0; j < n; j++) {
				result[i][j] = check(M, direction, i, j);
			}
		}
		return result;
	}

	int check(int[][] M, int[][] direction, int i, int j) {
		
		int m = M.length, n = M[0].length;
		int count = 1;
		int sum = M[i][j];
		
		for (int[] row : direction) {
			int x = i + row[0];
			int y = j + row[1];
			
			if (x < 0 || y < 0 || x >= m || y >= n) {
				continue;
			}
			sum += M[x][y];
			count++;
		}
		return sum / count;
	}
}
