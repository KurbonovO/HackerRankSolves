package leetcode_Easy;

/*387 Given a string, find the first non-repeating character in it and return
it's index. If it doesn't exist, return -1.
s = "leetcode"			return 0
s = "loveleetcode",		return 2											 */

public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String stringSInput) {

		int freq[] = new int[26];

		for (int i = 0; i < stringSInput.length(); i++) {
			freq[stringSInput.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < stringSInput.length(); i++)

			if (freq[stringSInput.charAt(i) - 'a'] == 1) {

				return i;
			}
		return -1;
	}
}
