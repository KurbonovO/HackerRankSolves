package leetcode;

/*5 Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000.
Some people will be tempted to come up with a quick solution, which is unfortunately flawed (however can be corrected easily):
Reverse S and become S'. Find the longest common substring between S and S', which must also be the longest palindromic substring.
For example, S = "caba", S'= "abac" The longest common substring between S and S' is which is the answer.
Another example: S = "abacdfgdcaba", S' = abacdgfdcaba The longest common substring between S and S' is
"abacd". Clearly, this is not a valid palindrome*/

public class LongestPalindromicSubstring {
	
	private int lo, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			
			extendPalindrome(s, i, i); //assume odd length, try to extend Palindrome as possible
										
			extendPalindrome(s, i, i + 1); //assume even length.
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		
		while ( j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k) ) {
			j--;
			k++;
		}
		
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
}

/*Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: "cbbd"
Output: "bb"*/