package leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public static List<Integer> getRow2(int rowIndex) {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int tmp = ret.get(j - 1) + ret.get(j);
				ret.set(j, tmp);
			}
			ret.add(1);
		}
		return ret;
	}
}
