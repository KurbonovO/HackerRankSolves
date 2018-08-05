package leetcode_Hard;

/*87 Given a string s1, we may represent it as a binary tree by partitioning it
to two non-empty substrings recursively. Below is one possible representation
of s1 = "great":
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two
children For example, if we choose the node "gr" and swap its two children, it
produces a scrambled string "rgeat".
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great". Similarly, if we continue
to swap the children of nodes "eat" and "at", it produces a scrambled string 
"rgtae".
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great". Given two strings s1 and
s2 of the same length, determine if s2 is a scrambled string of s1.
Input: s1 = "great", s2 = "rgeat"						Output: true
Input: s1 = "abcde", s2 = "caebd"						Output: false		 */

public class ScrambleString {
	public boolean isScramble(String stringInputS1, String stringInputS2) {

		if (stringInputS1.equals(stringInputS2)) {
			return true;
		}

		int[] letters = new int[26];

		for (int i = 0; i < stringInputS1.length(); i++) {
			letters[stringInputS1.charAt(i) - 'a']++;
			letters[stringInputS2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++)

			if (letters[i] != 0) {
				return false;
			}
		
		for (int i = 1; i < stringInputS1.length(); i++) {

			if (isScramble(stringInputS1.substring(0, i), stringInputS2.substring(0, i))
					&& isScramble(stringInputS1.substring(i), stringInputS2.substring(i))) {
				return true;
			}

			if (isScramble(stringInputS1.substring(0, i), 
					stringInputS2.substring(stringInputS2.length() - i))
					&& isScramble(stringInputS1.substring(i), 
							stringInputS2.substring(0, stringInputS2.length() - i))) {
				return true;
			}
		}
		return false;
	}
}
