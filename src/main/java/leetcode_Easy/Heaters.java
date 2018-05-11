package leetcode_Easy;

import java.util.Arrays;

/*475 Winter is coming! Your first job during the contest is to design a standard
heater with fixed warm radius to warm all the houses. Now, you are given positions
of houses and heaters on a horizontal line, find out minimum radius of heaters so
that all houses could be covered by those heaters. So, your input will be the
positions of houses and heaters seperately, and your expected output will be the
minimum radius standard of heaters											 */

public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
		
		Arrays.sort(heaters);
		int result = 0;

		for (int house : houses) {
			
			int index = Arrays.binarySearch(heaters, house);
			
			if (index < 0) {
				index = ~index;
				int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
				int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

				result = Math.max(result, Math.min(dist1, dist2));
			}
		}
		return result;
	}
}

/*Input: [1,2,3],[2]		Output: 1
The only heater was placed in the position 2, and if we use the radius 1 standard,
then all the houses can be warmed.

Input: [1,2,3,4],[1,4]		Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use 
radius 1 standard, then all the houses can be 								 */
