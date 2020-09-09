package leetcodeHard;

public class GetTheMaximumScoreD {

	public int maxSum(int[] A, int[] B) {
		int i = 0, j = 0, n = A.length, m = B.length;
		long a = 0, b = 0, mod = (long) 1e9 + 7;
		while (i < n || j < m) {
			if (i < n && (j == m || A[i] < B[j])) {
				a += A[i++];
			} else if (j < m && (i == n || A[i] > B[j])) {
				b += B[j++];
			} else {
				a = b = Math.max(a, b) + A[i];
				i++;
				j++;
			}
		}
		return (int) (Math.max(a, b) % mod);
	}

}
