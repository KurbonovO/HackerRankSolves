package leetcode_Medium;

/*935 This time, we place our chess knight on any numbered key of a phone pad
(indicated above), and the knight makes N-1 hops. Each hop must be from one key
to another numbered key. Each time it lands on a key (including the initial
placement of the knight), it presses the number of that key, pressing N digits
total. How many distinct numbers can you dial in this manner? Since the answer
may be large, output the answer modulo 10^9 + 7.
Input: 1	Output: 10
Input: 2	Output: 20
Input: 3	Output: 46														 */

public class KnightDialer {

	public static final int MOD = 1000000007;

	public int knightDialer(int N) {

		int[][] graph = new int[][] { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 },
			{ 3, 9, 0 }, {}, { 1, 7, 0 }, { 2, 6 }, { 1, 3 }, { 2, 4 } };

		int cnt = 0;
		Integer[][] memo = new Integer[N + 1][10];

		for (int i = 0; i <= 9; i++) {
			cnt = (cnt + helper(N - 1, i, graph, memo)) % MOD;
		}
			return cnt;
	}

	private int helper(int N, int cur, int[][] graph, Integer[][] memo) {

		if (N == 0) {
			return 1;
		}

		if (memo[N][cur] != null) {
			return memo[N][cur];
		}

		int cnt = 0;

		for (int nei : graph[cur]) {
			cnt = (cnt + helper(N - 1, nei, graph, memo)) % MOD;
		}
		memo[N][cur] = cnt;
		return cnt;
	}
}
