package leetcodeMedium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public int bruteForce(String input) {

		int result = 0;

		for (int i = 0; i < input.length(); i++) {

			for (int j = i + 1; j < input.length(); j++) {

				if (allUnique(input, i, j)) {
					result = Math.max(result, j - i);
				}
			}

		}
		return result;
	}

	public boolean allUnique(String input, int start, int end) {

		Set<Character> set = new HashSet<>();

		for (int i = start; i < end; i++) {

			Character ch = input.charAt(i);

			if (set.contains(ch)) {

				return false;
			}
			set.add(ch);
		}
		return true;
	}

	// Sliding Window: https://www.youtube.com/watch?v=3IETreEybaA
	public int slidingWindow(String s) {

		int aPointer = 0;
		int bPointer = 0;
		int max = 0;

		Set<Character> map = new HashSet<>();

		while (bPointer < s.length()) {

			if (!map.contains(s.charAt(bPointer))) {

				map.add(s.charAt(bPointer));
				bPointer++;
				max = Math.max(map.size(), max);

			} else {

				map.remove(s.charAt(aPointer));
				aPointer++;
			}
		}
		return max;
	}

	public static void main(String[] args) {

		LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();

	}

}
