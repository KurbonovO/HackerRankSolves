package leetcode_Medium;

import java.util.List;

/*648 In English, we have a concept called root, which can be followed by some
other words to form another longer word - let's call this word successor. For
example, the root an, followed by other, which can form another word another.
Now, given a dictionary consisting of many roots and a sentence. You need to
replace all the successor in the sentence with the root forming it. If a
successor has many roots can form it, replace it with the root with the shortest
length. You need to output the sentence after the replacement.
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"										 */

public class ReplaceWords {

	public String replaceWords(List<String> dictionaryListString, String sentence) {
		String[] tokens = sentence.split(" ");
		TrieNode trieNode = buildTrie(dictionaryListString);
		return replaceWords(tokens, trieNode);
	}

	private String replaceWords(String[] tokens, TrieNode trieNode) {

		StringBuilder stringBuilder = new StringBuilder();

		for (String token : tokens) {
			stringBuilder.append(getShortestReplacement(token, trieNode));
			stringBuilder.append(" ");
		}
		return stringBuilder.substring(0, stringBuilder.length() - 1);
	}

	private String getShortestReplacement(String token, final TrieNode trieNode) {

		TrieNode temp = trieNode;
		StringBuilder stringBuilder = new StringBuilder();

		for (char charC : token.toCharArray()) {
			stringBuilder.append(charC);

			if (temp.children[charC - 'a'] != null) {

				if (temp.children[charC - 'a'].isWord) {
					return stringBuilder.toString();
				}
				temp = temp.children[charC - 'a'];
			} else {
				return token;
			}
		}
		return token;
	}

	private TrieNode buildTrie(List<String> dictionaryListString) {

		TrieNode trieNode = new TrieNode(' ');

		for (String word : dictionaryListString) {
			TrieNode temp = trieNode;
			for (char c : word.toCharArray()) {
				if (temp.children[c - 'a'] == null) {
					temp.children[c - 'a'] = new TrieNode(c);
				}
				temp = temp.children[c - 'a'];
			}
			temp.isWord = true;
		}
		return trieNode;
	}

	public class TrieNode {
		char val;
		TrieNode[] children;
		boolean isWord;

		public TrieNode(char val) {
			this.val = val;
			this.children = new TrieNode[26];
			this.isWord = false;
		}
	}
}
