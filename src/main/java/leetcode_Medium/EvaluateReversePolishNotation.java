package leetcode_Medium;

import java.util.Stack;

/*150 Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6			*/

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] a) {
		
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < a.length; i++) {
			
			switch (a[i]) {
				
				case "+" :
					stack.push(stack.pop() + stack.pop());
					break;

				case "-" :
					stack.push(-stack.pop() + stack.pop());
					break;

				case "*" :
					stack.push(stack.pop() * stack.pop());
					break;

				case "/" :
					int n1 = stack.pop(), n2 = stack.pop();
					stack.push(n2 / n1);
					break;

				default :
					stack.push(Integer.parseInt(a[i]));
			}
		}
		return stack.pop();
	}
}