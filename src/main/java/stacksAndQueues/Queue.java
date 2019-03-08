package stacksAndQueues;

public class Queue {

	public static class Node {

		private int data;
		private Node next;

		private Node(int data) {
			this.data = data;
		}
	}

	/* Remove from the head */
	private Node head;

	/* add things here */
	private Node tail;

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	public int peek() {
		return head.data;
	}

	public void add(int data) {
		Node node = new Node(data);
		if (tail != null) {
			tail.next = node;
		}
		tail = node;
		if (head == null) {
			head = node;
		}
	}

	public int remove() {
		int data = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return data;
	}

}
