package leetcodeMedium;

import java.util.LinkedList;
import java.util.List;

public class TreeDiameterD {

	int diameter = 0;

	public int treeDiameter(int[][] edges) {
		int n = edges.length + 1;
		List<Integer>[] graph = new List[n];
		for (int i = 0; i < n; ++i)
			graph[i] = new LinkedList<>();
		for (int[] e : edges) {
			graph[e[0]].add(e[1]);
			graph[e[1]].add(e[0]);
		}
		diameter = 0;
		depth(0, -1, graph);
		return diameter;
	}

	// Depth of the tree is the number of nodes along the longest path from the root
	// node down to the farthest leaf node.
	int depth(int root, int parent, List<Integer>[] graph) {
		int maxDepth1st = 0, maxDepth2nd = 0;
		for (int child : graph[root]) {
			if (child == parent)
				continue; // Only one way from root node to child node, don't allow child node go to root
							// node again!
			int childDepth = depth(child, root, graph);
			if (childDepth > maxDepth1st) {
				maxDepth2nd = maxDepth1st;
				maxDepth1st = childDepth;
			} else if (childDepth > maxDepth2nd) {
				maxDepth2nd = childDepth;
			}
		}
		int longestPathThroughRoot = maxDepth1st + maxDepth2nd + 1; // the number of nodes in the longest path
		diameter = Math.max(diameter, longestPathThroughRoot - 1); // diameter = number of edges = number of nodes - 1
		return maxDepth1st + 1;
	}

}
