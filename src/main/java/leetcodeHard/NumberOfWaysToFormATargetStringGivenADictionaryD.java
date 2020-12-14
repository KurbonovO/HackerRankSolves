package leetcodeHard;

public class NumberOfWaysToFormATargetStringGivenADictionaryD {

	public int numWays(String[] words, String target) {
		int[][] col_freq = new int[words[0].length()][26]; // for each index in all the words, keep frequency of all
															// characters
		for (String word : words)
			for (int i = 0; i < word.length(); i++)
				col_freq[i][word.charAt(i) - 'a']++;
		return (int) helper(words, target, 0, 0, col_freq, new Long[1001][1001]);
	}

	long mod = (long) (1e9) + 7;

	public long helper(String[] words, String target, int col, int target_index, int[][] col_freq, Long[][] dp) {
		if (dp[col][target_index] != null)
			return dp[col][target_index];
		if (target_index == target.length())
			return 1;
		if (col == words[0].length())
			return 0;

		long ans = helper(words, target, col + 1, target_index, col_freq, dp) % mod; // without considering characters
																						// at index == col
		long freq = col_freq[col][target.charAt(target_index) - 'a'];
		if (freq != 0)
			ans = (ans + (freq * helper(words, target, col + 1, target_index + 1, col_freq, dp)) % mod) % mod; // considering
																												// characters
																												// at
																												// index
																												// ==
																												// col
		return dp[col][target_index] = ans;
	}

}
