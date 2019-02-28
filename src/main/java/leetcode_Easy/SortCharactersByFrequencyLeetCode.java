package leetcode_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequencyLeetCode {
	public String sortCharactersByFrequencyLeetCode(String input) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : input.toCharArray()) {

			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		List<Character>[] bucket = new List[input.length() + 1];
		for (char key : map.keySet()) {

			int frequency = map.get(key);

			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		StringBuilder sb = new StringBuilder();

		for (int pos = bucket.length - 1; pos >= 0; pos--) {

			if (bucket[pos] != null) {

				for (char c : bucket[pos]) {

					for (int i = 0; i < map.get(c); i++) {

						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SortCharactersByFrequencyLeetCode sortCharactersByFrequencyLeetCode = new SortCharactersByFrequencyLeetCode();
		System.out.println(sortCharactersByFrequencyLeetCode.sortCharactersByFrequencyLeetCode("Aabb"));
	}

}
