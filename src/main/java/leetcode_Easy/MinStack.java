package leetcode_Easy;

import java.util.Stack;

/*Design a stack that supports push, pop, top, and retrieving the minimum
element in constant time
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2											 */

public class MinStack {

	static class Element {
		final int value;
		final int min;

		Element(final int value, final int min) {
			this.value = value;
			this.min = min;
		}
	}

	final Stack<Element> stack = new Stack<>();

	public void push(int x) {
		final int min = (stack.empty()) ? x : Math.min(stack.peek().min, x);
		stack.push(new Element(x, min));
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek().value;
	}

	public int getMin() {
		return stack.peek().min;
	}
}