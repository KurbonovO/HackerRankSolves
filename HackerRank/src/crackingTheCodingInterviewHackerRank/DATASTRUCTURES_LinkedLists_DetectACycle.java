//package crackingTheCodingInterviewHackerRank;
//import java.util.*;
///*
//Complete the function provided in the editor below. It has one parameter: a pointer to a Node object named that points to the head of a linked list.
//Your function must return a boolean denoting whether or not there is a cycle in the list. If there is a cycle, return true; otherwise, return false.
//Note: If the list is empty,  will be null. 
//There are 3 scenarios to consider:
//The list is empty (i.e., head is null).
//The list does not contain a cycle, so you can traverse the list and terminate once there are no more nodes (i.e.,  is null).
//The list contains a cycle, so you will be stuck looping forever if you attempt to traverse it. 
//
//To solve this problem we must traverse the list using two pointers that we'll refer to as slow and fast.
//Our slow pointer moves forward 1 node at a time, and our fast pointer moves forward 2 nodes at a time.
//If at any point in time these pointers refer to the same object, then there is a loop; otherwise, the list does not contain a loop. 
//*/
//public class DATASTRUCTURES_LinkedLists_DetectACycle {
//
//	boolean hasCycle(Node head) {
//	    Node fast = head;
//	    
//	    while(fast != null && fast.next != null) {
//	        fast = fast.next.next;
//	        head = head.next;
//	        
//	        if(head.equals(fast)) {
//	            return true;
//	        }
//	    }
//	    return false;
//	}
//
//}
