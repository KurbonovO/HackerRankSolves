package leetcodeHard;

public class InterleavingStringLeetCode {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		int n1 = s1.length(), n2 = s2.length();
		boolean[][] dp = new boolean[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			for (int j = 0; j <= n2; j++) {
				if (i == 0 && j == 0) { // s1 empty, s2 empty
					dp[i][j] = true;
				} else {
					dp[i][j] = (i > 0 && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
							|| (j > 0 && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
				}
			}
		}
		return dp[n1][n2];
	}

}
