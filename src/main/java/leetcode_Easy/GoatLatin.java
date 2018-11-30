package leetcode_Easy;

import java.util.Arrays;
import java.util.HashSet;

/*824 Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"									 */

public class GoatLatin {

	public static final Character[] vowelsList = 
			new Character[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
	public static final HashSet<Character> vowels = 
			new HashSet<Character>(Arrays.asList(vowelsList));

	public String toGoatLatin(String S) {
		if (S == null || S.length() == 0) {
			return "";
		}
		StringBuilder answer = new StringBuilder();
		int wordIndex = 1;

		for (String word : S.split(" ")) {
			if (wordIndex != 1) {
				answer.append(" ");
			}
			char firstCharacter = word.charAt(0);
			if (vowels.contains(firstCharacter)) {
				answer.append(word);
			} else {
				answer.append(word.substring(1));
				answer.append(firstCharacter);
			}
			answer.append("ma");
			for (int i = 0; i < wordIndex; i++) {
				answer.append("a");
			}
			wordIndex++;
		}
		return answer.toString();
	}
}
