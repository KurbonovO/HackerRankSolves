package hacker_rank_Thirty;

import java.util.Scanner;

import util.ListNode;

/*A Node class is provided for you in the editor. A Node object has an integer
data field, data, and a Node instance pointer, , pointing to another node (i.e.:
the next node in a list). A Node insert function is also declared in your editor.
It has two parameters: a pointer, head, pointing to the first node of a linked
list, and an integer data value that must be added to the end of the list as a new
Node object. Task: Complete the insert function in your editor so that it creates
a new Node (pass data as the Node constructor argument) and inserts it at the tail
of the linked list referenced by the  parameter. Once the new node is added, return
the reference to the head node												  */

public class DayFifteen {
	public static ListNode insert(ListNode head, int data) {
		// if list has no elements, return a new node
		if (head == null) {
			return new ListNode(data);
		}

		// else iterate through list, add node to tail, and return head
		ListNode tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = new ListNode(data);

		return head;
	}

	public static void display(ListNode head) {
		ListNode start = head;

		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		ListNode head = null;
		int N = scanner.nextInt();

		while (N-- > 0) {
			int ele = scanner.nextInt();
			head = insert(head, ele);
		}
		display(head);
		scanner.close();
	}
}

/*Sample Input:
The following input is handled for you by the locked code in the editor: 
The first line contains T, the number of test cases. 
The  subsequent lines of test cases each contain an integer to be inserted at the
list's tail.
4
2
3
4
1
Sample Output:
The locked code in your editor prints the ordered data values for each element in
your list as a single line of space-separated integers: 2 3 4 1
Explanation
T = 4, so the locked code in the editor will be inserting 4 nodes. The list is
initially empty, so head is null; accounting for this, our code returns a new node
containing the data value  as the  of our list. We then create and insert nodes , 2,
and head at the tail of our list. The resulting list returned by the last call to
is [2,3,4,1], so the printed output is 2 3 4 1								*/
