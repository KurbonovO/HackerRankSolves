package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsBeck {

	public static int[][] mergeLeetCode(int[][] intervals) {

		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		
		List<int[]> result = new ArrayList<>();

		//new interval default as first arr from parameter arr.
		int[] newInterval = intervals[0];

		result.add(newInterval);

		for (int[] interval : intervals) {

			// Make sure that second number is higher than first one in single arr.
			if (interval[0] <= interval[1]) {

				
				newInterval[1] = Math.max(newInterval[1], interval[1]);

			} else {

				newInterval = interval;
				result.add(newInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {

		//int[][] arr = {{ 2, 6 }, { 1, 3 },  { 8, 10 }, { 15, 18 } };
	
		int[][] arr = { { 1, 4 }, { 4, 5 } };

		System.out.println(Arrays.toString(MergeIntervalsBeck.mergeLeetCode(arr)));

	}

}
