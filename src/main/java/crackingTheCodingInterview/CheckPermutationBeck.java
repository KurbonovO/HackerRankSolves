package crackingTheCodingInterview;

import java.util.Arrays;

public class CheckPermutationBeck {
	public boolean checkPermutationBeck(String a, String b) {

		char[] arrA = a.toCharArray();
		char[] arrB = b.toCharArray();

		Arrays.sort(arrA);
		Arrays.sort(arrB);

		a = new String(arrA);
		b = new String(arrB);

		if (a.contains(b)) {
			return true;
		} else if (b.contains(a)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		CheckPermutationBeck checkPermutationBeck = new CheckPermutationBeck();
		System.out.println(checkPermutationBeck.checkPermutationBeck("abc", "bbbca"));
	}
}
