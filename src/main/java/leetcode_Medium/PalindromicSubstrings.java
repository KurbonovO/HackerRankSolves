package leetcode_Medium;

/*647 Given a string, your task is to count how many palindromic substrings in this string. The substrings with different
start indexes or end indexes are counted as different substrings even they consist of same characters.
Input: "abc"		Output: 3
Three palindromic strings: "a", "b", "c".
Input: "aaa"		Output: 6
Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"*/

public class PalindromicSubstrings {
	int count = 0;

	public int countSubstrings(String s) {
		if (s == null || s.length() == 0)
			return 0;

		for (int i = 0; i < s.length(); i++) { // i is the mid point
			extendPalindrome(s, i, i); // odd length;
			extendPalindrome(s, i, i + 1); // even length
		}
		return count;
	}

	private void extendPalindrome(String s, int left, int right) {
		
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
	}
}