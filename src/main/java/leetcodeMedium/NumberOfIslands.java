package leetcodeMedium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public int numberOfIslands(char[][] grid) {

		if (grid == null || grid.length == 0) {

			throw new IllegalArgumentException();
		}
		int totalNumberOfRows = grid.length;
		int totalNumberOfColumns = grid[0].length;
		int numberOfIslands = 0;

		for (int r = 0; r < totalNumberOfRows; r++) { //after the first, moves down whole row

			for (int c = 0; c < totalNumberOfColumns; c++) { //after first, moves to right

				if (grid[r][c] == '1') { //checks if in the point of matrix if there is 1

					numberOfIslands++;
					grid[r][c] = '0'; // marked as visited
					Queue<Integer> neighbors = new LinkedList<>();
					neighbors.add(r * totalNumberOfColumns + c);

					while (!neighbors.isEmpty()) {

						int id = neighbors.remove();
						int row = id / totalNumberOfColumns;
						int column = id % totalNumberOfColumns;

						if (row - 1 >= 0 && grid[row - 1][column] == '1') {
							neighbors.add((row - 1) * totalNumberOfColumns + column);
							grid[row - 1][column] = '0'; //marked as visited.
						}
						if (row + 1 < totalNumberOfRows && grid[row + 1][column] == '1') {
							neighbors.add((row + 1) * totalNumberOfColumns + column);
							grid[row + 1][column] = '0'; //marked as visited.
						}
						if (column - 1 >= 0 && grid[row][column - 1] == '1') {
							neighbors.add(row * totalNumberOfColumns + column - 1);
							grid[row][column - 1] = '0'; //marked as visited.
						}
						if (column + 1 < totalNumberOfColumns && grid[row][column + 1] == '1') {
							neighbors.add(row * totalNumberOfColumns + column + 1);
							grid[row][column + 1] = '0'; //marked as visited.
						}
					}
				}
			}
		}
		return numberOfIslands;
	}
	
	public static void main(String[] args) {
		
		char[][] grid = {
				{'1','1','0','0','0'}, 
				{'1','1','0','0','0'}, 
				{'0','0','1','0','0'}, 
				{'0','0','0','1','1'}
				};
		
		NumberOfIslands numberOfIslands = new NumberOfIslands();
		System.out.println(numberOfIslands.numberOfIslands(grid));
	}
}
