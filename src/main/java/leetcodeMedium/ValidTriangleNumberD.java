package leetcodeMedium;

import java.util.Arrays;

public class ValidTriangleNumberD {

	public static int triangleNumber(int[] A) {
		Arrays.sort(A);
		int count = 0, n = A.length;
		for (int i = n - 1; i >= 2; i--) {
			int l = 0, r = i - 1;
			while (l < r) {
				if (A[l] + A[r] > A[i]) {
					count += r - l;
					r--;
				} else
					l++;
			}
		}
		return count;
	}

}
