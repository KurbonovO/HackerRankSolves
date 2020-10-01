package leetcodeMedium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public int[][] insertInterval(int[][] intervals, int[] newInterval) {

		int start = newInterval[0];
		int end = newInterval[1];
		List<int[]> list = new ArrayList<>();

		for (int[] interval : intervals) {

			int currentStart = interval[0];
			int currentEnd = interval[1];

			if (currentStart < start) {

				list.add(new int[] { currentStart, currentEnd });
				start = currentStart;
				end = currentEnd;

			} else {

				start = Math.min(start, currentStart);
				end = Math.max(end, currentEnd);
			}
		}

		list.add(new int[] { start, end });
		int[][] result = new int[list.size()][2];

		for (int i = 0; i < list.size(); i++) {

			result[i][0] = list.get(i)[0];
			result[i][1] = list.get(i)[1];
		}
		return result;
	}

}
