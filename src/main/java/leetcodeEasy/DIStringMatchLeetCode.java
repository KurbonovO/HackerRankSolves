package leetcodeEasy;

public class DIStringMatchLeetCode {

	public int[] diStringMatch(String S) {
		int n = S.length(), left = 0, right = n;
		int[] res = new int[n + 1];
		for (int i = 0; i < n; ++i)
			res[i] = S.charAt(i) == 'I' ? left++ : right--;
		res[n] = left;
		return res;
	}
}
