package leetcode_Easy;

public class RotateStringBeck {
	public boolean rotateStringBeck(String A, String B) {

		for (int i = 0; i < A.length(); i++) {

			if (A.equals(B)) {
				return true;
			} else {
				// First make it bcde and then add the first character, thus it adds to the end.
				A = A.substring(1) + A.charAt(0);
			}
		}
		return false;
	}
	public static void main(String[] args) {

		RotateStringBeck rotateStringBeck = new RotateStringBeck();
		System.out.println(rotateStringBeck.rotateStringBeck("abcde", "cdeab"));
	}
}
