package util;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
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
