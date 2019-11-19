package leetcodeMedium;

public class SortArrayByParityIILeetCode {

	public int[] sortArrayByParityII(int[] A) {
		int i = 0, j = 1, n = A.length;
		while (i < n && j < n) {
			while (i < n && A[i] % 2 == 0) {
				i += 2;
			}
			while (j < n && A[j] % 2 == 1) {
				j += 2;
			}
			if (i < n && j < n) {
				swap(A, i, j);
			}
		}
		return A;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
