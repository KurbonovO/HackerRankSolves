package linkedList;

import java.util.HashSet;

public class RemoveDups {
	public Node removeDups(Node linkedList) {

		// Hash to store the seen values;
		HashSet<Integer> hs = new HashSet<Integer>();

		//Pick elements one by one
		Node current = linkedList;
		Node prev = null;
		while (current.next != null) {

			int currentData = current.data;

			if (hs.contains(currentData)) {
				prev.next = current.next;
			} else {
				hs.add(currentData);
				prev = current;
			}
			current = current.next;
		}
		return linkedList;
	}
}
