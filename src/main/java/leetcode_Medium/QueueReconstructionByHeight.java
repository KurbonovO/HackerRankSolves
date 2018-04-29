package leetcode_Medium;

import java.util.Arrays;
import java.util.Comparator;

/*406 Suppose you have a random list of people standing in a queue. Each person
is described by a pair of integers (h, k), where h is the height of the person
and k is the number of people in front of this person who have a height greater
than or equal to h. Write an algorithm to reconstruct the queue.
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]									 */

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {

		if (people.length == 0)
			return new int[0][2];
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return b[0] - a[0];
				else
					return a[1] - b[1];
			}
		});
		Node node = new Node(people[0]);
		
		for (int i = 1; i < people.length; i++)
			node = insert(node, people[i]);
		
		int[][] resAr = new int[people.length][2];
		
		for (int i = 0; i < people.length; i++, node = node.next)
			resAr[i] = node.person;
		return resAr;
	}

	public Node insert(Node node, int[] person) {
		Node newNode = new Node(person);
		int rank = person[1], height = person[0];
		
		if (rank == 0) {
			newNode.next = node;
			return newNode;
		}
		
		Node curr = node;
		
		while (rank > 1) {
			curr = curr.next;
			rank--;
		}
		Node next = curr.next;
		newNode.next = next;
		curr.next = newNode;
		return node;
	}

	public static class Node {
		int[] person;
		Node next;

		public Node(int[] p) {
			person = p;
		}
	}
}