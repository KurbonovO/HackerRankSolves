package leetcodeHard;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxValueofEquationD {

	public int findMaxValueOfEquation(int[][] points, int k) {
		Deque<Integer, Integer> ms = new ArrayDeque<>();
		int res = Integer.MIN_VALUE;
		for (int[] point : points) {
			while (!ms.isEmpty() && point[0] - ms.peekFirst().getValue() > k) {
				ms.pollFirst();
			}
			if (!ms.isEmpty()) {
				res = Math.max(res, ms.peekFirst().getKey() + point[0] + point[1]);
			}
			while (!ms.isEmpty() && point[1] - point[0] > ms.peekLast().getKey()) {
				ms.pollLast();
			}
			ms.offerLast(point[1] - point[0], point[0]);
		}
		return res;
	}

}
