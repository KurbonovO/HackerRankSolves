package leetcode_Easy;

import java.util.LinkedList;
import java.util.Queue;

/*225 Implement the following operations of a stack using queues
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
MyStack stack = new MyStack();
stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false												 */

public class ImplementStackUsingQueues {

	/* using two queue. The pop and top are inefficient */
	private Queue<Integer> firstQueueInteger = new LinkedList<Integer>();
	private Queue<Integer> secondQueueInteger = new LinkedList<Integer>();

	public void push(int x) {
		if (!firstQueueInteger.isEmpty()) {
			firstQueueInteger.add(x);
		} else {
			secondQueueInteger.add(x);
		}
	}

	public void pop() {
		
		if (firstQueueInteger.isEmpty()) {
			int size = secondQueueInteger.size();
			
			for (int i = 1; i < size; i++) {
				firstQueueInteger.add(secondQueueInteger.poll());
			}
			secondQueueInteger.poll();
		} else {
			int size = firstQueueInteger.size();
			
			for (int i = 1; i < size; i++) {
				secondQueueInteger.add(firstQueueInteger.poll());
			}
			firstQueueInteger.poll();
		}
	}

	public int top() {
		
		int intOutput;
		
		if (firstQueueInteger.isEmpty()) {
			int size = secondQueueInteger.size();
			
			for (int i = 1; i < size; i++) {
				firstQueueInteger.add(secondQueueInteger.poll());
			}
			
			intOutput = secondQueueInteger.poll();
			firstQueueInteger.add(intOutput);
		
		} else {
			int size = firstQueueInteger.size();
			
			for (int i = 1; i < size; i++) {
				secondQueueInteger.add(firstQueueInteger.poll());
			}
			intOutput = firstQueueInteger.poll();
			secondQueueInteger.add(intOutput);
		}
		return intOutput;
	}

	public boolean empty() {
		return firstQueueInteger.isEmpty() && secondQueueInteger.isEmpty();
	}
}
