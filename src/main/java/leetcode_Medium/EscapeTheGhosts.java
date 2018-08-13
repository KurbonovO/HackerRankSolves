package leetcode_Medium;

/*789 You are playing a simplified Pacman game. You start at the point (0, 0),
and your destination is (target[0], target[1]). There are several ghosts on the
map, the i-th ghost starts at (ghosts[i][0], ghosts[i][1]). Each turn, you and
all ghosts simultaneously *may* move in one of 4 cardinal directions: north,
east, west, or south, going from the previous point to a new point 1 unit of 
distance away. You escape if and only if you can reach the target before any
ghost reaches you (for any given moves the ghosts may take.) If you reach any
square (including the target) at the same time as a ghost, it doesn't count as
an escape. Return True if and only if it is possible to escape				 */

public class EscapeTheGhosts {
	public boolean escapeGhosts(int[][] intArrayGhosts, int[] intArrayTarget) {

		int max = Math.abs(intArrayTarget[0]) + 
				Math.abs(intArrayTarget[1]);

		for (int[] ghost : intArrayGhosts) {

			int intN = Math.abs(ghost[0] - intArrayTarget[0]) + 
					Math.abs(ghost[1] - intArrayTarget[1]);

			if (intN <= max) {
				return false;
			}
		}
		return true;
	}
}
