package leetcode_Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*870 Given two arrays A and B of equal size, the advantage of A with respect
to B is the number of indices i for which A[i] > B[i]. Return any permutation
of A that maximizes its advantage with respect to B.
Input: A = [2,7,11,15],  B = [1,10,4,11]		Output: [2,11,7,15]
Input: A = [12,24,8,32], B = [13,25,32,11]		Output: [24,32,8,12]		 */

public class AdvantageShuffle {
	public int[] advantageCount(int[] A, int[] B) {

		Arrays.sort(A);
		int n = A.length;
		int[] result = new int[n];

		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return b[0] - a[0];
			}
		});

		for (int i = 0; i < n; i++) {
			priorityQueue.add(new int[] { B[i], i });

		}

		int low = 0, high = n - 1;

		while (!priorityQueue.isEmpty()) {

			int[] current = priorityQueue.poll();
			int idx = current[1], value = current[0];

			if (A[high] > value) {
				result[idx] = A[high--];
			} else
				result[idx] = A[low++];
		}
		return result;
	}
}
