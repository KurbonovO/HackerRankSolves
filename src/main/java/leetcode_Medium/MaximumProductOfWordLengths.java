package leetcode_Medium;

/*318 Given a string array words, find the maximum value of length
(word[i]) * length(word[j]) where the two words do not share common letters.
You may assume that each word will contain only lower case letters. If no such
two words exist, return 0.
Input: ["abcw","baz","foo","bar","xtfn","abcdef"]		Output: 16 
The two words can be "abcw", "xtfn".
Input: ["a","ab","abc","d","cd","bcd","abcd"]			Output: 4 
The two words can be "ab", "cd".
Input: ["a","aa","aaa","aaaa"]							Output: 0 
No such pair of words														 */

public class MaximumProductOfWordLengths {
	public static int maxProduct(String[] words) {

		if (words == null || words.length == 0) {
			return 0;
		}

		int len = words.length;
		int[] value = new int[len];

		for (int i = 0; i < len; i++) {

			String tmp = words[i];
			value[i] = 0;

			for (int j = 0; j < tmp.length(); j++) {
				value[i] |= 1 << (tmp.charAt(j) - 'a');
			}
		}

		int maxProduct = 0;

		for (int i = 0; i < len; i++) {

			for (int j = i + 1; j < len; j++) {

				if ((value[i] & value[j]) == 0 
						&& (words[i].length() * words[j].length() > maxProduct))
					maxProduct = words[i].length() * words[j].length();
			}
		}
		return maxProduct;
	}
}
