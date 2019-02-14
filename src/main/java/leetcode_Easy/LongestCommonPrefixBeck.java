package leetcode_Easy;

public class LongestCommonPrefixBeck {
	public String longestCommonPrefix(String[] inputList) {

		String comparison = null;
		for (String input : inputList) {
			comparison = input.substring(0, 2);
		}

		for (String input : inputList) {
			if (input.contains(comparison)) {

			} else {

			}
		}
		return "";
	}

	public static void main(String[] args) {

		LongestCommonPrefixBeck longestCommonPrefixBeck = new LongestCommonPrefixBeck();
		String[] strArr = new String[3];
		strArr[0] = "flower";
		strArr[1] = "flow";
		strArr[2] = "flight";
		System.out.println(longestCommonPrefixBeck.longestCommonPrefix(strArr));
	}
}
