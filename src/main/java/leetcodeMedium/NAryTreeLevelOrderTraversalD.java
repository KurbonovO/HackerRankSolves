package leetcodeMedium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import linkedList.Node;

public class NAryTreeLevelOrderTraversalD {

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> ret = new LinkedList<>();

		if (root == null)
			return ret;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> curLevel = new LinkedList<>();
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Node curr = queue.poll();
				curLevel.add(curr.data);
				
			}
			ret.add(curLevel);
		}

		return ret;
	}

}
