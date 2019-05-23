package leetcode_Easy;

public class DIStringMatch {
	public int[] diStringMatch(String S) {

		int n = S.length();
		int left = 0;
		int right = n;
		int[] res = new int[n + 1];

		for (int i = 0; i < n; ++i)
			res[i] = S.charAt(i) == 'I' ? left++ : right--;
		res[n] = left;
		return res;
	}
}
