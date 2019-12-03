package leetcodeMedium;

public class UglyNumberIIILeetCode {

	public int nthUglyNumber(int n, int a, int b, int c) {

		int ai = 1, bi = 1, ci = 1;
		int next = Math.min(a * ai, Math.min(b * bi, c * ci));

		for (int i = 1; i <= n; i++) {
			next = Math.min(a * ai, Math.min(b * bi, c * ci));

			if (next == a * ai) {
				ai++;
			}
			if (next == b * bi) {
				bi++;
			}
			if (next == c * ci) {
				ci++;
			}
		}
		return next;
	}

}
