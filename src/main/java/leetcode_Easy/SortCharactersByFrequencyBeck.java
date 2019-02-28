package leetcode_Easy;

import java.util.Arrays;

//incorrect solution.

public class SortCharactersByFrequencyBeck {
	public String sortCharactersByFrequencyBeck(String input) {

		char[] arr = input.toCharArray();
		Arrays.sort(arr);
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {
		SortCharactersByFrequencyBeck sortCharactersByFrequencyBeck = new SortCharactersByFrequencyBeck();
		System.out.println(sortCharactersByFrequencyBeck.sortCharactersByFrequencyBeck("Aabb"));
	}
}
