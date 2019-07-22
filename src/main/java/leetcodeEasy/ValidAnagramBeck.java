package leetcodeEasy;

import java.util.Arrays;

public class ValidAnagramBeck {

	public static boolean validAnagramBeck(String s, String t) {

		char[] sArr = s.toCharArray();
		Arrays.sort(sArr);
		String sS = new String(sArr);

		char[] tArr = t.toCharArray();
		Arrays.sort(tArr);
		String tS = new String(tArr);

		if (sS.equals(tS)) {

			return true;

		} else {

			return false;
		}
	}

	public static void main(String[] args) {

		System.out.println(ValidAnagramBeck.validAnagramBeck("anagram", "nagaram"));
		System.out.println(ValidAnagramBeck.validAnagramBeck("car", "rat"));
	}

}
