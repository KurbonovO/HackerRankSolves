package leetcodeMedium;

public class RotateFunctionLeetCode {

	public int maxRotateFunction(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int sum = 0, iteration = 0, len = A.length;

		for (int i = 0; i < len; i++) {
			sum += A[i];
			iteration += (A[i] * i);
		}

		int max = iteration;
		for (int j = 1; j < len; j++) {
			// for next iteration lets remove one entry value of each entry and the prev 0 *
			// k
			iteration = iteration - sum + A[j - 1] * len;
			max = Math.max(max, iteration);
		}

		return max;
	}

}
