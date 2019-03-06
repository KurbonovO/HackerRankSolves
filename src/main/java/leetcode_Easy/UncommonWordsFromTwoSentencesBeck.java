package leetcode_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentencesBeck {
	public String[] uncommonWordsFromTwoSentencesBeck(String A, String B) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String word : (A + " " + B).split(" ")) {

			if (!map.containsKey(word)) {
				map.put(word, 1);
			} else {
				int a = map.get(word);
				a++;
				map.put(word, a);
			}
		}
		List<String> outputInList = new ArrayList<String>();

		for (String wordFromMap : map.keySet()) {

			if (map.get(wordFromMap) == 1) {

				outputInList.add(wordFromMap);
			}
		}
		String[] output = new String[outputInList.size()];
		output = outputInList.toArray(output);
		return output;
	}

	public static void main(String[] args) {

		UncommonWordsFromTwoSentencesBeck uncommonWordsFromTwoSentencesBeck = new UncommonWordsFromTwoSentencesBeck();
		String A = "this apple is sweet";
		String B = "this apple is sour";
		System.out.println(Arrays.toString(uncommonWordsFromTwoSentencesBeck.uncommonWordsFromTwoSentencesBeck(A, B)));
	}
}
