package leetcodeMedium;

public class FindSmallestCommonElementinAllRowsD {

	public int smallestCommonElement(int[][] A) {
		int[] count = new int[10001];
		int n = A.length, m = A[0].length;
		for (int j = 0; j < m; ++j)
			for (int i = 0; i < n; ++i)
				if (++count[A[i][j]] == n)
					return A[i][j];
		return -1;
	}

}
