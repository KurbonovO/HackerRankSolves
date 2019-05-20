package leetcode_Easy;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}
}
