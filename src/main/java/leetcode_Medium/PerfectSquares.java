package leetcode_Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*279 Given a positive integer n, find the least number of perfect square
numbers (for example, 1, 4, 9, 16, ...) which sum to n.
Input: n = 12		Output: 3 
12 = 4 + 4 + 4.
Input: n = 13		Output: 2
13 = 4 + 9																	 */

public class PerfectSquares {
	public int numSquares(int intN) {

		Queue<Integer> queueInt = new LinkedList<>();
		Set<Integer> visitedHash = new HashSet<>();

		queueInt.offer(0);
		visitedHash.add(0);
		int depth = 0;

		while (!queueInt.isEmpty()) {

			int size = queueInt.size();
			depth++;

			while (size-- > 0) {

				int u = queueInt.poll();

				for (int intI = 1; intI * intI <= intN; intI++) {
					int intV = u + intI * intI;

					if (intV == intN) {
						return depth;
					}

					if (intV > intN) {
						break;
					}

					if (!visitedHash.contains(intV)) {
						queueInt.offer(intV);
						visitedHash.add(intV);
					}
				}
			}
		}
		return depth;
	}
}
