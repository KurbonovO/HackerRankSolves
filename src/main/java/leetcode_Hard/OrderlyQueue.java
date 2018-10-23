package leetcode_Hard;

import java.util.Arrays;

/*899 A string S of lowercase letters is given. Then, we may make any number of
moves. In each move, we choose one of the first K letters (starting from the
left), remove it, and place it at the end of the string. Return the
lexicographically smallest string we could have after any number of moves.
Input: S = "cba", K = 1			Output: "acb"
In the first move, we move the 1st character ("c") to the end, obtaining the
string "bac". In the second move, we move the 1st character ("b") to the end,
obtaining the final result "acb".
Input: S = "baaca", K = 3		Output: "aaabc"
In the first move, we move the 1st character ("b") to the end, obtaining the
string "aacab". In the second move, we move the 3rd character ("c") to the end,
obtaining the final result "aaabc"											 */

public class OrderlyQueue {
	public String orderlyQueue(String s, int k) {

		if (k > 1) {
			char S2[] = s.toCharArray();
			Arrays.sort(S2);
			return new String(S2);
		}

		String res = s;

		for (int i = 1; i < s.length(); i++) {

			String tmp = s.substring(i) + s.substring(0, i);

			if (res.compareTo(tmp) > 0) {
				res = tmp;
			}
		}
		return res;
	}
}
