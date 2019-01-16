package leetcode_Easy;

public class BinaryNumberWithAlternatingBits {
	public boolean hasAlternatingBits(int n) {

		return Integer.toBinaryString(n).matches("(10)*1?");
	}
}
