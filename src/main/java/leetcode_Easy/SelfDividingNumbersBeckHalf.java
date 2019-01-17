package leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

/*if i = 128 number:
128 % 10 = 8, check 8 != 0;
remove 8 from next step j = 128 / 10 = 12
repeat 1 and 2 until j == 0
Time complexity is O(nm), where n = right - left, and m is number of digits in
iterated number																 */
public class SelfDividingNumbersBeckHalf {
	public List<Integer> selfDividingNumber(int left, int right) {

		List<Integer> result = new ArrayList<Integer>();

		for (int i = left; i <= right; i++) {
			
			int a = i;

			for (; a > 0; a /= 10) {

				if ((a % 10 == 0) || (i % (a % 10) != 0)) {
					
					break;
				}
				if (a == 0) {
					
					result.add(i);
				}
			}
		}
		return result;
	}
}
