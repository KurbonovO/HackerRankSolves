package leetcode_Hard;

import java.util.HashMap;
import java.util.Map;

/*316 Given a string which contains only lowercase letters, remove duplicate
letters so that every letter appear once and only once. You must make sure your
result is the smallest in lexicographical order among all possible results.
Given "bcabc" 			Return "abc"
Given "cbacdcbc" 		Return "acdb"									     */

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		
		if (s == null || s.length() <= 1)
			return s;

		Map<Character, Integer> lastPosMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			lastPosMap.put(s.charAt(i), i);
		}

		char[] result = new char[lastPosMap.size()];
		int begin = 0, end = findMinLastPos(lastPosMap);

		for (int i = 0; i < result.length; i++) {
			char minChar = 'z' + 1;
			
			for (int k = begin; k <= end; k++) {
				
				if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
					minChar = s.charAt(k);
					begin = k + 1;
				}
			}
			result[i] = minChar;
			
			if (i == result.length - 1)
				break;

			lastPosMap.remove(minChar);
			
			if (s.charAt(end) == minChar)
				end = findMinLastPos(lastPosMap);
		}
		return new String(result);
	}

	private int findMinLastPos(Map<Character, Integer> lastPosMap) {
		
		if (lastPosMap == null || lastPosMap.isEmpty())
			return -1;
		int minLastPos = Integer.MAX_VALUE;
		
		for (int lastPos : lastPosMap.values()) {
			minLastPos = Math.min(minLastPos, lastPos);
		}
		return minLastPos;
	}
}