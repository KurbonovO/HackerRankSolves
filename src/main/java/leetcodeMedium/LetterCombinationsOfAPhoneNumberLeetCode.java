package leetcodeMedium;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumberLeetCode {

	public List<String> letterCombinations(String digits) {

		LinkedList<String> linkedListAnswear = new LinkedList<String>();

		if (digits.length() == 0) {
			return linkedListAnswear;
		}

		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		linkedListAnswear.add("");

		while (linkedListAnswear.peek().length() != digits.length()) {

			String remove = linkedListAnswear.remove();
			String map = mapping[digits.charAt(remove.length()) - '0'];

			for (char c : map.toCharArray()) {

				linkedListAnswear.addLast(remove + c);
			}
		}
		return linkedListAnswear;
	}

}
