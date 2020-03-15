package leetcodeEasy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Time complexity: O(n) because we simply traverse the given string one character at a
 * time and push and pop operations on a stack take O(1)O(1) time.
 * Space complexity: O(n) as we push all opening brackets onto the stack and in the worst case,
 * we will end up pushing all the brackets onto the stack. e.g. ((((((((((
 */
public class ValidParentheses {

	public static Map<Character, Character> mapping = new HashMap<>();
	static {
		mapping.put(')', '(');
		mapping.put('}', '{');
		mapping.put(']', '[');
	}

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (mapping.containsKey(c)) { // If the current character is a closing bracket.

				// Get the top element of the stack. If the stack is empty, set a dummy value of '#'
				char topElement = stack.isEmpty() ? '#' : stack.pop();

				// If the mapping for this bracket doesn't match the stack's top element, return false.
				if (topElement != mapping.get(c)) {

					return false;
				}
			} else {
				// If it was an opening bracket, push to the stack.
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.isValid("(((((())))))"));
	}
}
