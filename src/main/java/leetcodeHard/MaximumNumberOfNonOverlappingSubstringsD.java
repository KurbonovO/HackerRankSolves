package leetcodeHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumNumberOfNonOverlappingSubstringsD {

	int checkSubstr(String s, int i, int l[], int r[]) {
		int right = r[s.charAt(i) - 'a'];
		for (int j = i; j <= right; ++j) {
			if (l[s.charAt(j) - 'a'] < i)
				return -1;
			right = Math.max(right, r[s.charAt(j) - 'a']);
		}
		return right;
	}

	public List<String> maxNumOfSubstrings(String s) {
		int l[] = new int[26], r[] = new int[26];
		Arrays.fill(l, s.length());
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < s.length(); ++i) {
			int ch = s.charAt(i) - 'a';
			l[ch] = Math.min(l[ch], i);
			r[ch] = i;
		}
		int right = -1;
		for (int i = 0; i < s.length(); ++i)
			if (i == l[s.charAt(i) - 'a']) {
				int new_right = checkSubstr(s, i, l, r);
				if (new_right != -1) {
					if (i > right)
						res.add("");
					right = new_right;
					res.set(res.size() - 1, s.substring(i, right + 1));
				}
			}
		return res;
	}

}
