package linkedList;

public class IntersectionOfTwoLinkedListsBeck {
	public Node intersectionOfTwoLinkedLists(Node a, Node b) {

		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		while (a != b) {

			while (a != null && a.next != null) {

				while (b != null && b.next != null) {

					if (a.data == b.data) {

					}
				}
			}
		}
		return null;
	}
}
