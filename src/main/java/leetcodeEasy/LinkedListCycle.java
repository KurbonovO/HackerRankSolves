package leetcodeEasy;

import util.ListNode;

/**
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class LinkedListCycle {

	public boolean linkedListCycle(ListNode head) {

		ListNode walker = head;
		ListNode runner = head;

		while (runner != null && runner.next != null) {

			walker = walker.next;
			runner = runner.next.next;

			if (walker == runner) {
				return true;
			}
		}
		return false;
	}

}
