package leetcode_Medium;

/*467 Consider the string s to be the infinite wraparound string of 
"abcdefghijklmnopqrstuvwxyz", so s will look like this: 
"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...."
Now we have another string p. Your job is to find out how many unique non-empty
substrings of p are present in s. In particular, your input is the string p and
you need to output the number of different non-empty substrings of p in the
string s																	 */

public class UniqueSubstringsInWraparoundString {
	public int uniqueSubstringsInWraparoundStringMethod(String stringInput) {
		
		/* count[i] is the maximum unique substring end with ith letter.
		 0 - 'a', 1 - 'b', ..., 25 - 'z' */
		int[] count = new int[26];

		/* store longest contiguous substring ends at current positio */
		int maxLengthCur = 0;

		for (int i = 0; i < stringInput.length(); i++) {
			
			if (i > 0 && 
					(stringInput.charAt(i) - stringInput.charAt(i - 1) == 1 || 
					(stringInput.charAt(i - 1) - stringInput.charAt(i) == 25))) {
				maxLengthCur++;
			} else {
				maxLengthCur = 1;
			}

			int index = stringInput.charAt(i) - 'a';
			count[index] = Math.max(count[index], maxLengthCur);
		}

		/* Sum to get result */
		int sum = 0;
		
		for (int i = 0; i < 26; i++) {
			sum += count[i];
		}
		return sum;
	}
}

/*Input: "a"			Output: 1
Only the substring "a" of string "a" is in the string s.
Input: "cac"			Output: 2
There are two substrings "a", "c" of string "cac" in the string s.
Input: "zab"			Output: 6
There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in
the string s																 */ 
