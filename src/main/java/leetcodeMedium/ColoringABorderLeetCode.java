package leetcodeMedium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ColoringABorderLeetCode {

	private static final int[] d = { 0, 1, 0, -1, 0 }; // neighbors' relative displacements.

	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		int clr = grid[r0][c0], m = grid.length, n = grid[0].length;
		Set<Integer> seen = new HashSet<>(); // put the cell number into Set to avoid visiting again.
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r0, c0 }); // add initial cell.
		seen.add(r0 * n + c0); // add initial cell number.
		while (!q.isEmpty()) { // BFS starts.
			int r = q.peek()[0], c = q.poll()[1];
			if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
				grid[r][c] = color;
			} // on grid boundary.
			for (int i = 0; i < 4; ++i) { // Traverse its 4 neighbors.
				int x = r + d[i], y = c + d[i + 1]; // neighbor coordinates.
				if (x < 0 || x >= m || y < 0 || y >= n || seen.contains(x * n + y)) {
					continue;
				} // out of grid or visited already.
				if (grid[x][y] == clr) { // its neighbor is of same color.
					seen.add(x * n + y); // avoid visiting again.
					q.offer(new int[] { x, y }); // put it into Queue.
				} else { // its neighbor is of different color, hence it is on component boundary.
					grid[r][c] = color;
				}
			}
		}
		return grid;
	}

}
