package leetcodeEasy;

public class VerifyingAnAlienDictionary {

	int[] alphabetCount = new int[26];

	public boolean verifyingAnAlienDictionary(String[] words, String order) {

		for (int i = 0; i < order.length(); i++) {

			alphabetCount[order.charAt(i) - 'a'] = i;
		}
		for (int i = 1; i < words.length; i++) {

			if (bigger(words[i - 1], words[i])) {
				
				return false;
			}
		}
		return true;
	}

	public boolean bigger(String word1, String word2) {

		int word1Lenght = word1.length();
		int word2Lenght = word2.length();

		for (int i = 0; i < word1Lenght && i < word2Lenght; ++i) {

			if (word1.charAt(i) != word2.charAt(i)) {

				return alphabetCount[word1.charAt(i) - 'a'] > alphabetCount[word2.charAt(i) - 'a'];
			}
		}
		return word1Lenght > word2Lenght;
	}

}
