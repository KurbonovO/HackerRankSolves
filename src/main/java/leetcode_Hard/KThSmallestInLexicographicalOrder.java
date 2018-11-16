package leetcode_Hard;

/*440 Given integers n and k, find the lexicographically k-th smallest integer
in the range from 1 to n.
Input:	n: 13   k: 2		Output:	10
The lexicographical order is 
[1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is
10																			 */

public class KThSmallestInLexicographicalOrder {
	public int findKthNumber(int n, int k) {
		
		int current = 1;
		k = k - 1;

		while (k > 0) {

			int steps = calSteps(n, current, current + 1);

			if (steps <= k) {
				current += 1;
				k -= steps;
			} else {
				current *= 10;
				k -= 1;
			}
		}
		return current;
	}

	// use long in case of overflow
	public int calSteps(int n, long n1, long n2) {

		int steps = 0;

		while (n1 <= n) {
			steps += Math.min(n + 1, n2) - n1;
			n1 *= 10;
			n2 *= 10;
		}
		return steps;
	}
}
