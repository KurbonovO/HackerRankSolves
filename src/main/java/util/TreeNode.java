package util;

public class TreeNode {

	public int root;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		this.root = x;
	}

	@Override
	public String toString() {
		return "TreeNode [root=" + root + ", left=" + left + ", right=" + right + "]";
	}

}