package leetcode_Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.Interval;

/*352 Given a data stream input of non-negative integers a1, a2, ..., an, ...,
summarize the numbers seen so far as a list of disjoint intervals. For example,
suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the
summary will be:
[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]																 */

public class DataStreamAsDisjointIntervals {

	/* Key - left or right boundary value of range, Value - size of range */
	private Map<Integer, Integer> ranges = new HashMap<>();

	/* Since middle val is removed, an extra set is required to de-duplicate */
	private Set<Integer> duplicate = new HashSet<>();

	public void addNum(int val) {
		
		if (!duplicate.add(val))
			return;
		
		int left = ranges.containsKey(val - 1) ? ranges.remove(val - 1) : 0;
		int right = ranges.containsKey(val + 1) ? ranges.remove(val + 1) : 0;
		int sum = left + right + 1;

		if (left > 0)
			ranges.put(val - left, sum);
		
		if (right > 0)
			ranges.put(val + right, sum);
		
		if (left == 0 || right == 0)
			/* remove middle val to speed up getInt() */
			ranges.put(val, sum); 
	}

	public List<Interval> getIntervals() {
		
		List<Interval> ret = new ArrayList<>();
		List<Integer> keys = new ArrayList<>(ranges.keySet());
		Collections.sort(keys);

		int last = Integer.MIN_VALUE;
		
		for (int left : keys) {
			int size = ranges.get(left);
			
			if (last < left) {
				ret.add(new Interval(left, left + size - 1));
				last = left + size - 1;
			}
		}
		return ret;
	}
}
