package leetcodeHard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestDuplicateSubstring {

	public String longestDupSubstring(String S) {
		// edge case
		if (S == null) {
			return null;
		}
		// binary search the max length
		int min = 0;
		int max = S.length() - 1;
		int mid;
		while (min < max - 1) {
			mid = (min + max) / 2;
			if (searchForLength(S, mid) != null) {
				min = mid;
			} else {
				max = mid - 1;
			}
		}
		String str = searchForLength(S, max);
		if (str != null) {
			return str;
		} else {
			return searchForLength(S, min);
		}
	}

	String searchForLength(String str, int len) {
		// rolling hash method
		if (len == 0) {
			return "";
		} else if (len >= str.length()) {
			return null;
		}
		Map<Long, List<Integer>> map = new HashMap<>(); // hashcode -> list of all starting idx with identical hash
		long p = (1 << 31) - 1; // prime number
		long base = 256;
		long hash = 0;
		for (int i = 0; i < len; ++i) {
			hash = (hash * base + str.charAt(i)) % p;
		}
		long multiplier = 1;
		for (int i = 1; i < len; ++i) {
			multiplier = (multiplier * base) % p;
		}
		// first substring
		List<Integer> equalHashIdx = new ArrayList<Integer>();
		equalHashIdx.add(0);
		map.put(hash, equalHashIdx);
		// other substrings
		int from = 0;
		int to = len;
		while (to < str.length()) {
			hash = ((hash + p - multiplier * str.charAt(from++) % p) * base + str.charAt(to++)) % p;
			equalHashIdx = map.get(hash);
			if (equalHashIdx == null) {
				equalHashIdx = new ArrayList<Integer>();
				map.put(hash, equalHashIdx);
			} else {
				for (int i0 : equalHashIdx) {
					if (str.substring(from, to).equals(str.substring(i0, i0 + len))) {
						return str.substring(i0, i0 + len);
					}
				}
			}
			equalHashIdx.add(from);
		}
		return null;
	}

}
