package leetcode_Hard;

/*664 The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at
any places, and will cover the original existing characters.
Given a string consists of lower English letters only, your job is to count the
minimum number of turns the printer needed in order to print it.
Input: "aaabbb"		Output: 2
Print "aaa" first and then print "bbb".

Input: "aba"		Output: 2
Print "aaa" first and then print "b" from the second place of the string, which
will cover the existing character 'a'										 */

public class StrangePrinter {
	public int strangePrinter(String stringInput) {

		int intInputLength = stringInput.length();
		if (intInputLength == 0) {
			return 0;
		}

		int[][] dp = new int[101][101];

		for (int i = 0; i < intInputLength; i++) {
			dp[i][i] = 1;
		}

		for (int i = 1; i < intInputLength; i++) {

			for (int j = 0; j < intInputLength - i; j++) {
				dp[j][j + i] = i + 1;

				for (int k = j + 1; k <= j + i; k++) {

					int temp = dp[j][k - 1] + dp[k][j + i];

					if (stringInput.charAt(k - 1) == stringInput.charAt(j + i)) {
						temp--;
					}
					dp[j][j + i] = Math.min(dp[j][j + i], temp);
				}
			}
		}
		return dp[0][intInputLength - 1];
	}
}
