package leetcodeMedium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesBeck {

	// Was not able to solve but did do debugging. Still do not understand.
	public static List<String> generateParenthesis(int n) {

		List<String> output = new ArrayList<String>();

		backTrack(output, "", 0, 0, n);

		return output;
	}

	public static void backTrack(List<String> output, String string, int open, int close, int n) {

		// For every input n we gotta have closing parentheses that why we do times 2.
		if (string.length() == n * 2) {
			output.add(string);
			return;
		}

		// Start by populating opening ones
		if (open < n) {

			backTrack(output, string + "(", open + 1, close, n);
		}
		if (close < open) {

			backTrack(output, string + ")", open, close + 1, n);
		}

	}

	public static void main(String[] args) {

		System.out.println(GenerateParenthesesBeck.generateParenthesis(3));
	}

}
