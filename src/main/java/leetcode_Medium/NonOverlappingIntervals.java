package leetcode_Medium;

import java.util.Comparator;
import util.Interval;

/*435 Given a collection of intervals, find the minimum number of intervals you
need to remove to make the rest of the intervals non-overlapping              */

public class NonOverlappingIntervals {

	public int eraseOverlapIntervals(Interval[] intervals) {
		
		if (intervals.length == 0)
			return 0;

		int end = intervals[0].end;
		int count = 1;

		for (int i = 1; i < intervals.length; i++) {
			
			if (intervals[i].start >= end) {	
				end = intervals[i].end;
				count++;
			}
		}
		return intervals.length - count;
	}

	class myComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.end - b.end;
		}
	}
}

/*Input: [ [1,2], [2,3], [3,4], [1,3] ]							Output: 1
[1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]									Output: 2
You need to remove two [1,2] to make the rest of intervals non-overlapping.
Input: [ [1,2], [2,3] ]											Output: 0
You don't need to remove any of the intervals since they're already 
non-overlapping																  */
