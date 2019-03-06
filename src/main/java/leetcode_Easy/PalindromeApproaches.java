package leetcode_Easy;

import java.util.stream.IntStream;

public class PalindromeApproaches {
	
	/** A Simple Approach */
	public boolean palindromeOne(String input) {

		String clean = input.replaceAll("\\s", "");
		int lenght = clean.length();
		int foward = 0;
		int backward = lenght - 1;
		while (backward > foward) {

			char fowardChar = clean.charAt(foward++);
			char backwardChar = clean.charAt(backward--);
			if (fowardChar != backwardChar) {
				return false;
			}
		}
		return true;
	}

	/** StringBuilder and StringBuffer approach */
	public boolean palindromeTwo(String input) {

		String clean = input.replaceAll("\\s", "");
		StringBuilder sb = new StringBuilder();
		char[] plain = clean.toCharArray();
		for (int i = plain.length - 1; i >= 0; i--) {
			sb.append(plain[i]);
		}
		return (sb.toString()).equals(clean);
	}

	/** Stream approach */
	public boolean palindromeThree(String input) {

		String temp = input.replaceAll("\\s", "").toLowerCase();

		return IntStream.range(0, temp.length() / 2)
				.noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
	}

	/** Recursion approach */
	public boolean palindromeFour(String input) {

		String clean = input.replaceAll("\\s", "").toLowerCase();
		int foward = 0;
		int backward = clean.length() - 1;

		if (foward == backward) {
			return true;
		}
		if ((clean.charAt(foward)) != (clean.charAt(backward))) {
			return false;
		}
		if (foward < backward + 1) {
			foward++;
			backward--;
			return palindromeFour(clean);
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeApproaches palindromeApproaches = new PalindromeApproaches();
		System.out.println(palindromeApproaches.palindromeOne("racecar"));
		System.out.println(palindromeApproaches.palindromeTwo("racecar"));
		System.out.println(palindromeApproaches.palindromeThree("racecar"));
		//System.out.println(palindromeOne.palindromeFour("racecar"));
	}
}
