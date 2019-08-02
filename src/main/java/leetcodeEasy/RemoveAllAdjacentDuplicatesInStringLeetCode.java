package leetcodeEasy;

public class RemoveAllAdjacentDuplicatesInStringLeetCode {

	public static String removeDuplicates(String S) {
		int i = 0, n = S.length();
		char[] stack = new char[n];
		for (int j = 0; j < n; ++j)
			if (i > 0 && stack[i - 1] == S.charAt(j))
				--i;
			else
				stack[i++] = S.charAt(j);
		return new String(stack, 0, i);
	}

}
