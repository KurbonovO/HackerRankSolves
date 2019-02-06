package crackingTheCodingInterview;

import java.util.Arrays;
import java.util.Scanner;

public class CheckPermutationOneRun {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String A = scanner.nextLine();
		String B = scanner.nextLine();

		scanner.close();

		if (A.length() != B.length()) {
			System.out.println("false wrong lenght");
		}

		A = sortingThePermutation(A);
		B = sortingThePermutation(B);

		if (A.equals(B)) {
			System.out.println("they are permutation");
		} else {
			System.out.println("they are not permutation");
		}
	}

	public static String sortingThePermutation(String s) {

		char[] charsOfString = s.toCharArray();
		Arrays.sort(charsOfString);
		return new String(charsOfString);
	}
}
