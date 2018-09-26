package leetcode_Easy;

import java.util.stream.Stream;

/*500 Given a List of words, return the words that can be typed using letters
of alphabet on only one row's of American keyboard like the image below.
American keyboard
Input: ["Hello", "Alaska", "Dad", "Peace"]		Output: ["Alaska", "Dad"]	 */

public class KeyboardRow {
	public String[] findWords(String[] words) {
		
		return Stream.of(words)
				.filter(s -> s.toLowerCase()
				.matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
				.toArray(String[]::new);
	}
}
