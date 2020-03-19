package leetcodeEasy;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public int rottingOranges(int[][] grid) {

		if (grid == null || grid.length == 0) {
			
			return 0;
		}
		int rows = grid.length;
		int collumns = grid[0].length;
		int countFreshOranges = 0;

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < collumns; j++) {

				if (grid[i][j] == 2) {

					queue.offer(new int[] { i, j });

				} else if (grid[i][j] == 1) {

					countFreshOranges++;
				}
			}
		}

		// There are none fresh Oranges, so return 0;
		if (countFreshOranges == 0) {

			return countFreshOranges;
		}

		int days = 0;

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!queue.isEmpty()) {

			++days;
			int queueSize = queue.size();

			for (int i = 0; i < queueSize; i++) {

				// Retrieves and removes the head of this queue
				int[] point = queue.poll();

				for (int[] dir : dirs) {

					int x = point[0] + dir[0];
					int y = point[1] + dir[1];

					if (x < 0 || y < 0 || x >= rows || y >= collumns || grid[x][y] == 0 || grid[x][y] == 2) {

						continue;
					}

					grid[x][y] = 2;
					countFreshOranges--;
					queue.offer(new int[] { x, y });
				}
			}
		}
		return countFreshOranges == 0 ? days : -1;
	}

}
