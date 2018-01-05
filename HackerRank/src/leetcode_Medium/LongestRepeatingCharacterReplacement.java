package leetcode_Medium;

import java.util.Scanner;

/*424 Given a string that consists of only uppercase English letters, you can replace
any letter in the string with another letter at most k times. Find the length of
a longest substring containing all repeating letters you can get after performing
the above operations. Both the string's length and k will not exceed 104.
Input:s = "ABAB", k = 2												Output: 4
Replace the two 'A's with two 'B's or vice versa.

Input: s = "AABABBA", k = 1											Output:4
Replace the one 'A' in the middle with 'B' and form "AABBBBA". The substring "BBBB"
has the longest repeating letters, which is 4							*/

public class LongestRepeatingCharacterReplacement {
	//public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	String s = scan.nextLine();
	
	public int characterReplacement(String s, int k) {
		
		int[] count = new int[128];
		int max = 0;
		int start = 0;
		
		for (int end = 0; end < s.length(); end++) {
			max = Math.max(max, ++count[s.charAt(end)]);
			
			if (max + k <= end - start)
				count[s.charAt(start++)]--;
		}
		return s.length() - start;
	}
}

/*Since we are only interested in the longest valid substring, our sliding windows
need not shrink, even if a window may cover an invalid substring. We either grow
the window by appending one char on the right, or shift the whole window to the
right by one. And we only grow the window when the count of the new char exceeds
the historical max count (from a previous window that covers a valid substring).
That is, we do not need the accurate max count of the current window; we only care
if the max count exceeds the historical max count; and that can only happen because
of the new char														*/
