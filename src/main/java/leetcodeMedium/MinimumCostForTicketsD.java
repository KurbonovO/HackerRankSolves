package leetcodeMedium;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumCostForTicketsD {

	public int mincostTickets(int[] days, int[] costs) {
		// using queue so that the oldest ticket is at the top.
		Queue<int[]> last7days = new LinkedList<>(), last30days = new LinkedList<>();

		int totalCost = 0;
		for (int i = 0; i < days.length; i++) {
			// discarding expired 7days pass
			while (!last7days.isEmpty() && last7days.peek()[0] + 7 <= days[i]) {
				last7days.poll();
			}

			last7days.offer(new int[] { days[i], totalCost + costs[1] });

			// discarding expired 30 days pass.
			while (!last30days.isEmpty() && last30days.peek()[0] + 30 <= days[i]) {
				last30days.poll();
			}

			last30days.offer(new int[] { days[i], totalCost + costs[2] });

			// taking the min of daily pass and current valid 7 days or 30 days pass.
			totalCost = Math.min(totalCost + costs[0], Math.min(last30days.peek()[1], last7days.peek()[1]));
		}

		return totalCost;
	}

}
