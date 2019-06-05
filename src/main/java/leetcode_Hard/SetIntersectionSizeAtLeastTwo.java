package leetcode_Hard;

import java.util.Arrays;
import java.util.Comparator;

public class SetIntersectionSizeAtLeastTwo {
	public int intersectionSizeTwo(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return (a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
			}
		});

		int m = 0, largest = -1, second = -1;

		for (int[] interval : intervals) {
			int a = interval[0], b = interval[1];

			boolean is_largest_in = (a <= largest);
			boolean is_second_in = (a <= second);

			if (is_largest_in && is_second_in)
				continue;

			m += (is_largest_in ? 1 : 2);

			second = (is_largest_in ? largest : b - 1);
			largest = b;
		}
		return m;
	}
}
