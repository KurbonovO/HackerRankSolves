package leetcode_Medium;

import java.util.Arrays;

/*452 There are a number of spherical balloons spread in two-dimensional space.
For each balloon, provided input is the start and end coordinates of the
horizontal diameter. Since it's horizontal, y-coordinates don't matter and
hence the x-coordinates of start and end of the diameter suffice. Start is
always smaller than end. There will be at most 104 balloons. An arrow can be
shot up exactly vertically from different points along the x-axis. A balloon
with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There
is no limit to the number of arrows that can be shot. An arrow once shot keeps
travelling up infinitely. The problem is to find the minimum number of arrows
that must be shot to burst all balloons.
Input:	[[10,16], [2,8], [1,6], [7,12]]	Output: 2
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8]
and [1,6]) and another arrow at x = 11 (bursting the other two balloons)	 */

public class MinimumNumberOfArrowsToBurstBalloons {
	public int findMinArrowShots(int[][] points) {

		if (points.length == 0) {
			return 0;
		}

		Arrays.sort(points, (a, b) -> a[1] - b[1]);
		int arrowPosition = points[0][1];
		int arrowCount = 1;

		for (int i = 1; i < points.length; i++) {

			if (arrowPosition >= points[i][0]) {
				continue;
			}
			arrowCount++;
			arrowPosition = points[i][1];
		}
		return arrowCount;
	}
}
