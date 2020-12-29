package leetcodeMedium;

public class CampusBikesIID {

	private int max;

	public int assignBikes(int[][] workers, int[][] bikes) {
		max = Integer.MAX_VALUE;
		dfs(workers, bikes, new boolean[bikes.length], 0, 0);
		return max;

	}

	private void dfs(int[][] workers, int[][] bikes, boolean[] visited, int sum, int count) {
		if (count >= workers.length) {
			if (max > sum)
				max = sum;
			return;
		}

		for (int i = 0; i < bikes.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(workers, bikes, visited, sum + dist(workers[count], bikes[i]), count + 1);
				visited[i] = false;
			}
		}
	}

	private int dist(int[] worker, int[] bike) {
		return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
	}

}
