package leetcode_Medium;

/*63 A robot is located at the top-left corner of a m x n grid (marked 'Start'
in the diagram below).The robot can only move either down or right at any point
in time. The robot is trying to reach the bottom-right corner of the grid
(marked 'Finish' in the diagram below).Now consider if some obstacles are added
to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid	 */

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		int intM = obstacleGrid.length, intN = obstacleGrid[0].length;

		/* flip upper left cell (the start cell): 1 => 0 or 0 => 1 */
		obstacleGrid[0][0] ^= 1;

		/* first row: if 1, then 0; otherwise, left cell */
		for (int i = 1; i < intN; i++)
			obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];

		/* first column: if 1, then 0; otherwise, top cell */
		for (int i = 1; i < intM; i++)
			obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];

		/* rest: if 1, then 0; otherwise, left cell + top cell */
		for (int i = 1; i < intM; i++)
			
			for (int j = 1; j < intN; j++)
				
				obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : 
					obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];

		/* return lower right cell (the end cell) */
		return obstacleGrid[intM - 1][intN - 1];
	}
}

/*Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]				Output: 2
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right											 */
