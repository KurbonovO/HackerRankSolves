package leetcode_Hard;

/*629 
Given two integers n and k, find how many different arrays consist of numbers
from 1 to n such that there are exactly k inverse pairs. We define an inverse
pair as following: For ith and jth element in the array, 
if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.
Since the answer may be very large, the answer should be modulo 10^9 + 7.
Input: n = 3, k = 0		Output: 1
Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0
inverse pair.
Input: n = 3, k = 1		Output: 2
The array [1,3,2] and [2,1,3] have exactly 1 inverse pair					 */

public class KInversePairsArray {

	public static int kInversePairs(int intN, int intK) {
		
		int mod = 1000000007;

		if (intK > intN * (intN - 1) / 2 || intK < 0) {
			return 0;
		}
		if (intK == 0 || intK == intN * (intN - 1) / 2) {
			return 1;
		}

		long[][] dp = new long[intN + 1][intK + 1];
		dp[2][0] = 1;
		dp[2][1] = 1;

		for (int i = 3; i <= intN; i++) {
			dp[i][0] = 1;

			for (int j = 1; j <= Math.min(intK, i * (i - 1) / 2); j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];

				if (j >= i) {
					dp[i][j] -= dp[i - 1][j - i];
				}
				dp[i][j] = (dp[i][j] + mod) % mod;
			}
		}
		return (int) dp[intN][intK];
	}
}
