package leetcode_Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ExamRoom {
	PriorityQueue<Interval> pq;
	int N;

	class Interval {
		int x, y, dist;

		public Interval(int x, int y) {
			this.x = x;
			this.y = y;
			if (x == -1) {
				this.dist = y;
			} else if (y == N) {
				this.dist = N - 1 - x;
			} else {
				this.dist = Math.abs(x - y) / 2;
			}
		}
	}

	public ExamRoom(int N) {
		this.pq = new PriorityQueue<>((a, b) -> a.dist != b.dist ? b.dist - a.dist : a.x - b.x);
		this.N = N;
		pq.add(new Interval(-1, N));
	}

	// O(logn): poll top candidate, split into two new intervals
	public int seat() {
		int seat = 0;
		Interval interval = pq.poll();
		if (interval.x == -1)
			seat = 0;
		else if (interval.y == N)
			seat = N - 1;
		else
			seat = (interval.x + interval.y) / 2;

		pq.offer(new Interval(interval.x, seat));
		pq.offer(new Interval(seat, interval.y));

		return seat;
	}

	// O(n)Find head and tail based on p. Delete and merge two ends
	public void leave(int p) {
		Interval head = null, tail = null;
		List<Interval> intervals = new ArrayList<>(pq);
		for (Interval interval : intervals) {
			if (interval.x == p)
				tail = interval;
			if (interval.y == p)
				head = interval;
			if (head != null && tail != null)
				break;
		}
		// Delete
		pq.remove(head);
		pq.remove(tail);
		// Merge
		pq.offer(new Interval(head.x, tail.y));
	}
}
