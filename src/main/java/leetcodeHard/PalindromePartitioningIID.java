package leetcodeHard;

public class PalindromePartitioningIID {

	private char[] chars;
	private int[] dp;

	public int minCut(String s) {
		this.chars = s.toCharArray();
		this.dp = new int[this.chars.length + 1];

		// initialize dp array; all are substrings length 1
		for (int i = 0; i < this.chars.length + 1; i++)
			this.dp[i] = i - 1;

		// as per #5; expand about mid point
		for (int i = 0; i < this.chars.length; i++) {
			expand(i, i);
			expand(i, i + 1);
		}

		return this.dp[this.dp.length - 1];
	}

	private void expand(int i, int j) {
		// expand to left and right
		while (i >= 0 && this.chars[i] == this.chars[j]) {
			// S[i:j] is a palindrome
			// update min cut at j + 1 by left min cut at i + current palindrome
			this.dp[j + 1] = Math.min(this.dp[j + 1], this.dp[i] + 1);
			i--;
			j++;
		}
	}

}
