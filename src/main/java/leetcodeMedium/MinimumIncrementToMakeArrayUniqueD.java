package leetcodeMedium;

import java.util.TreeMap;

public class MinimumIncrementToMakeArrayUniqueD {

	public int minIncrementForUnique(int[] A) {
		TreeMap<Integer, Integer> count = new TreeMap<>();
		for (int a : A)
			count.put(a, count.getOrDefault(a, 0) + 1);
		int res = 0, need = 0;
		for (int x : count.keySet()) {
			int v = count.get(x);
			res += v * Math.max(need - x, 0) + v * (v - 1) / 2;
			need = Math.max(need, x) + v;
		}
		return res;
	}

}
