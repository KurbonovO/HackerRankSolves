package leetcode_Hard;

public class PreimageSizeOfFactorialZeroesFunction {
	public int preimageSizeFZF(int K) {
		long l = 0, r = K / 5;

		while (l <= r) {
			long m = l + (r - l) / 2;
			long k = m * 5 + numOfTrailingZeros(m * 5);

			if (k <= K) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}

		return (K < r * 5 + numOfTrailingZeros(r * 5) + 5 ? 5 : 0);
	}

	private long numOfTrailingZeros(long x) {
		long res = 0;

		for (; x > 0; x /= 5) {
			res += x / 5;
		}

		return res;
	}
}
