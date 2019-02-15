package crackingTheCodingInterview;

import linkedList.Node;

public class RemoveDups {
	public Node removeDups(Node linkedList) {

		if (linkedList == null || linkedList.next == null) {
			return linkedList;
		}

		//Creating the returning LinkedList
		Node list = linkedList;

		//start of the iteration
		while (list.next != null) {

			if (list.data == list.next.data) {
				list.next = list.next.next;
			} else {
				list = list.next;
			}
		}
		return list;
	}
}
