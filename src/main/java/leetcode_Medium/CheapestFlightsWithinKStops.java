package leetcode_Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();

		for (int[] flight : flights) {

			if (!prices.containsKey(flight[0])) {

				prices.put(flight[0], new HashMap<>());
			}
			prices.get(flight[0]).put(flight[1], flight[2]);
		}
		Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));

		priorityQueue.add(new int[] { 0, src, k + 1 });

		while (!priorityQueue.isEmpty()) {

			int[] top = priorityQueue.remove();
			int price = top[0];
			int city = top[1];
			int stops = top[2];

			if (city == dst) {
				return price;
			}
			if (stops > 0) {

				Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());

				for (int a : adj.keySet()) {

					priorityQueue.add(new int[] { price + adj.get(a), a, stops - 1 });
				}
			}
		}
		return -1;
	}
}
