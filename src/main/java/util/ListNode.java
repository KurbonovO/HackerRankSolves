package util;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public class LinkedList {

		ListNode head;

		public void append(int val) {

			// If it is already empty create new and exit out.
			if (head == null) {

				head = new ListNode(val);
				return;
			}

			ListNode current = head;

			// Keep moving until you get the end of list
			while (current.next != null) {

				current = current.next;
			}

			// When we get the end of list we create new Node
			current.next = new ListNode(val);
		}

		public void prepend(int val) {

			// We create a new stand alone node with value
			ListNode newHead = new ListNode(val);

			newHead.next = head;

			// Then we need to change head to new pointer of newHead
			head = newHead;
		}

	}

	@Override
	public String toString() {
		String result = val + " ";
		if (next != null) {
			result += next.toString();
		}
		return result;
	}

}
