package leetcode_Easy;

/*443 Given an array of characters, compress it in-place. The length after
compression must always be smaller than or equal to the original array. Every
element of the array should be a character (not int) of length 1. After you are
done modifying the input array in-place, return the new length of the array.
Input: ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be:
["a","2","b","2","c","3"]
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

Input: ["a"]
Output: Return 1 and the first 1 characters of the input array should be: ["a"]
Nothing is replaced.

Input: ["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output: Return 4, and the first 4 characters of the input array should be:
["a","b","1","2"].
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb"
is replaced by "b12". Notice each digit has it's own entry in the array		 */

public class StringCompression {
	public int compress(char[] arrayCharsInput) {

		assert arrayCharsInput.length > 0;
		int pStart = 0; 
		int pEnd = 0; 
		int pStore = 0;
		
		while (pEnd < arrayCharsInput.length) {
			
			/*Move pEND to the first position where the current letter 
			  (at pSTART) is finished */
			while (pEnd < arrayCharsInput.length 
					&& arrayCharsInput[pEnd] == arrayCharsInput[pStart]) {
				pEnd++;
			}
			int len = pEnd - pStart;
			
			/* Store this run's letter */
			arrayCharsInput[pStore++] = arrayCharsInput[pStart];
			if (len > 1) {
				
				/*this can't be done if len == 1: will possibly overwrite 
				  [pEND], which is not processed yet */
				char[] chsLen = Integer.toString(len).toCharArray();
				
				/* Store the length of this run, digit by digit */
				for (char c : chsLen)
					arrayCharsInput[pStore++] = c;
			}
			/* bring pSTART to speed with pEND: the next run of same letters to
			   process */
			pStart = pEnd;
		}
		return pStore;
	}
}
