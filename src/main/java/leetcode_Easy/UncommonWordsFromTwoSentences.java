package leetcode_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*884 We are given two sentences A and B. (A sentence is a string of space
separated words.  Each word consists only of lowercase letters.) A word is
uncommon if it appears exactly once in one of the sentences, and does not
appear in the other sentence. Return a list of all uncommon words. You may
return the list in any order.
Input: A = "this apple is sweet", B = "this apple is sour"	
Output: ["sweet","sour"]
Input: A = "apple apple", B = "banana"	Output: ["banana"]					 */

public class UncommonWordsFromTwoSentences {
	public String[] uncommonFromSentences(String A, String B) {

		Map<String, Integer> count = new HashMap<>();

		for (String word : (A + " " + B).split(" ")) {
			count.put(word, count.getOrDefault(word, 0) + 1);
		}
		ArrayList<String> output = new ArrayList<>();

		for (String w : count.keySet()) {
			
			if (count.get(w) == 1) {
				
				output.add(w);
			}
		}
		return output.toArray(new String[0]);
	}
}
