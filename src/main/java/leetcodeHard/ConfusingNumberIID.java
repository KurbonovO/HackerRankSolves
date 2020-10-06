package leetcodeHard;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberIID {

	private int[] nums = { 0, 1, 6, 8, 9 };
	private Map<Integer, Integer> map;
	int count = 0;
	int limit;

	public int confusingNumberII(int N) {
		limit = N;
		map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);
		dfs(0, 0, 1);
		return count;
	}

	private void dfs(long num, long rotatedNum, int base) {
		if (num > limit)
			return;
		if (num != rotatedNum)
			count++;
		for (int d : nums) {
			if (num == 0 && d == 0)
				continue;
			dfs(num * 10 + d, map.get(d) * base + rotatedNum, base * 10);
		}
	}

}
