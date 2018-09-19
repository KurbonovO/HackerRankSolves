package leetcode_Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*720 Given a list of strings words representing an English Dictionary, find
the longest word in words that can be built one character at a time by other
words in words. If there is more than one possible answer, return the longest
word with the smallest lexicographical order. If there is no answer, return the
empty string.
Input: words = ["w","wo","wor","worl", "world"]			Output: "world"
The word "world" can be built one character at a time by "w", "wo", "wor", and
"worl".
Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Both "apply" and "apple" can be built from other words in the dictionary.
However, "apple" is lexicographically smaller than "apply"					 */

public class LongestWordInDictionary {
	public String longestWord(String[] words) {

		Arrays.sort(words);
		Set<String> built = new HashSet<String>();
		String output = "";

		for (String w : words) {
			
			if (w.length() == 1 
					|| built.contains(w.substring(0, w.length() - 1))) {
				
				output = w.length() > output.length() ? w : output;
				built.add(w);
			}
		}
		return output;
	}
}
