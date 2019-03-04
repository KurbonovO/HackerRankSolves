package leetcode_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharactersBeck {
	public List<String> findCommonCharactersBeck(String[] arr) {

		Map<Character, Integer> countHM = new HashMap<>();
		List<String> output = new ArrayList<>();

		for (String s : arr) {

			char[] c = s.toCharArray();

			for (char one : c) {

				if (countHM.containsKey(one)) {
					int i = countHM.get(one);
					i++;
					countHM.put(one, i);
				} else {
					countHM.put(one, 1);
				}
			}
		}
		for (java.util.Map.Entry<Character, Integer> entry : countHM.entrySet()) {

			if (entry.getValue() >= 6) {
				output.add(entry.getKey().toString());
				output.add(entry.getKey().toString());
			} else if (entry.getValue() >= 3) {
				output.add(entry.getKey().toString());
			}
		}
		return output;
	}

	public static void main(String[] args) {

		FindCommonCharactersBeck findCommonCharactersBeck = new FindCommonCharactersBeck();
		String[] arr = { "bella", "label", "roller" };
		System.out.println(findCommonCharactersBeck.findCommonCharactersBeck(arr));
	}

}
