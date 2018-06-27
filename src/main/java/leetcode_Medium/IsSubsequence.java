package leetcode_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*392 Given a string s and a string t, check if s is subsequence of t. You may
assume that there is only lower case English letters in both s and t. t is
potentially a very long (length ~= 500,000) string, and s is a short string
(<=100). A subsequence of a string is a new string which is formed from the
original string by deleting some (can be none) of the characters without
disturbing the relative positions of the remaining characters. (ie, "ace" is a
subsequence of "abcde" while "aec" is not).

s = "abc", t = "ahbgdc"		Return true

s = "axc", t = "ahbgdc"		Return false									 */

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		
		/* Just for clarity */
		List<Integer>[] idx = new List[256]; 
		
		for (int i = 0; i < t.length(); i++) {
			
			if (idx[t.charAt(i)] == null) {
				idx[t.charAt(i)] = new ArrayList<>();
			}	
			idx[t.charAt(i)].add(i);
		}

		int prev = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			if (idx[s.charAt(i)] == null) {
				/* Note: char of S does NOT exist in T causing NPE */
				return false; 
			}	
			
			int j = Collections.binarySearch(idx[s.charAt(i)], prev);
			
			if (j < 0) {
				j = -j - 1;
			}
			if (j == idx[s.charAt(i)].size()) {
				return false;
			}
			prev = idx[s.charAt(i)].get(j) + 1;
		}
		return true;
	}
}
