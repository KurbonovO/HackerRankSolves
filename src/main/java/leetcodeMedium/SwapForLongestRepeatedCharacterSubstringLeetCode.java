package leetcodeMedium;

import java.util.Collections;
import java.util.HashMap;

public class SwapForLongestRepeatedCharacterSubstringLeetCode {

	public static int maxRepOptBeck(String text) {

		HashMap<Character, Integer> textHashMap = new HashMap<>();

		for (int i = 0; i < text.length(); i++) {

			if (textHashMap.containsKey(text.charAt(i))) {

				int count = textHashMap.get(text.charAt(i));

				textHashMap.put(text.charAt(i), count + 1);

			} else {

				textHashMap.put(text.charAt(i), 1);
			}
		}
		return Collections.max(textHashMap.values());
	}

	public static void main(String[] args) {

		System.out.println(SwapForLongestRepeatedCharacterSubstringLeetCode.maxRepOptBeck("aaabbaaa"));
	}
}
