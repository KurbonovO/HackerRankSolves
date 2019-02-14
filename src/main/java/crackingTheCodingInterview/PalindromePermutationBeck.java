package crackingTheCodingInterview;

import java.util.HashMap;

public class PalindromePermutationBeck {
	public boolean palindromePermutationBeck(String input) {

		input = input.toLowerCase();

		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

		char[] inputArr = input.toCharArray();

		for (int i = 0; i < inputArr.length; i++) {

			char c = inputArr[i];

			if (hash.containsKey(c)) {
				hash.put(c, hash.get(c) + 1);
			} else {
				hash.put(c, 1);
			}
		}
		hash.remove(' ');

		int count = 0;

		for (char key : hash.keySet()) {

			count += hash.get(key) % 2;
		}
		return count <= 1;
	}

	public static void main(String[] args) {

		PalindromePermutationBeck palindromePermutationBeck = new PalindromePermutationBeck();
		System.out.println(palindromePermutationBeck.palindromePermutationBeck("aab"));
	}

}
