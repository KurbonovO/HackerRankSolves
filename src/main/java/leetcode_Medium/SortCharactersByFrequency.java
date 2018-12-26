package leetcode_Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*451 Given a string, sort it in decreasing order based on the frequency of
characters.
Input:	"tree"		Output: "eert"
'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before
both 'r' and 't'. Therefore "eetr" is also a valid answer.
Input:	"cccaaa" 	Output: "cccaaa"
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer. Note
that "cacaca" is incorrect, as the same characters must be together.
Input:	"Aabb"		Output: "bbAa"
"bbaA" is also a valid answer, but "Aabb" is incorrect. Note that 'A' and 'a'
are treated as two different characters										 */

public class SortCharactersByFrequency {
	public String frequencySort(String s) {

		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(
				(a, b) -> b.getValue() - a.getValue());

		priorityQueue.addAll(map.entrySet());

		StringBuilder stringBuilder = new StringBuilder();

		while (!priorityQueue.isEmpty()) {

			Map.Entry mapEntry = priorityQueue.poll();

			for (int i = 0; i < (int) mapEntry.getValue(); i++) {
				stringBuilder.append(mapEntry.getKey());
			}
		}
		return stringBuilder.toString();
	}
}
