package leetcode_Medium;

/*790 We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape
These shapes may be rotated.
XX  <- domino

XX  <- "L" tromino
X
Given N, how many ways are there to tile a 2 x N board? Return your answer
modulo 10^9 + 7.
(In a tiling, every square must be covered by a tile. Two tilings are different
if and only if there are two 4-directionally adjacent cells on the board such
that exactly one of the tilings has both squares occupied by a tile.)
Input: 3		Output: 5
The five different ways are listed below, different letters indicates different
tiles:
XYZ XXZ XYY XXY XYY
XYZ YYZ XZZ XYY XXY															 */

public class DominoAndTrominoTiling {
	private static final int MOD = 1_000_000_007;

	public int numTilings(int N) {
		
		int T_prepre = 1, T_pre = 1;
		int T_up_pre = 0, T_down_pre = 0;

		for (int n = 2; n <= N; n++) {
			
			int T_cur = (int) ((0L + T_prepre + T_pre + T_up_pre + T_down_pre)
					% MOD);
			
			int T_up_cur = (T_prepre + T_down_pre) % MOD;
			int T_down_cur = (T_prepre + T_up_pre) % MOD;

			T_prepre = T_pre;
			T_pre = T_cur;

			T_up_pre = T_up_cur;
			T_down_pre = T_down_cur;
		}
		return T_pre;
	}
}
