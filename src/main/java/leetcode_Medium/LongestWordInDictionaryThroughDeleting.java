package leetcode_Medium;

import java.util.List;

/*524 Given a string and a string dictionary, find the longest string in the
dictionary that can be formed by deleting some characters of the given string.
If there are more than one possible results, return the longest word with the
smallest lexicographical order. If there is no possible result, return the
empty string.
Input: s = "abpcplea", d = ["ale","apple","monkey","plea"]      Output: "apple"
Input: s = "abpcplea", d = ["a","b","c"]                         Output: "a" */

public class LongestWordInDictionaryThroughDeleting {
	public String findLongestWord(String stringS, List<String> listString) {
		
		String result = "";
		
		for (String w : listString) {
			
			if (isSubsequence(w, stringS)) {
				
				if (w.length() > result.length())
					result = w;
				
				if (w.length() == result.length() && w.compareTo(result) < 0)
					result = w;
			}
		}
		return result;
	}

	boolean isSubsequence(String w, String s) {
		char[] wc = w.toCharArray();
		char[] sc = s.toCharArray();
		
		int i = 0, j = 0;
		
		while (i < wc.length && j < sc.length) {
			
			if (wc[i] == sc[j])
				i++;
			j++;
		}
		return i == wc.length;
	}
}
