package leetcodeHard;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	public int longestConsecutiveSequence(int[] array) {

		int result = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int n : array) {

			if (!map.containsKey(n)) {

				int left = 0;

				if (map.containsKey(n - 1)) {
					left = map.get(n - 1);
				} else {
					left = 0;
				}

				int right = 0;

				if (map.containsKey(n + 1)) {
					right = map.get(n + 1);
				} else {
					right = 0;
				}

				// sum = length of the sequence array[i] is in
				int sum = left + right + 1;

				map.put(n, sum);

				// Keep a track of the max length
				result = Math.max(result, sum);

				// Extend the length to the boundary(s) of the sequence will do nothing if array[i] has no neighbors.
				map.put(n - left, sum);
				map.put(n + right, sum);

			} else {

				// Duplicates
				continue;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

		int[] array = new int[] { 100, 4, 200, 1, 3, 2 };

		System.out.println(longestConsecutiveSequence.longestConsecutiveSequence(array));
	}

}
