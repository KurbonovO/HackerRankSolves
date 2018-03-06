package leetcode_Easy;

/*461 The Hamming distance between two integers is the number of positions at which
the corresponding bits are different. Given two integers x and y, calculate the
Hamming distance. Note: 0 <_ x, y < 231.
Input: x = 1, y = 4
Output: 2
1   (0 0 0 1)
4   (0 1 0 0)
       |   |  
The above arrows point to positions where the corresponding bits are different*/

public class HammingDistance {
	
	public int hammingDistance(int x, int y) {
		
		int xor = x ^ y;
		int res = 0;
		
		while (xor != 0) {
			res += xor & 1;
			xor >>= 1;
		}
		return res;
	}
}
