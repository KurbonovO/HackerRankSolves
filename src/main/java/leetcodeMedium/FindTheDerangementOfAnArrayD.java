package leetcodeMedium;

public class FindTheDerangementOfAnArrayD {

	public int findDerangement(int n) {
		if (n <= 1)
			return 0;
		if (n == 2)
			return 1;
		long prevPrev = 0, prev = 1, curr = 0;
		long mod = 1000000007;
		for (int i = 3; i <= n; i++) {
			curr = (i - 1) * (prevPrev + prev) % mod;
			prevPrev = prev;
			prev = curr;
		}
		return (int) curr;
	}

}
