package leetcode_Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/*218 A city's skyline is the outer contour of the silhouette formed by all the
buildings in that city when viewed from a distance. Now suppose you are given
the locations and height of all the buildings as shown on a cityscape photo
(Figure A), write a program to output the skyline formed by these buildings
collectively (Figure B). The geometric information of each building is
represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x
coordinates of the left and right edge of the ith building, respectively, and
Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX,
and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded
on an absolutely flat surface at height 0.
For instance, the dimensions of all buildings in Figure A are recorded as:
[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
The output is a list of "key points" (red dots in Figure B) in the format of
[ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
point is the left endpoint of a horizontal line segment. Note that the last key
point, where the rightmost building ends, is merely used to mark the
termination of the skyline, and always has zero height. Also, the ground in
between any two adjacent buildings should be considered part of the skyline 
contour. For instance, the skyline in Figure B should be represented as:
[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]				 */

public class TheSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {

		List<int[]> heights = new ArrayList<>();

		for (int[] b : buildings) {
			heights.add(new int[] { b[0], -b[2] });
			heights.add(new int[] { b[1], b[2] });
		}

		Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
		TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
		heightMap.put(0, 1);
		int prevHeight = 0;
		List<int[]> skyLine = new LinkedList<>();

		for (int[] h : heights) {

			if (h[1] < 0) {
				Integer cnt = heightMap.get(-h[1]);
				cnt = (cnt == null) ? 1 : cnt + 1;
				heightMap.put(-h[1], cnt);
			} else {
				Integer cnt = heightMap.get(h[1]);

				if (cnt == 1) {
					heightMap.remove(h[1]);
				} else {
					heightMap.put(h[1], cnt - 1);
				}
			}
			int currHeight = heightMap.firstKey();

			if (prevHeight != currHeight) {
				skyLine.add(new int[] { h[0], currHeight });
				prevHeight = currHeight;
			}
		}
		return skyLine;
	}
}