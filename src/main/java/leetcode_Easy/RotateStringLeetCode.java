package leetcode_Easy;

public class RotateStringLeetCode {
	public boolean rotateStringLeetCode(String A, String B) {

		if (A.length() == B.length()) {

			if ((A + A).contains(B)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		RotateStringLeetCode rotateStringLeetCode = new RotateStringLeetCode();
		System.out.println(rotateStringLeetCode.rotateStringLeetCode("abcde", "cdeab"));
	}
}
