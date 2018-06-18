package leetcode_Medium;

import java.util.LinkedList;
import java.util.List;

import util.Interval;

/*56 Given a collection of intervals, merge all overlapping intervals.
Input: [[1,3],[2,6],[8,10],[15,18]]				Output: [[1,6],[8,10],[15,18]]
Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Input: [[1,4],[4,5]]							Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping			 */

public class MergeIntervals {
	public List<Interval> merge(List<Interval> listInterval) {

		if (listInterval.size() <= 1) {
			return listInterval;
		}

		/* Sort by ascending starting point using an anonymous Comparator */
		listInterval.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

		List<Interval> listIntervalResult = new LinkedList<Interval>();
		int start = listInterval.get(0).start;
		int end = listInterval.get(0).end;

		for (Interval interval : listInterval) {

			/* Overlapping intervals, move the end if needed */
			if (interval.start <= end)
				end = Math.max(end, interval.end);
			
			/* Disjoint intervals, add the previous one and reset bounds */
			else {
				listIntervalResult.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		/* Add the last interval */
		listIntervalResult.add(new Interval(start, end));
		return listIntervalResult;
	}
}
