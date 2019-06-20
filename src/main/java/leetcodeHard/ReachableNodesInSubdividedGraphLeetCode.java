package leetcodeHard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReachableNodesInSubdividedGraphLeetCode {

	public int reachableNodes(int[][] edges, int M, int N) {

		// build adjacent matrix
		int[][] adjM = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(adjM[i], -1);
			// Separate the conditions: edge with 0 cost and not connected
		}
		for (int[] edge : edges) {
			adjM[edge[0]][edge[1]] = edge[2]; // adjM is the number of new nodes between two old nodes
			adjM[edge[1]][edge[0]] = edge[2];
		}
		int result = 0;
		boolean[] visited = new boolean[N];
		// max heap for remain moves
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(b[1], a[1]);
		});
		pq.offer(new int[] { 0, M });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[0];
			int moves = cur[1];
			// check old nodes
			if (visited[curNode])
				continue;
			visited[curNode] = true;
			result++;
			// check new nodes
			for (int i = 0; i < N; i++) { // i is the next node
				int cost = adjM[curNode][i] + 1; // cost = new nodes + 1
				// cost = 0 means node and i doesn't connected, the valid cost is at least 1
				if (cost > 0) {
					if (moves >= cost && !visited[i]) {
						pq.offer(new int[] { i, moves - cost });
					}
					// reach only record the new nodes we traveled
					int reach = Math.min(moves, cost - 1); // cost will only reach cost - 1 new nodes
					// old node will be counted at the start of new round;
					result += reach;
					adjM[i][curNode] -= reach;
					// update the remain new nodes from i to curNode
					// this is important since the new nodes could be visited from both side
				}
			}
		}
		return result;
	}

}
