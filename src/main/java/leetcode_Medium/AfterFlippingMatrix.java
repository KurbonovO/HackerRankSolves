package leetcode_Medium;

/*861 We have a two dimensional matrix A where each value is 0 or 1. A move
consists of choosing any row or column, and toggling each value in that row or
column: changing all 0s to 1s, and all 1s to 0s. After making any number of
moves, every row of this matrix is interpreted as a binary number, and the
score of the matrix is the sum of these numbers. Return the highest possible
score																		 */

public class AfterFlippingMatrix {
	public int matrixScore(int[][] A) {
		
		int M = A.length, N = A[0].length, res = (1 << (N - 1)) * M;
		
		for (int j = 1; j < N; j++) {
			
			int cur = 0;
			
			for (int i = 0; i < M; i++) {
				cur += A[i][j] == A[i][0] ? 1 : 0;
			}	
			res += Math.max(cur, M - cur) * (1 << (N - j - 1));
		}
		return res;
	}
}

/*Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]		Output: 39
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39									 */ 
