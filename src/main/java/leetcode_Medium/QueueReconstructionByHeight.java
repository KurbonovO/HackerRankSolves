package leetcode_Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];
			}
		});
		List<int[]> res = new LinkedList<>();
		for (int[] cur : people) {
			res.add(cur[1], cur);
		}
		return res.toArray(new int[people.length][]);
	}
}
