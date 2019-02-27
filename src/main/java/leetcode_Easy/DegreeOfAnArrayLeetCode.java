package leetcode_Easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArrayLeetCode {
	public int degreeOfAnArrayLeetCode(int[] arr) {

		Map<Integer, int[]> map = new HashMap<Integer, int[]>();

		for (int i = 0; i < arr.length; i++) {

			if (!map.containsKey(arr[i])) {

				map.put(arr[i], new int[] { 1, i, i });
			} else {

				int[] temp = map.get(arr[i]);
				temp[0]++;
				temp[2] = i;
			}
		}

		int degree = Integer.MIN_VALUE;
		int res = Integer.MAX_VALUE;

		for (int[] value : map.values()) {

			if (value[0] > degree) {

				degree = value[0];
				res = value[2] - value[1] + 1;
			} else if (value[0] == 0) {
				res = Math.min(value[2] - value[1] + 1, res);
			}
		}
		return res;
	}

	public static void main(String[] args) {

		DegreeOfAnArrayLeetCode degreeOfAnArrayLeetCode = new DegreeOfAnArrayLeetCode();

		int[] arr = { 1, 2, 3, 4, 5, 6, 6, 7, 6 };

		System.out.println(degreeOfAnArrayLeetCode.degreeOfAnArrayLeetCode(arr));
	}
}
