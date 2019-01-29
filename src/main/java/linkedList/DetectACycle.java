package linkedList;

/*Image as if there is a slow car and fast car going around the race track so if the fast one catches up the slow one doing a
cycle it means its a cycle */

public class DetectACycle {
	public boolean detectACycle(Node head) {

		// if linked list is empty exit out
		if (head == null) {
			return false;
		}

		// fast is a second node
		Node fast = head.next;
		Node slow = head;

		while (fast != null && fast.next != null && slow != null) {

			// if fast is equal to slow we found its cycle
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}
}
