package linkedList;

public class IntersectionOfTwoLinkedListsLeetCode {
	public Node IntersectionOfTwoLinkedLists(Node headA, Node headB) {

		if (headA == null || headB == null) {
			return null;
		}
		Node a = headA;
		Node b = headB;

		while (a != b) {
			// if a is null return b else go to next box of a
			a = a == null ? headB : a.next;
			// if b is nukk return a else go to next box of b
			b = b == null ? headA : b.next;
		}
		return a;
	}
}
