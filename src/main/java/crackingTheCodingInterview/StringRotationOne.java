package crackingTheCodingInterview;

public class StringRotationOne {
	public boolean stringRotationOne(String s1, String s2) {

		int s1lenght = s1.length();

		/* Check that s1 and s2 are equal in length and not empty */
		if (s1lenght == s2.length() && s1lenght > 0) {
			/* Concatenate s1 and s2 within new buffer */
			String s1s1 = s1 + s1;
			//return isSubstring(s1s1, s2);
		}
		return false;
	}
}
