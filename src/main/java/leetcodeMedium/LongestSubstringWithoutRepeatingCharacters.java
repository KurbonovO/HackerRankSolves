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

}
