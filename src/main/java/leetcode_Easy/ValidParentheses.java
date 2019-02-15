package leetcode_Easy;

public class ValidParentheses {
	public boolean validParentheses(String input) {

		char[] arr = input.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] == '(') {
					if (arr[j] == ')') {
						return true;
					}
				}
				if (arr[i] == '[') {
					if (arr[j] == ']') {
						return true;
					}
				}
				if (arr[i] == '{') {
					if (arr[j] == '}') {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.validParentheses("([)]"));
	}

}
