package leetcode_Medium;

import util.*;

import java.util.*;

/*445 You are given two non-empty linked lists representing two non-negative
integers. The most significant digit comes first and each of their nodes contain
a single digit. Add the two numbers and return it as a linked list. You may assume
the two numbers do not contain any leading zero, except the number 0 itself. What
if you cannot modify the input lists? In other words, reversing the lists is not allowed.
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)                      Output: 7 -> 8 -> 0 -> 7 */

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        while (listNode1 != null) {
            stack1.push(listNode1.val);
            listNode1 = listNode1.next;
        }

        while (listNode2 != null) {
            stack2.push(listNode2.val);
            listNode2 = listNode2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);

        while (!stack1.empty() || !stack2.empty()) {

            if (!stack1.empty()) sum += stack1.pop();

            if (!stack2.empty()) sum += stack2.pop();

            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        return list.val == 0 ? list.next : list;
    }
}
