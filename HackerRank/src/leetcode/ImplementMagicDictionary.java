package leetcode;

import java.util.HashMap;
import java.util.Map;

/*676 Implement a magic directory with buildDict, and search methods. For the method
buildDict, you'll be given a list of non-repetitive words to build a dictionary.
For the method search, you'll be given a word, and judge whether if you modify exactly
one character into another character in this word, the modified word is in the dictionary
you just built.
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False*/

public class ImplementMagicDictionary {
	class MagicDictionary {

		Map<String, Character> map;
		
	  //Initialize your data structure here.
		public MagicDictionary() {
			map = new HashMap<>();
		}

	  //Build a dictionary through a list of words
		public void buildDict(String[] dict) {
			
			for (String d : dict) {
				StringBuilder sb = new StringBuilder(d);
				
				for (int i = 0; i < sb.length(); i++) {
					sb.setCharAt(i, '*');
					map.put(sb.toString(), map.containsKey(sb.toString()) ? '*' : d.charAt(i));
					sb.setCharAt(i, d.charAt(i));
				}
			}
		}
		
		//Returns if there is any word in the trie that equals to the given word after modifying
		//exactly one character
		public boolean search(String word) {
			StringBuilder sb = new StringBuilder(word);
			
			for (int i = 0; i < sb.length(); i++) {
				sb.setCharAt(i, '*');
				
				if (map.containsKey(sb.toString()) && word.charAt(i) != map.get(sb.toString()))
					return true;
				sb.setCharAt(i, word.charAt(i));
			}
			return false;
		}
	}
}

/*For each word in dict, for each char, remove the char and put the rest of the word as
key, a pair of index of the removed char and the char as part of value list into a map. e.g.
"hello" -> {"ello":[[0, 'h']], "hllo":[[1, 'e']], "helo":[[2, 'l'],[3, 'l']], "hell":[[4, 'o']]}
During search, generate the keys as in step 1. When we see there's pair of same index but
different char in the value array, we know the answer is true. e.g.
"healo" when remove a, key is "helo" and there is a pair [2, 'l'] which has same index but
different char. Then the answer is true;*/