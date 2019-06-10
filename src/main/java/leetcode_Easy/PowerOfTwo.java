package leetcode_Easy;

public class PowerOfTwo {

	public Boolean powerOfTwo(int n) {

		return n > 0 && (n & -n) == n;
	}
}
