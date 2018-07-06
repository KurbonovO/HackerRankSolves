package leetcode_Easy;

import java.util.HashSet;

/*409 Given a string which consists of lowercase or uppercase letters, find the
length of the longest palindromes that can be built with those letters. This is
case sensitive, for example "Aa" is not considered a palindrome here.
Input:	"abccccdd"		Output:7
One longest palindrome that can be built is "dccaccd", whose length is 7	 */

public class LongestPalindrome {
	public int longestPalindrome(String stringInput) {

		if (stringInput == null || stringInput.length() == 0) {
			return 0;
		}

		HashSet<Character> hs = new HashSet<Character>();
		int count = 0;

		for (int i = 0; i < stringInput.length(); i++) {

			if (hs.contains(stringInput.charAt(i))) {
				hs.remove(stringInput.charAt(i));
				count++;
			} else {
				hs.add(stringInput.charAt(i));
			}
		}

		if (!hs.isEmpty()) {
			return count * 2 + 1;
		}
		return count * 2;
	}
}
