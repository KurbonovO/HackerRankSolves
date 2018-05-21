package leetcode_Easy;

/*14 Write a function to find the longest common prefix string amongst an array
of strings. If there is no common prefix, return an empty string "".
Input: ["flower","flow","flight"]		Output: "fl"
Input: ["dog","racecar","car"]			Output: ""
There is no common prefix among the input strings							 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] stringArray) {

		if (stringArray.length == 0) {
			return "";
		}

		String prefix = stringArray[0];

		for (int intI = 1; intI < stringArray.length; intI++)

			while (stringArray[intI].indexOf(prefix) != 0)

				prefix = prefix.substring(0, prefix.length() - 1);
		
		return prefix;
	}
}
