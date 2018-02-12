package hacker_rank_Thirty;

import java.util.Scanner;

import util.ListNode;

/*A removeDuplicates function is declared in your editor, which takes a pointer
to the head node of a linked list as a parameter. Complete removeDuplicates so that
it deletes any duplicate nodes from the list and returns the head of the updated
list																		  */

public class DayTwentyfour {

	public static ListNode removeDuplicates(ListNode head) {
		
		// Empty list case:
		if (head == null) {
			return head;
		}

		ListNode current = head;
		
		while (current.next != null) {
			
			// If data is equal, reset the next pointer
			if (current.data == (current.next).data) {
				current.next = (current.next).next;
			} 
			else {
				// If data is not equal, go to the next element
				current = current.next;
			}
		}
		return head;
	}
	
	public static ListNode insert(ListNode head, int data) {
		
		ListNode listNode = new ListNode(data);
		
		if (head == null)
			head = listNode;
		
		else if (head.next == null)
			head.next = listNode;
		
		else {
			ListNode start = head;
			
			while (start.next != null)
				start = start.next;
			start.next = listNode;

		}
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
		int T = scanner.nextInt();
		
		while (T-- > 0) {
			int ele = scanner.nextInt();
			head = insert(head, ele);
		}
		
		scanner.close();
		head = removeDuplicates(head);
		display(head);
	}
}

/*Sample Input: 6
1
2
2
3
3
4
Sample Output: 1 2 3 4 
N = 6, and our non-decreasing list is {1,2,2,3,3,4}. The values 2 and 3 both occur
twice in the list, so we remove the two duplicate nodes. We then return our updated
(ascending) list, which is {1,2,3,4}										  */
