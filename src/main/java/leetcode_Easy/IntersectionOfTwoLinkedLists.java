package leetcode_Easy;

/*160 Write a program to find the node at which the intersection of two singly
linked lists begins. For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3							begin to intersect at node c1	 */

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	   
		//boundary check
	    if(headA == null || headB == null) {
	    	return null;
	    }
	    
	    ListNode listNodeA = headA;
	    ListNode listNodeB = headB;
	    
	    //if a & b have different len, then we will stop the loop after second
	    //iteration
	    while( listNodeA != listNodeB){
	    	
	    	//for the end of first iteration, we just reset the pointer to the
	    	//head of another linkedlist
	        listNodeA = listNodeA == null ? headB : listNodeA.next;
	        listNodeB = listNodeB == null ? headA : listNodeB.next;    
	    }
	    return listNodeA;
	}
}
