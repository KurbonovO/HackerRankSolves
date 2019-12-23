package leetcodeMedium;

import util.TreeNode;

public class FlipEquivalentBinaryTrees {

	public boolean flipEquiv(TreeNode r1, TreeNode r2) {
		if (r1 == null || r2 == null)
			return r1 == r2;
		return r1.root == r2.root && (flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right)
				|| flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left));
	}

}
