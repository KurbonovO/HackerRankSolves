package leetcode_Easy;

/*693 Given a positive integer, check whether it has alternating bits: namely,
if two adjacent bits will always have different values.
Input: 5		Output: True
The binary representation of 5 is: 101
Input: 7		Output: False
The binary representation of 7 is: 111
Input: 11		Output: False
The binary representation of 11 is: 1011
Input: 10		Output: True
The binary representation of 10 is: 1010									 */

public class BinaryNumberWithAlternatingBits {
	public boolean hasAlternatingBits(int intN) {
		
		Integer integerBit = null;
		int intIndex = 0;
		int intM = intN;

		/* Finding the index of the last 1 from right to left */
		for (int i = 0; i < 32; i++) {
			if ((intM & 1) == 1) {
				intIndex = i;
			}
			intM = intM >>> 1;
		}

		/* Looping till index found in above loop to check alternate bits */
		for (int i = 0; i <= intIndex; i++) {
			
			if (integerBit != null && integerBit == (intN & 1)) {
				return false;
			}
			integerBit = intN & 1;
			intN = intN >>> 1;
		}
		return true;
	}
}