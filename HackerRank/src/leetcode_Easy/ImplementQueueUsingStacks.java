package leetcode_Easy;

import java.util.Stack;

/*Implement the following operations of a queue using stacks:
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty								  */

public class ImplementQueueUsingStacks {

	Stack<Integer> input = new Stack<Integer>();
	Stack<Integer> output = new Stack<Integer>();

	public void push(int x) {
		input.push(x);
	}

	public void pop() {
		peek();
		output.pop();
	}

	public int peek() {
		if (output.empty())
			while (!input.empty())
				output.push(input.pop());
		return output.peek();
	}

	public boolean empty() {
		return input.empty() && output.empty();
	}
}

/*I have one input stack, onto which I push the incoming elements, and one output
stack, from which I peek/pop. I move elements from input stack to output stack
when needed, i.e., when I need to peek/pop but the output stack is empty. When
that happens, I move all elements from input to output stack, thereby reversing
the order so it’s the correct order for peek/pop. The loop in peek does the moving
from input to output stack. Each element only ever gets moved like that once, though,
and only after we already spent time pushing it, so the overall amortized cost for
each operation is O(1)														  */ 
