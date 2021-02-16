package leetcodeHard;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumHeightbyStackingCuboidsD {

	public int maxHeight(int[][] A) {
		for (int[] a : A)
			Arrays.sort(a);
		Arrays.sort(A, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return b[0] - a[0];
				if (a[1] != b[1])
					return b[1] - a[1];
				return b[2] - a[2];
			}
		});
		int n = A.length, res = 0, dp[] = new int[n];
		for (int j = 0; j < n; ++j) {
			dp[j] = A[j][2];
			for (int i = 0; i < j; ++i) {
				if (A[i][0] >= A[j][0] && A[i][1] >= A[j][1] && A[i][2] >= A[j][2]) {
					dp[j] = Math.max(dp[j], dp[i] + A[j][2]);
				}
			}
			res = Math.max(res, dp[j]);
		}
		return res;
	}

}
