package leetcode_Easy;

public class ReverseOnlyLettersDelete {
	public String reverseOnlyLetters(String S) {
		StringBuilder sb = new StringBuilder(S);
		for (int i = 0, j = S.length() - 1; i < j; ++i, --j) {
			while (i < j && !Character.isLetter(sb.charAt(i)))
				++i;
			while (i < j && !Character.isLetter(sb.charAt(j)))
				--j;
			sb.setCharAt(i, S.charAt(j));
			sb.setCharAt(j, S.charAt(i));
		}
		return sb.toString();
	}
}
