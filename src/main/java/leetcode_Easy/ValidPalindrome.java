package leetcode_Easy;

/*Given a string, determine if it is a palindrome, considering only
alphanumeric characters and ignoring cases. Note: For the purpose of this
problem, we define empty string as valid palindrome.
Input: "A man, a plan, a canal: Panama"		Output: true
Input: "race a car"							Output: false					 */

public class ValidPalindrome {
	public boolean isPalindrome(String s) {

		if (s.isEmpty()) {
			return true;
		}

		int head = 0;
		int tail = s.length() - 1;
		char cHead;
		char cTail;

		while (head <= tail) {

			cHead = s.charAt(head);
			cTail = s.charAt(tail);

			if (!Character.isLetterOrDigit(cHead)) {
				head++;
			} else if (!Character.isLetterOrDigit(cTail)) {
				tail--;
			} else {
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
					return false;
				}
				head++;
				tail--;
			}
		}
		return true;
	}
}
