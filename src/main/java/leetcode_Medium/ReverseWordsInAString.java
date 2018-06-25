package leetcode_Medium;

/*151 Given an input string, reverse the string word by word
Input: "the sky is blue",		Output: "blue is sky the"					 */

public class ReverseWordsInAString {
	public String reverseWords(String stringInput) {

		if (stringInput == null)
			return null;

		char[] charOfInput = stringInput.toCharArray();
		int n = charOfInput.length;

		/* reverse the whole string */
		reverse(charOfInput, 0, n - 1);
		/* reverse each word */
		reverseWords(charOfInput, n);
		/* clean up spaces */
		return cleanSpaces(charOfInput, n);
	}

	void reverseWords(char[] a, int n) {
		int i = 0, j = 0;

		while (i < n) {

			while (i < j || i < n && a[i] == ' ')
				i++; // skip spaces

			while (j < i || j < n && a[j] != ' ')
				j++; // skip non spaces

			/* reverse the word */
			reverse(a, i, j - 1);
		}
	}

	/* trim leading, trailing and multiple spaces */
	String cleanSpaces(char[] a, int n) {
		int i = 0, j = 0;

		while (j < n) {

			while (j < n && a[j] == ' ')
				j++; // skip spaces

			while (j < n && a[j] != ' ')
				a[i++] = a[j++]; // keep non spaces

			while (j < n && a[j] == ' ')
				j++; // skip spaces
			if (j < n)
				/* keep only one space */
				a[i++] = ' ';
		}

		return new String(a).substring(0, i);
	}

	/* reverse a[] from a[i] to a[j] */
	private void reverse(char[] a, int i, int j) {

		while (i < j) {
			char t = a[i];
			a[i++] = a[j];
			a[j--] = t;
		}
	}
}
