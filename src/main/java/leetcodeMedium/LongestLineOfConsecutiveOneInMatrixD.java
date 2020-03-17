package leetcodeMedium;

public class LongestLineOfConsecutiveOneInMatrixD {

	public int longestLine(int[][] grid) {
		if (grid.length == 0)
			return 0;
		int dp[][][] = new int[grid.length + 1][grid[0].length + 1][4];
		int ans = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 0) {
					continue;
				}
				dp[r][c][0] = 1 + get(dp, r, c - 1, 0);
				dp[r][c][1] = 1 + get(dp, r - 1, c, 1);
				dp[r][c][2] = 1 + get(dp, r - 1, c - 1, 2);
				dp[r][c][3] = 1 + get(dp, r - 1, c + 1, 3);
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				for (int k = 0; k < 4; k++) {
					ans = Math.max(ans, dp[i][j][k]);
				}
			}
		}
		return ans;
	}

	public int get(int dp[][][], int r, int c, int i) {
		if (r < 0 || r >= dp.length || c < 0 || c >= dp[0].length)
			return 0;
		return dp[r][c][i];
	}

}
