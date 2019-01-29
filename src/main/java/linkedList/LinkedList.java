package linkedList;

public class LinkedList {

	Node head;

	// add items to the linked list at the end.
	public void append(int data) {

		// if the head is null we actually want to create new node
		if (head == null) {
			head = new Node(data);
			// in void, this operation exits out.
			return;
		}
		Node current = head;
		// while till the end is not null
		while (current.next != null) {
			current = current.next;
		}
		// we take the null element and add in new value of data
		current.next = new Node(data);
	}

	public void prepend(int data) {

		// We create new head value
		Node newHead = new Node(data);
		// newHead next value is going to link over to old head
		newHead.next = head;
		// then we need to change head pointer
		head = newHead;
	}

	public void deleteWithValue(int data) {

		// if head is null we can't delete anything, so exit out.
		if (head == null) {
			return;
		}
		// if actually head is the data we wanted to delete
		if (head.data == data) {
			head = head.next;
			return;
		}

		// Otherwise walk throught the linked list
		Node current = head;
		// iterate over the node and make sure last one is not null and stop before it
		while (current.next != null) {
			// if it's the value you want to actually delete
			if (current.next.data == data) {
				// skep over the value
				current.next = current.next.next;
				// exit
				return;
			}
			current = current.next;
		}
	}
}
