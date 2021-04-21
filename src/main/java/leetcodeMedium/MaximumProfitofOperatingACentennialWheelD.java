package leetcodeMedium;

public class MaximumProfitofOperatingACentennialWheelD {

	public int minOperationsMaxProfit(int[] cs, int bc, int rc) {
		int run = 0, maxRun = 1, prof = 0, maxProf = prof, sum = 0, i = 0;
		while (sum > 0 || i < cs.length) {
			if (i < cs.length)
				sum += cs[i++];
			int bd = Math.min(4, sum); // boarding people by greedy.
			sum -= bd;
			prof = prof + bd * bc - rc;
			run++;
			if (prof > maxProf) {
				maxProf = prof;
				maxRun = run;
			}
		}
		return maxProf > 0 ? maxRun : -1;
	}

}
