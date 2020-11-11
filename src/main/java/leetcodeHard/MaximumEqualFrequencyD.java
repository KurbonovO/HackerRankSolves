package leetcodeHard;

public class MaximumEqualFrequencyD {

	public int maxEqualFreq(int[] A) {
		int[] count = new int[100001], freq = new int[100001];
		int res = 0, N = A.length, a, c, d;
		for (int n = 1; n <= N; ++n) {
			a = A[n - 1];
			--freq[count[a]];
			c = ++count[a];
			++freq[count[a]];

			if (freq[c] * c == n && n < N)
				res = n + 1;
			d = n - freq[c] * c;
			if ((d == c + 1 || d == 1) && freq[d] == 1)
				res = n;
		}
		return res;
	}

}
