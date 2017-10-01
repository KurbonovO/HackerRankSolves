package crackingTheCodingInterviewHackerRank;

import java.util.Scanner;

/*Consider a matrix with n rows and m columns, where each cell contains either a 0 or a 1 and any cell containing a is called a filled cell.
Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally;
in other words, cell [i][j] is connected to cells [i-1][j-1], [i-1][j], [i-1][j+1], [i][j-1], [i][j+1], [i+1][j-1], [i+1][j],
and [i+1][j+1], provided that the location exists in the matrix for that [i][j]. If one or more filled cells are also connected,
they form a region. Note that each cell in a region is connected to at least one other cell in the region but is not necessarily directly 
connected to all the other cells in the region.*/

public class ALGORITHMS_DFS_ConnectedCellInAGrid {
	 /*modify it to assign a unique number to each cell identified in a
	 connected component. Because the cells are originally
	 numbered with either a 0 or a 1 but the only cells we care about visiting
	 contain a 1, we just have to mark each cell we
	 visit during our search with some number other than a 1 (e.g., -1, 0,
	 etc.). If you do not wish to modify the values of
	 the original array, you could also maintain another matrix of boolean
	 values tracking whether or not each cell was visited.
	 Finally, keep a running maximum of the number of connected cells found by
	 each DFS. Once the entire matrix has been searched,
	 print this running maximum.*/

	private int rows;
	private int cols;
	private int[][] grid;

	public ALGORITHMS_DFS_ConnectedCellInAGrid(int n, int m, int[][] grid) {
		this.rows = n;
		this.cols = m;
		this.grid = grid;
	}

	/** Returns true of cell is filled AND not yet visited **/
	public boolean isValid(int x, int y) {
		// Returns false if: 1. x or y is out of matrix's bounds 
		//2. cell [x][y] was already visited (contains a -1) or is not filled (contains a 0)

		if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] < 1) {
			return false;
			
		} else {
		 // Current cell is valid (i.e., exists in matrix, is filled and not yet visited)
			return true;
		}
	}

	/** Use DFS to return a count of the number of cells in the region connected to [x][y]. **/
	public int dfs(int x, int y) {
		if (isValid(x, y) == false) {
			return 0;
		}

		int count = 1;
		int newX = x;
		int newY = y;
		grid[x][y] = -1;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				newX = x + i;
				newY = y + j;

				count = count + dfs(newX, newY);
			}
		}
		return count;
	}

	/** Find the largest region in the matrix. **/
	public int solve() {
		// Stores size of current largest region
		int maxVal = 0;
		// Stores size of region currently being checked
		int tempVal = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// Find the number of filled connected cells (if any) for this potential region
				tempVal = dfs(i, j);

				// If the current region is larger than any previously checked region, set new maxV
				if (tempVal > maxVal) {
					maxVal = tempVal;
				}
			}
		}
		return maxVal;
	}

	/** Problem Setup **/
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] matrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		scanner.close();

		ALGORITHMS_DFS_ConnectedCellInAGrid solution = new ALGORITHMS_DFS_ConnectedCellInAGrid(
				n, m, matrix);
		System.out.println(solution.solve());
	}
}

/*Sample Input:
4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
Sample Output:
5
Explanation:
The diagram below depicts two regions of the matrix; for each region, the component cells forming the region are marked with an X:
X X 0 0     1 1 0 0
0 X X 0     0 1 1 0
0 0 X 0     0 0 1 0
1 0 0 0     X 0 0 0
The first region has five cells and the second region has one cell. Because we want to print the number of cells in
the largest region of the matrix, we print 5*/