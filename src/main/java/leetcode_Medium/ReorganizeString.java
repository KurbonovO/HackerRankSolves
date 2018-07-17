package leetcode_Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*767 Given a string S, check if the letters can be rearranged so that two
characters that are adjacent to each other are not the same. If possible,
output any possible result.  If not possible, return the empty string.
Input: S = "aab"		Output: "aba"
Input: S = "aaab"		Output: ""											 */

public class ReorganizeString {
	public String reorganizeString(String stringInput) {

		/* Create map of each char to its count */
		Map<Character, Integer> mapCharAndInt = new HashMap<>();

		for (char c : stringInput.toCharArray()) {

			int count = mapCharAndInt.getOrDefault(c, 0) + 1;

			/* Impossible to form a solution */
			if (count > (stringInput.length() + 1) / 2) {
				return "";
			}
			mapCharAndInt.put(c, count);
		}

		 /*Greedy: fetch char of max count as next char in the result Use PriorityQueue
		   to store pairs of (char, count) and sort by count DESC*/
		PriorityQueue<int[]> priorityQueueIntArray = 
				new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (char c : mapCharAndInt.keySet()) {
			priorityQueueIntArray.add(new int[] { c, mapCharAndInt.get(c) });
		}

		/* Build the result */
		StringBuilder stringBuilder = new StringBuilder();

		while (!priorityQueueIntArray.isEmpty()) {
			int[] first = priorityQueueIntArray.poll();

			if (stringBuilder.length() == 0 
					|| first[0] != stringBuilder.charAt(stringBuilder.length() - 1)) {

				stringBuilder.append((char) first[0]);

				if (--first[1] > 0) {
					priorityQueueIntArray.add(first);
				}
			} else {
				int[] second = priorityQueueIntArray.poll();
				stringBuilder.append((char) second[0]);

				if (--second[1] > 0) {
					priorityQueueIntArray.add(second);
				}
				priorityQueueIntArray.add(first);
			}
		}
		return stringBuilder.toString();
	}
}
