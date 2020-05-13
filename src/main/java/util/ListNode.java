package util;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		String result = val + " ";
	    if (next != null) {
	        result += next.toString();
	    }
	    return result;
	}
}
