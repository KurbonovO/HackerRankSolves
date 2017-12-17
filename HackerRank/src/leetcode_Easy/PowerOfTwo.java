package leetcode_Easy;

/*231 Given an integer, write a function to determine if it is a power of two*/

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && Integer.bitCount(n) == 1;
	}
}