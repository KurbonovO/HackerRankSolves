package leetcodeEasy;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigramLeetCode {

	public String[] findOcurrences(String text, String first, String second) {

		List<String> ans = new ArrayList<>();

		int i = 0;

		while (i >= 0) {

			String two = first + ' ' + second + ' ';
			int idx = text.indexOf(two, i);
			int end = idx + two.length();
			int start = end;

			while (end < text.length() && text.charAt(end) != ' ') {

				++end;
			}

			if (idx >= 0 && start < text.length()) {

				ans.add(text.substring(start, end));

			} else {

				break;
			}
			i = idx + first.length() + 1;
		}
		return ans.toArray(new String[0]);
	}

}
