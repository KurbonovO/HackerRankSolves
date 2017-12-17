package leetcode_Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*187 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA. Write a function to
find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"			Return: ["AAAAACCCCC", "CCCCCAAAAA"]	*/

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		
		Set<Integer> words = new HashSet<>();
		Set<Integer> doubleWords = new HashSet<>();
		List<String> rv = new ArrayList<>();
		char[] map = new char[26];
		
	  //map['A' - 'A'] = 0;
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;

		for (int i = 0; i < s.length() - 9; i++) {
			
			int v = 0;
			
			for (int j = i; j < i + 10; j++) {
				v <<= 2;
				v |= map[s.charAt(j) - 'A'];
			}
			
			if (!words.add(v) && doubleWords.add(v)) {
				rv.add(s.substring(i, i + 10));
			}
		}
		return rv;
	}
}

/*The key point is that it is not doing hash, it is doing the exact coding of a 10-letter sequence into a 4-bytes number,
which is simply not possible for any generic string, but is possible for strings in this problem because they can have
only 4 different characters. In more detail: If two objects have same hash it means that they may or may not be equal
(though two equal objects are required to have same hash). So hashing is not enough here 
(like calling just "AACCCCCGGG".hashCode() and storing it in the map), because there can be another (different) string with
same hash and the program will output wrong result. We also cannot store the 10-letter substrings themselves because they
consume too much memory and the program will exceed memory limit.
So, instead of hashing or storing strings themselves the solution converts 10 letter string into 4-bytes integer (which is
much smaller than string in terms of consumed memory). This would not be possible if the string could contain all 26 letters
of English alphabet for example. But it is possible for our case, because there can be only 'A', 'C', 'G' and 'T' letters.
So we have only 4 possible letters, and we can use as little bits as possible to store each character of our 10-letter string.
We really need only 2 bits (bits, not bytes) for this. Specifically the solution uses the following coding:
0 = 00 (bits in binary number system) = 'A'
1 = 01 (bits in binary number system) = 'C'
2 = 10 (bits in binary number system) = 'G'
3 = 11 (bits in binary number system) = 'T'
Note that since there 10 letters and each letter requires only 2 bits, we will need only 10 * 2= 20 bits to code the string
(which is less then size of integer in java (as well as in all othere popular languages), which is 4 bytes = 32 bits).
For example, this is how "AACCTCCGGT" string will be coded:
A A C C T C C G G T
00 00 01 01 11 01 01 10 10 11 = 00000101110101101011 (binary) = 23915 (decimal)		*/