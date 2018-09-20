package leetcode_Hard;

/*32 Given a string containing just the characters '(' and ')', find the length
of the longest valid (well-formed) parentheses substring.
Input: "(()"			Output: 2
The longest valid parentheses substring is "()"
Input: ")()())"			Output: 4
The longest valid parentheses substring is "()()"							 */

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {

		char[] S = s.toCharArray();
		int[] V = new int[S.length];
		int open = 0;
		int max = 0;

		for (int i = 0; i < S.length; i++) {

			if (S[i] == '(') {
				open++;
			}

			if (S[i] == ')' && open > 0) {

				// matches found
				V[i] = 2 + V[i - 1];

				// add matches from previous
				if (i - V[i] > 0) {
					V[i] += V[i - V[i]];
				}
				open--;
			}
			if (V[i] > max)
				max = V[i];
		}
		return max;
	}
}
