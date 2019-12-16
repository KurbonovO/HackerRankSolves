package leetcodeMedium;

import java.util.Random;

import util.ListNode;

public class LinkedListRandomNode {

	public class Solution {

		ListNode head;
		Random random;

		public Solution(ListNode h) {
			head = h;
			random = new Random();
		}

		public int getRandom() {

			ListNode c = head;
			int r = c.val;
			for (int i = 1; c.next != null; i++) {

				c = c.next;
				if (random.nextInt(i + 1) == i)
					r = c.val;
			}

			return r;
		}
	}

}
