package leetcode_Hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*854 Strings A and B are K-similar (for some non-negative integer K) if we can
swap the positions of two letters in A exactly K times so that the resulting
string equals B. Given two anagrams A and B, return the smallest K for which A
and B are K-similar.
Input: A = "ab", B = "ba"		Output: 1
Input: A = "abc", B = "bca"		Output: 2
Input: A = "abac", B = "baca"	Output: 2
Input: A = "aabc", B = "abca"	Output: 2									 */

public class KSimilarStrings {
	public int kSimilarity(String A, String B) {

		if (A.equals(B)) {
			return 0;
		}

		Set<String> vis = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(A);
		vis.add(A);
		int result = 0;

		while (!queue.isEmpty()) {

			result++;

			for (int sz = queue.size(); sz > 0; sz--) {

				String s = queue.poll();
				int i = 0;

				while (s.charAt(i) == B.charAt(i)) {
					i++;
				}

				for (int j = i + 1; j < s.length(); j++) {

					if (s.charAt(j) == B.charAt(j) || s.charAt(i) != B.charAt(j)) {
						continue;
					}

					String temp = swap(s, i, j);

					if (temp.equals(B)) {
						return result;
					}
					if (vis.add(temp)) {
						queue.add(temp);
					}
				}
			}
		}
		return result;
	}

	public String swap(String s, int i, int j) {

		char[] ca = s.toCharArray();
		char temp = ca[i];
		ca[i] = ca[j];
		ca[j] = temp;
		return new String(ca);
	}
}
