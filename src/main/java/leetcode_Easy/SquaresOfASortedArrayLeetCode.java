package leetcode_Easy;

//Does not use the Arrays sort.

public class SquaresOfASortedArrayLeetCode {
	public int[] sortedSquares(int[] A) {

		int n = A.length;
		int[] result = new int[n];
		int i = 0;
		int j = n - 1;

		for (int p = n - 1; p >= 0; p--) {
			
			if (Math.abs(A[i]) > Math.abs(A[j])) {
				
				result[p] = A[i] * A[i];
				i++;
			} else {
				result[p] = A[j] * A[j];
				j--;
			}
		}
		return result;
	}
}
