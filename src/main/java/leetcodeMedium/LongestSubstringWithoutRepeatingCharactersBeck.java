package leetcodeMedium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharactersBeck {

	public static int lengthOfLongestSubstringBeck(String s) {

		int count = 0;

		for (int i = 0; i < s.length(); i++) {

			for (int j = i + 1; j < s.length(); j++) {

				if (s.charAt(i) == s.charAt(j)) {

					count = 0;
					break;

				} else {

					i++;
					count++;
				}
			}
		}
		return count;
	}

	public static int lengthOfLongestSubstringLeetCode(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		int count = 0;

		for (int i = 0, j = 0; i < s.length(); ++i) {

			if (map.containsKey(s.charAt(i))) {

				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			count = Math.max(count, i - j + 1);
		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println(LongestSubstringWithoutRepeatingCharactersBeck.lengthOfLongestSubstringBeck("abcabcbb"));

		System.out.println(LongestSubstringWithoutRepeatingCharactersBeck.lengthOfLongestSubstringLeetCode("abcabcbb"));
	}
}
