package leetcode_Medium;

/*684 In this problem, a tree is an undirected graph that is connected and has
no cycles. The given input is a graph that started as a tree with N nodes (with
distinct values 1, 2, ..., N), with one additional edge added. The added edge
has two different vertices chosen from 1 to N, and was not an edge that already
existed. The resulting graph is given as a 2D-array of edges. Each element of
edges is a pair [u, v] with u < v, that represents an undirected edge 
connecting nodes u and v. Return an edge that can be removed so that the
resulting graph is a tree of N nodes. If there are multiple answers, return the
answer that occurs last in the given 2D-array. The answer edge [u, v] should be
in the same format, with u < v												 */

public class RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
		
		int numNodes = edges.length;
		int[] roots = new int[numNodes + 1];
		
		for (int i = 1; i <= numNodes; i++) {
			roots[i] = i;
		}
		
		int j = 0;
		
		while (j < edges.length) {
			int[] e = edges[j];
			int root1 = find(roots, e[0]);
			int root2 = find(roots, e[1]);
			if (root1 == root2) {
				break;
			}	
			roots[root1] = root2;
			j++;
		}
		return edges[j];
	}

	private int find(int[] roots, int id) {
	
		while (id != roots[id]) {
			roots[id] = roots[roots[id]];
			id = roots[id];
		}
		return id;
	}
}

/*Input: [[1,2], [1,3], [2,3]]					Output: [2,3]
The given undirected graph will be like this:
  1
 / \
2 - 3

Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]		Output: [1,4]
The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3																	 */
