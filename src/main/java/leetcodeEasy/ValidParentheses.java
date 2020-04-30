package leetcodeEasy;

import java.util.Stack;

public class ValidParentheses {

	public boolean validParentheses(String input) {

		Stack<Character> stackOfParentheses = new Stack<>();

		for (char c : input.toCharArray()) {

			if (c == '(') {

				stackOfParentheses.push(')');

			} else if (c == '{') {

				stackOfParentheses.push('}');

			} else if (c == '[') {

				stackOfParentheses.push(']');

			} else if (stackOfParentheses.isEmpty() || stackOfParentheses.pop() != c) {

				return false;
			}

		}
		return stackOfParentheses.isEmpty();
	}
	
	public static void main(String[] args) {
		
		String input  = "{[]}";
		String input2  = "([)]";
		
		ValidParentheses validParentheses = new ValidParentheses();
		
		System.out.println(validParentheses.validParentheses(input2));
	}
}
