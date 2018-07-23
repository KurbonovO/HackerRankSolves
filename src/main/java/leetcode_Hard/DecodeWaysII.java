package leetcode_Hard;

/*639 A message containing letters from A-Z is being encoded to numbers using
the following mapping way:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which
can be treated as one of the numbers from 1 to 9.
Given the encoded message containing digits and the character '*', return the
total number of ways to decode it. Also, since the answer may be very large,
you should return the output mod 109 + 7.
Input: "*"	Output: 9
The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F",
"G", "H", "I".
Input: "1*" Output: 9 + 9 = 18												 */

public class DecodeWaysII {
	public int numDecodings(String stringInput) {
		
		/* initial conditions */
		long[] longArray = new long[stringInput.length() + 1];
		longArray[0] = 1;
		
		if (stringInput.charAt(0) == '0') {
			return 0;
		}
		
		longArray[1] = (stringInput.charAt(0) == '*') ? 9 : 1;

		/* bottom up method */
		for (int i = 2; i <= stringInput.length(); i++) {
			char first = stringInput.charAt(i - 2);
			char second = stringInput.charAt(i - 1);

			// For dp[i-1]
			if (second == '*') {
				longArray[i] += 9 * longArray[i - 1];
			} else if (second > '0') {
				longArray[i] += longArray[i - 1];
			}

			// For dp[i-2]
			if (first == '*') {
				
				if (second == '*') {
					longArray[i] += 15 * longArray[i - 2];
				} 
				else if (second <= '6') {
					longArray[i] += 2 * longArray[i - 2];
				} 
				else {
					longArray[i] += longArray[i - 2];
				}
			} 
			else if (first == '1' || first == '2') {
				
				if (second == '*') {
					
					if (first == '1') {
						longArray[i] += 9 * longArray[i - 2];
					} 
					else { // first == '2'
						longArray[i] += 6 * longArray[i - 2];
					}
				} else if (((first - '0') * 10 + (second - '0')) <= 26) {
					longArray[i] += longArray[i - 2];
				}
			}

			longArray[i] %= 1000000007;
		}
		return (int) longArray[stringInput.length()];
	}
}
