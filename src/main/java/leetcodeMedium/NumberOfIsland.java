package leetcodeMedium;

public class NumberOfIsland {
	
	//TODO finish

	int x;
	int y;
	char[][] g;

	public int numberOfIslands(char[][] grid) {

		g = grid;
		int count = 0;
		y = g.length;
		x = g[0].length;

		if (y == 0) {
			return 0;
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {

				if (g[i][j] == '1') {

					dfs(i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(int i, int j) {

		if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') {
			return;
		}

		g[i][j] = '0';

		dfs(i + 1, j);
		dfs(i - 1, j);
		dfs(i, j + 1);
		dfs(i, j - 1);
	}

}
