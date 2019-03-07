package leetcode_Easy;

import linkedList.Node;

public class IntersectionOfTwoLinkedListsBeck {
	public Node IntersectionOfTwoLinkedLists(Node A, Node B) {

		if (A == null || B == null) {
			return null;
		}

		Node lineA = A;
		Node lineB = B;

		/* if A and B have different length, then we will stop the loop after second
		 * iteration
		 */
		while (A != B) {

			/* For the end of first iteration, we just reset the pointer to the head of
			 * another Node
			 */

			if (lineA == null) {
				return B;
			} else {
				lineA = lineA.next;
			}

			if (lineB == null) {
				return A;
			} else {
				lineB = lineB.next;
			}
		}
		return lineA;
	}
}
