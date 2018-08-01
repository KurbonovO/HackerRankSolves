package leetcode_Hard;

/*44 Given an input string (s) and a pattern (p), implement wildcard pattern
matching with support for '?' and '*'. '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
Input: 	s = "aa" 		p = "a"				Output: false
"a" does not match the entire string "aa".
Input: 	s = "aa" 		p = "*"				Output: true
'*' matches any sequence.
Input: 	s = "cb" 		p = "?a"			Output: false
'?' matches 'c', but the second letter is 'a', which does not match 'b'.
Input: 	s = "adceb" 	p = "*a*b" 			Output: true
The first '*' matches the empty sequence, while the second '*' matches the
substring "dce".
Input: 	s = "acdcb" 	p = "a*c?b" 		Output: false					 */

public class WildcardMatching {
	public boolean comparison(String stringInput, String stringPatternInput) {

		int s = 0, p = 0, match = 0, starIdx = -1;
		while (s < stringInput.length()) {

			/* advancing both pointers */
			if (p < stringPatternInput.length()
					&& (stringPatternInput.charAt(p) == '?' 
					|| stringInput.charAt(s) == stringPatternInput.charAt(p))) {
				s++;
				p++;
			}

			/* * found, only advancing pattern pointer */
			else if (p < stringPatternInput.length() && stringPatternInput.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}

			/* last pattern pointer was *, advancing string pointer */
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}

			/* current pattern pointer is not star, last patter pointer was not * characters
			 do not match */
			else return false;
		}

		/* check for remaining characters in pattern */
		while (p < stringPatternInput.length() && stringPatternInput.charAt(p) == '*')
			p++;

		return p == stringPatternInput.length();
	}
}
