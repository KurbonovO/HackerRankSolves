package stacksAndQueues;

public class Stack {

	private static class Node {
		private int data;
		private Node next;

		private Node(int data) {
			this.data = data;
		}
	}

	/* adds and removes from the top only */
	private Node top;

	public boolean isEmpty() {

		if (top == null) {
			return true;
		} else {
			return false;
		}
	}

	public int peek() {

		return top.data;
	}

	public void push(int data) {

		Node node = new Node(data);
		node.next = top;
		top = node;
	}

	public int pop() {

		int data = top.data;
		top = top.next;
		return data;
	}
}
