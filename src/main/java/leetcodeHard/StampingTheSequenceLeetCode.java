package leetcodeHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StampingTheSequenceLeetCode {

	public int[] movesToStamp(String stamp, String target) {
		char[] aim = new char[target.length()];
		Arrays.fill(aim, '*'); // aim = "**...***"
		char[] curr = target.toCharArray();
		List<Integer> retList = new ArrayList<>();
		while (!Arrays.equals(aim, curr)) {
			int position = replace(curr, stamp);
			if (position < 0)
				return new int[0]; // impossible to traverse into "***...***"
			retList.add(position);
		}

		// Reverse the result
		int[] ret = new int[retList.size()];
		for (int i = retList.size() - 1; i >= 0; i--)
			ret[retList.size() - i - 1] = retList.get(i);
		return ret;
	}

	private int replace(char[] target, String stamp) {
		for (int i = 0; i <= target.length - stamp.length(); i++) {
			int k = i, j = 0;
			boolean match = false;
			// check if target[k:stamp.length()] equals to stamp
			// note: '*' means that position can be matched to any character
			while (k < target.length && j < stamp.length() && (target[k] == '*' || target[k] == stamp.charAt(j))) {
				// to escape the situation of target[k:stamp.length()] = "***...**"
				if (target[k] != '*')
					match = true;
				j++;
				k++;
			}

			if (j == stamp.length() && match) {
				for (k = i; k < i + stamp.length(); k++)
					target[k] = '*';
				return i;
			}
		}
		// cannot find any valid position to traverse
		return -1;
	}

}
